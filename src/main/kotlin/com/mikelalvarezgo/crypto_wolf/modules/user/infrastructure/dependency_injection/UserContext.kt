package com.mikelalvarezgo.crypto_wolf.modules.user.infrastructure.dependency_injection

import com.mikelalvarezgo.crypto_wolf.modules.user.application.CreateUserUseCase
import com.mikelalvarezgo.crypto_wolf.modules.user.domain.contract.UserRepository
import com.mikelalvarezgo.crypto_wolf.modules.user.infrastructure.api.UserController
import com.mikelalvarezgo.crypto_wolf.modules.user.infrastructure.persistence.MariaDbUserRepository
import com.mikelalvarezgo.crypto_wolf.shared.domain.contract.Logger
import com.mikelalvarezgo.crypto_wolf.shared.infrastructure.dependency_injection.Context
import io.ktor.server.routing.*

class UserContext(logger: Logger) : Context {
    val repository: UserRepository = MariaDbUserRepository()

    val createUserUseCase: CreateUserUseCase = CreateUserUseCase(repository)

    override val routes: Routing.() -> Unit = UserController(createUserUseCase).routes

}