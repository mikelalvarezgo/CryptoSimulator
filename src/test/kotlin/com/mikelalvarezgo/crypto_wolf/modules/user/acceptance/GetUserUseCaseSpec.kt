package com.mikelalvarezgo.crypto_wolf.modules.user.acceptance

import com.mikelalvarezgo.crypto_wolf.infrastructure.AcceptanceTestCase
import com.mikelalvarezgo.crypto_wolf.infrastructure.stub.user.GetUserQueryStub
import com.mikelalvarezgo.crypto_wolf.infrastructure.stub.user.UserIdStub
import com.mikelalvarezgo.crypto_wolf.infrastructure.stub.user.UserStub
import io.kotest.matchers.shouldBe

class GetUserUseCaseSpec : AcceptanceTestCase({
    feature("GetUserUseCase") {
        scenario("should validate fields and fetch user from database") {
            val userId = UserIdStub.random()
            val user = UserStub.random(userId)
            val query = GetUserQueryStub.random(userId.raw())
            context.userContext.repository.create(user)
            val result = context.userContext.getUserUseCase.execute(query)
            result.isValid.shouldBe(true)
            result.map { it shouldBe user }
        }
    }
})