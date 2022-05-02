package com.mikelalvarezgo.crypto_wolf.modules.user.infrastructure.api

import com.mikelalvarezgo.crypto_wolf.modules.user.application.*
import com.mikelalvarezgo.crypto_wolf.modules.user.infrastructure.api.request.CreateUserRequest
import com.mikelalvarezgo.crypto_wolf.modules.user.infrastructure.api.response.GetUserResponse
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

class UserController(
    createUserUseCase: CreateUserUseCase,
    getUserUseCase: GetUserUseCase,
    deleteUserUseCase: DeleteUserUseCase
) {
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
            get("/{id}") {
                val id = call.parameters["id"]
                if (id == null)
                    call.respondText("Id not defined in path", status = HttpStatusCode.BadRequest)
                else {
                    val result = getUserUseCase.execute(GetUserQuery(id))
                    if (result.isValid) {
                        call.respondText("Deleted", status = HttpStatusCode.OK)
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
            delete("/{id}") {
                val id = call.parameters["id"]
                if (id == null)
                    call.respondText("Id not defined in path", status = HttpStatusCode.BadRequest)
                else {
                    val result = deleteUserUseCase.execute(DeleteUserCommand(id))
                    if (result.isValid) {
                        result.map { call.respond(GetUserResponse.fromModel(it)) }
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
    }
}