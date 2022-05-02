package com.mikelalvarezgo.crypto_wolf.modules.user.acceptance

import com.mikelalvarezgo.crypto_wolf.infrastructure.AcceptanceTestCase
import com.mikelalvarezgo.crypto_wolf.infrastructure.stub.user.DeleteUserCommandStub
import com.mikelalvarezgo.crypto_wolf.infrastructure.stub.user.UserIdStub
import com.mikelalvarezgo.crypto_wolf.infrastructure.stub.user.UserStub
import io.kotest.matchers.shouldBe

class DeleteUserUseCaseSpec : AcceptanceTestCase({
    feature("GetUserUseCase") {
        scenario("should validate fields and fetch user from database") {
            val userId = UserIdStub.random()
            val user = UserStub.random(userId)
            val command = DeleteUserCommandStub.random(userId.raw())
            context.userContext.repository.create(user)
            val result = context.userContext.deleteUserUseCase.execute(command)
            result.isValid.shouldBe(true)
            result.map { it shouldBe Unit }
        }
    }
})