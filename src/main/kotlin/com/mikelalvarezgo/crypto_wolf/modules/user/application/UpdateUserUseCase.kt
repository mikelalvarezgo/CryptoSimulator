package com.mikelalvarezgo.crypto_wolf.modules.user.application

import arrow.core.valid
import arrow.core.zip
import arrow.typeclasses.Semigroup
import com.mikelalvarezgo.crypto_wolf.modules.user.domain.service.UserUpdater
import com.mikelalvarezgo.crypto_wolf.shared.domain.Command
import com.mikelalvarezgo.crypto_wolf.shared.domain.TaxId
import com.mikelalvarezgo.crypto_wolf.shared.domain.UseCase
import com.mikelalvarezgo.crypto_wolf.shared.domain.UserId
import com.mikelalvarezgo.crypto_wolf.shared.domain.error.Validation
import com.mikelalvarezgo.crypto_wolf.shared.domain.error.ValidationError
import com.mikelalvarezgo.crypto_wolf.shared.domain.error.ValidationHelper

class UpdateUserUseCase(val updater: UserUpdater) : UseCase<UpdateUserCommand, Unit> {
    override fun execute(request: UpdateUserCommand): Validation<Unit> {
        val validUserId = UserId.fromString(request.id)
        val validTaxId = TaxId.fromString(request.taxId)
        val validDate = ValidationHelper.validateDate(request.birthDate)
        val result: Validation<Unit> = validUserId.zip(
            Semigroup.nonEmptyList<ValidationError>(),
            validTaxId,
            request.surname.valid(),
            request.surname.valid(),
            validDate
        ) { userId, taxId, name, surname, birthDate ->
            updater.update(userId, name, surname, taxId, birthDate)
        }
        return result
    }
}

data class UpdateUserCommand(
    val id: String,
    val name: String,
    val surname: String,
    val taxId: String,
    val birthDate: String
) : Command {}
