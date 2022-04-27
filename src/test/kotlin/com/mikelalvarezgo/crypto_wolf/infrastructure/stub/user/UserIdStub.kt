package com.mikelalvarezgo.crypto_wolf.infrastructure.stub.user

import com.mikelalvarezgo.crypto_wolf.shared.domain.UserId
import java.util.*

object UserIdStub {
    fun random(id: UUID = UUID.randomUUID()!!): UserId = UserId(id)
}