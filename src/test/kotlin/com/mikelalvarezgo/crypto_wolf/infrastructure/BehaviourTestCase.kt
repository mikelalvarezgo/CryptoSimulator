package com.mikelalvarezgo.crypto_wolf.infrastructure

import com.mikelalvarezgo.crypto_wolf.modules.user.application.CreateUserUseCase
import com.mikelalvarezgo.crypto_wolf.modules.user.application.GetUserUseCase
import com.mikelalvarezgo.crypto_wolf.modules.user.domain.contract.UserRepository
import com.mikelalvarezgo.crypto_wolf.modules.user.domain.service.UserGetter
import io.kotest.core.spec.style.BehaviorSpec
import org.mockito.kotlin.mock

open class BehaviourTestCase(private val body: BehaviorSpec.() -> Unit = {}) : BehaviorSpec(body) {
    companion object BehaviourTestCaseHelper {
        val userRepository = mock<UserRepository>()

        val userGetter: UserGetter = UserGetter(userRepository)

        val createUserUseCase = CreateUserUseCase(userRepository)
        val getUserUseCase = GetUserUseCase(userGetter)
    }

}