package com.mikelalvarezgo.crypto_wolf.infrastructure.stub.user

import com.mikelalvarezgo.crypto_wolf.infrastructure.stub.generics.DatetimeStub
import com.mikelalvarezgo.crypto_wolf.infrastructure.stub.generics.StringStub
import com.mikelalvarezgo.crypto_wolf.modules.user.application.UpdateUserCommand

object UpdateUserCommandStub {
    fun random(
        id: String = UserIdStub.random().raw(),
        name: String = StringStub.random(),
        surname: String = StringStub.random(),
        birthDateTime: String = DatetimeStub.random().toString(),
        taxId: String = StringStub.random(11)
    ): UpdateUserCommand = UpdateUserCommand(id, name, surname, taxId, birthDateTime)

    fun invalidDate(
        id: String = UserIdStub.random().raw(),
        name: String = StringStub.random(),
        surname: String = StringStub.random(),
        birthDateTime: String = StringStub.random(10),
        taxId: String = StringStub.random(11)
    ): UpdateUserCommand = UpdateUserCommand(id, name, surname, taxId, birthDateTime)
}