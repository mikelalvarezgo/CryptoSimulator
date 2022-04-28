package com.mikelalvarezgo.crypto_wolf.modules.user.domain.contract;

import com.mikelalvarezgo.crypto_wolf.shared.domain.UserId;
import com.mikelalvarezgo.crypto_wolf.shared.domain.error.DomainError

class UserNotFoundError(private val value: UserId) : DomainError() {
    override fun toMessage(): String = "User $value not found"


}
