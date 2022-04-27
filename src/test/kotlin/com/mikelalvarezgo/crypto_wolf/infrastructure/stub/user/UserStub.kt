package com.mikelalvarezgo.crypto_wolf.infrastructure.stub.user

import com.mikelalvarezgo.crypto_wolf.infrastructure.stub.generics.DatetimeStub
import com.mikelalvarezgo.crypto_wolf.infrastructure.stub.generics.StringStub
import com.mikelalvarezgo.crypto_wolf.modules.user.domain.User
import com.mikelalvarezgo.crypto_wolf.shared.domain.TaxId
import com.mikelalvarezgo.crypto_wolf.shared.domain.UserId
import org.joda.time.DateTime

object UserStub {
    fun random(
        id: UserId = UserIdStub.random(),
        name: String = StringStub.random(),
        surname: String = StringStub.random(),
        birthDateTime: DateTime = DatetimeStub.random(),
        taxId: TaxId = TaxIdStub.random(),
        createdAt: DateTime = DatetimeStub.now(),
        updatedAt: DateTime = DatetimeStub.now()
    ): User = User(id, name, surname, birthDateTime, taxId, createdAt, updatedAt)

}