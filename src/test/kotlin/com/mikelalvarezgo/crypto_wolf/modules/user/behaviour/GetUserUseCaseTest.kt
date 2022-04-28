package com.mikelalvarezgo.crypto_wolf.modules.user.behaviour

import arrow.core.none
import arrow.core.some
import com.mikelalvarezgo.crypto_wolf.infrastructure.BehaviourTestCase
import com.mikelalvarezgo.crypto_wolf.infrastructure.stub.user.GetUserQueryStub
import com.mikelalvarezgo.crypto_wolf.infrastructure.stub.user.UserIdStub
import com.mikelalvarezgo.crypto_wolf.infrastructure.stub.user.UserStub
import com.mikelalvarezgo.crypto_wolf.modules.user.domain.contract.UserNotFoundError
import com.mikelalvarezgo.crypto_wolf.shared.domain.error.InvalidUserId
import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.shouldBe
import org.mockito.kotlin.whenever

class GetUserUseCaseTest : BehaviourTestCase({
    given("GetUserUseCase") {
        `when`("receive valid query") {
            then("fetch user in database") {
                val userId = UserIdStub.random()
                val query = GetUserQueryStub.random(userId.raw())
                val user = UserStub.random(userId)
                whenever(userRepository.find(userId)).thenReturn(user.some())
                val result = getUserUseCase.execute(query)
                result.isValid.shouldBe(true)
                result.map { it shouldBe user }
            }
        }
        `when`("receive  not valid command") {
            then("return validation error") {
                val query = GetUserQueryStub.invalidId()
                val result = getUserUseCase.execute(query)
                result.isValid.shouldBe(false)
                result.mapLeft { it.shouldContain(InvalidUserId(query.id)) }
            }
        }
        `when`("receive query of non existent user") {
            then("return domain error") {
                val userId = UserIdStub.random()
                val query = GetUserQueryStub.random(userId.raw())
                whenever(userRepository.find(userId)).thenReturn(none())
                shouldThrowExactly<UserNotFoundError> {
                    getUserUseCase.execute(query)
                }
            }
        }
    }
})