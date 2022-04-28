package com.mikelalvarezgo.crypto_wolf.modules.user.domain.service

import arrow.core.getOrElse
import com.mikelalvarezgo.crypto_wolf.modules.user.domain.User
import com.mikelalvarezgo.crypto_wolf.modules.user.domain.contract.UserNotFoundError
import com.mikelalvarezgo.crypto_wolf.modules.user.domain.contract.UserRepository
import com.mikelalvarezgo.crypto_wolf.shared.domain.UserId

class UserGetter(private val repository: UserRepository) {
    fun get(id: UserId): User = repository.find(id).getOrElse { throw UserNotFoundError(id) }

}