package com.mikelalvarezgo.crypto_wolf.modules.user.domain.contract

import arrow.core.Option
import com.mikelalvarezgo.crypto_wolf.modules.user.domain.User
import com.mikelalvarezgo.crypto_wolf.shared.domain.UserId

interface UserRepository {
    fun create(user: User): Unit
    fun update(user: User): Unit
    fun find(id: UserId): Option<User>
    fun delete(id: UserId): Unit
}