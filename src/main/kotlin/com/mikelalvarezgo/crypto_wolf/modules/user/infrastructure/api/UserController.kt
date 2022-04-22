package com.mikelalvarezgo.crypto_wolf.modules.user.infrastructure.api

import com.mikelalvarezgo.crypto_wolf.modules.user.application.CreateUserUseCase
import com.mikelalvarezgo.crypto_wolf.modules.user.infrastructure.api.request.CreateUserRequest
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

class UserController(createUserUseCase: CreateUserUseCase) {
    val routes: Routing.() -> Unit = {
        route("/user") {
            post {
                val request = call.receive<CreateUserRequest>()
                val result = createUserUseCase.execute(request.toCommand())
                if (result.isValid) {
                    call.respondText("Created", status = HttpStatusCode.Created)
                } else {
                    result.mapLeft { errors ->
                        call.respondText(
                            errors.fold("") { message, error -> message + "," + error.toMessage() },
                            status = HttpStatusCode.BadRequest
                        )
                    }

                }
            }
        }
    }