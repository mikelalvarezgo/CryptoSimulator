package com.mikelalvarezgo.crypto_wolf.infrastructure.stub.user

import com.mikelalvarezgo.crypto_wolf.infrastructure.stub.generics.StringStub
import com.mikelalvarezgo.crypto_wolf.modules.user.application.GetUserQuery

object GetUserQueryStub {
    fun random(
        id: String = UserIdStub.random().raw(),
    ): GetUserQuery = GetUserQuery(id)

    fun invalidId(
        id: String =StringStub.random(),
    ): GetUserQuery = GetUserQuery(id)
}