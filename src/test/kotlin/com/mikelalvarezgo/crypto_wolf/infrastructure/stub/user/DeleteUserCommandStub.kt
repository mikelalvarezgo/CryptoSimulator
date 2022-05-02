package com.mikelalvarezgo.crypto_wolf.infrastructure.stub.user

import com.mikelalvarezgo.crypto_wolf.infrastructure.stub.generics.StringStub
import com.mikelalvarezgo.crypto_wolf.modules.user.application.DeleteUserCommand

object DeleteUserCommandStub {
    fun random(
        id: String = UserIdStub.random().raw(),
    ): DeleteUserCommand = DeleteUserCommand(id)

    fun invalidId(
        id: String = StringStub.random(),
    ): DeleteUserCommand = DeleteUserCommand(id)
}