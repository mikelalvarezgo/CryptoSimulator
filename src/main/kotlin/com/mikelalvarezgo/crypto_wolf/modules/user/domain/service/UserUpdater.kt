package com.mikelalvarezgo.crypto_wolf.modules.user.domain.service

import com.mikelalvarezgo.crypto_wolf.modules.user.domain.contract.UserNotFoundError
import com.mikelalvarezgo.crypto_wolf.modules.user.domain.contract.UserRepository
import com.mikelalvarezgo.crypto_wolf.shared.domain.TaxId
import com.mikelalvarezgo.crypto_wolf.shared.domain.UserId
import org.joda.time.DateTime

class UserUpdater(private val repository: UserRepository) {
    fun update(id: UserId, name: String, surName: String, taxId: TaxId, birthDate: DateTime): Unit {
        fun launchException(): Unit = throw UserNotFoundError(id)
        repository.find(id).fold<Unit>({ -> launchException() }, { user ->
            repository.update(user.withName(name).withSurname(surName).withTaxId(taxId).withBirthDay(birthDate))
        })
    }
}