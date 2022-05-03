package com.mikelalvarezgo.crypto_wolf.modules.user.acceptance

import com.mikelalvarezgo.crypto_wolf.infrastructure.AcceptanceTestCase
import com.mikelalvarezgo.crypto_wolf.infrastructure.stub.user.UpdateUserCommandStub
import com.mikelalvarezgo.crypto_wolf.infrastructure.stub.user.UserIdStub
import com.mikelalvarezgo.crypto_wolf.infrastructure.stub.user.UserStub
import io.kotest.matchers.shouldBe

class UpdateUserUseCaseSpec : AcceptanceTestCase({
    feature("CreateUserUseCase ") {
        scenario("should validate fields and store new user in database") {
            val userId = UserIdStub.random()
            val command = UpdateUserCommandStub.random(userId.raw())
            val user = UserStub.random(userId)
            context.userContext.repository.create(user)
            val result = context.userContext.updateUserUseCase.execute(command)
            result.isValid.shouldBe(true)
        }
    }
})