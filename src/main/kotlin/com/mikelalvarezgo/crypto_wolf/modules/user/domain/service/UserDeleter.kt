package com.mikelalvarezgo.crypto_wolf.modules.user.domain.service

import com.mikelalvarezgo.crypto_wolf.modules.user.domain.contract.UserNotFoundError
import com.mikelalvarezgo.crypto_wolf.modules.user.domain.contract.UserRepository
import com.mikelalvarezgo.crypto_wolf.shared.domain.UserId

class UserDeleter(private val repository: UserRepository) {
    fun delete(id: UserId): Unit {
        fun launchException(): Unit = throw UserNotFoundError(id)
        repository.find(id).fold<Unit>({ -> launchException() }, { _ -> repository.delete(id) })

    }
}