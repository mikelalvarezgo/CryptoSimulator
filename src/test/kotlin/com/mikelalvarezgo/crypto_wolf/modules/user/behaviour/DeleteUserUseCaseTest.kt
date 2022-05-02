package com.mikelalvarezgo.crypto_wolf.modules.user.behaviour

import arrow.core.none
import arrow.core.some
import com.mikelalvarezgo.crypto_wolf.infrastructure.BehaviourTestCase
import com.mikelalvarezgo.crypto_wolf.infrastructure.stub.user.DeleteUserCommandStub
import com.mikelalvarezgo.crypto_wolf.infrastructure.stub.user.UserIdStub
import com.mikelalvarezgo.crypto_wolf.infrastructure.stub.user.UserStub
import com.mikelalvarezgo.crypto_wolf.modules.user.domain.contract.UserNotFoundError
import com.mikelalvarezgo.crypto_wolf.shared.domain.error.InvalidUserId
import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.shouldBe
import org.mockito.kotlin.doNothing
import org.mockito.kotlin.whenever

class DeleteUserUseCaseTest : BehaviourTestCase({
    given("DeleteUserUseCase") {
        `when`("receive valid command") {
            then("delete user in database") {
                val userId = UserIdStub.random()
                val command = DeleteUserCommandStub.random(userId.raw())
                val user = UserStub.random(userId)
                whenever(userRepository.find(userId)).thenReturn(user.some())
                doNothing().`when`(userRepository).delete(userId)

                val result = deleteUserUseCase.execute(command)
                result.isValid.shouldBe(true)
                result.map { it shouldBe Unit }
            }
        }
        `when`("receive  not valid command") {
            then("return validation error") {
                val command = DeleteUserCommandStub.invalidId()
                val result = deleteUserUseCase.execute(command)
                result.isValid.shouldBe(false)
                result.mapLeft { it.shouldContain(InvalidUserId(command.id)) }
            }
        }
        `when`("receive query of non existent user") {
            then("return domain error") {
                val userId = UserIdStub.random()
                val command = DeleteUserCommandStub.random(userId.raw())
                whenever(userRepository.find(userId)).thenReturn(none())
                shouldThrowExactly<UserNotFoundError> {
                    deleteUserUseCase.execute(command)
                }
            }
        }
    }
})