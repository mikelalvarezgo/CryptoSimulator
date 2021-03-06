package com.mikelalvarezgo.crypto_wolf.infrastructure

import com.mikelalvarezgo.crypto_wolf.modules.user.application.CreateUserUseCase
import com.mikelalvarezgo.crypto_wolf.modules.user.application.DeleteUserUseCase
import com.mikelalvarezgo.crypto_wolf.modules.user.application.GetUserUseCase
import com.mikelalvarezgo.crypto_wolf.modules.user.application.UpdateUserUseCase
import com.mikelalvarezgo.crypto_wolf.modules.user.domain.contract.UserRepository
import com.mikelalvarezgo.crypto_wolf.modules.user.domain.service.UserDeleter
import com.mikelalvarezgo.crypto_wolf.modules.user.domain.service.UserGetter
import com.mikelalvarezgo.crypto_wolf.modules.user.domain.service.UserUpdater
import io.kotest.core.spec.style.BehaviorSpec
import org.mockito.kotlin.mock

open class BehaviourTestCase(private val body: BehaviorSpec.() -> Unit = {}) : BehaviorSpec(body) {
    companion object BehaviourTestCaseHelper {
        val userRepository = mock<UserRepository>()

        val userGetter: UserGetter = UserGetter(userRepository)
        val userUpdater: UserUpdater = UserUpdater(userRepository)
        val userDeleter: UserDeleter = UserDeleter(userRepository)

        val createUserUseCase = CreateUserUseCase(userRepository)
        val updateUserUseCase = UpdateUserUseCase(userUpdater)
        val getUserUseCase = GetUserUseCase(userGetter)
        val deleteUserUseCase = DeleteUserUseCase(userDeleter)
    }

}