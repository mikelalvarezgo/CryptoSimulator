package com.mikelalvarezgo.crypto_wolf.modules.user.behaviour

import com.mikelalvarezgo.crypto_wolf.infrastructure.BehaviourTestCase
import com.mikelalvarezgo.crypto_wolf.infrastructure.stub.user.CreateUserCommandStub
import com.mikelalvarezgo.crypto_wolf.modules.user.domain.User
import com.mikelalvarezgo.crypto_wolf.shared.domain.error.InvalidDateTime
import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.shouldBe
import org.mockito.kotlin.any
import org.mockito.kotlin.doNothing

class CreateUserUseCaseTest : BehaviourTestCase({
    given("CreateUserUseCase") {
        `when`("receive valid command") {
            then("should store user in database") {
                val command = CreateUserCommandStub.random()
                doNothing().`when`(userRepository).create(any<User>())
                val result = createUserUseCase.execute(command)
                result.isValid.shouldBe(true)
            }
        }
        `when`("receive  not valid command") {
            then("return validation error") {
                val command = CreateUserCommandStub.invalidDate()
                doNothing().`when`(userRepository).create(any<User>())
                val result = createUserUseCase.execute(command)
                result.isValid.shouldBe(false)
                result.mapLeft { it.shouldContain(InvalidDateTime(command.birthDate)) }
            }
        }
    }
})