package com.mikelalvarezgo.crypto_wolf.modules.user.behaviour

import arrow.core.none
import arrow.core.some
import com.mikelalvarezgo.crypto_wolf.infrastructure.BehaviourTestCase
import com.mikelalvarezgo.crypto_wolf.infrastructure.stub.user.UpdateUserCommandStub
import com.mikelalvarezgo.crypto_wolf.infrastructure.stub.user.UserIdStub
import com.mikelalvarezgo.crypto_wolf.infrastructure.stub.user.UserStub
import com.mikelalvarezgo.crypto_wolf.modules.user.domain.User
import com.mikelalvarezgo.crypto_wolf.modules.user.domain.contract.UserNotFoundError
import com.mikelalvarezgo.crypto_wolf.shared.domain.error.InvalidDateTime
import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.shouldBe
import org.mockito.kotlin.any
import org.mockito.kotlin.doNothing
import org.mockito.kotlin.whenever

class UpdateUserUseCaseTest : BehaviourTestCase({
    given("UpdateUserUseCase") {
        `when`("receive valid command") {
            then("should update user in database if exists") {
                val userId = UserIdStub.random()
                val user = UserStub.random(userId)
                val command = UpdateUserCommandStub.random(userId.raw())
                doNothing().`when`(userRepository).update(any<User>())
                whenever(userRepository.find(userId)).thenReturn(user.some())
                val result = updateUserUseCase.execute(command)
                result.isValid.shouldBe(true)
            }
            then("should fail user in database if does not exist") {
                val userId = UserIdStub.random()
                val command = UpdateUserCommandStub.random(userId.raw())
                whenever(userRepository.find(userId)).thenReturn(none())
                shouldThrowExactly<UserNotFoundError> {
                    updateUserUseCase.execute(command)
                }
            }
        }
        `when`("receive  not valid command") {
            then("return validation error") {
                val command = UpdateUserCommandStub.invalidDate()
                val result = updateUserUseCase.execute(command)
                result.isValid.shouldBe(false)
                result.mapLeft { it.shouldContain(InvalidDateTime(command.birthDate)) }
            }
        }
    }
})