package com.mikelalvarezgo.crypto_wolf.infrastructure

import com.mikelalvarezgo.crypto_wolf.modules.user.application.CreateUserUseCase
import com.mikelalvarezgo.crypto_wolf.modules.user.domain.contract.UserRepository
import io.kotest.core.spec.style.BehaviorSpec
import org.mockito.kotlin.mock

open class BehaviourTestCase(private val body: BehaviorSpec.() -> Unit = {}) : BehaviorSpec(body) {
    companion object BehaviourTestCaseHelper {
        val userRepository = mock<UserRepository>()
        val createUserUseCase = CreateUserUseCase(userRepository)
    }

}