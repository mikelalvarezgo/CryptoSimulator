package com.mikelalvarezgo.crypto_wolf.modules.user.acceptance

import com.mikelalvarezgo.crypto_wolf.infrastructure.AcceptanceTestCase
import com.mikelalvarezgo.crypto_wolf.infrastructure.stub.user.CreateUserCommandStub
import io.kotest.matchers.shouldBe

class CreateUserUseCaseSpec : AcceptanceTestCase({
    feature("CreateUserUseCase ") {
        scenario("should validate fields and store new user in database") {
            val command = CreateUserCommandStub.random()
            val result = context.userContext.createUserUseCase.execute(command)
            result.isValid.shouldBe(true)
        }
    }
})