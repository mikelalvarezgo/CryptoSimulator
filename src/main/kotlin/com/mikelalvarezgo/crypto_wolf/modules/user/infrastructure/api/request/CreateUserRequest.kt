package com.mikelalvarezgo.crypto_wolf.modules.user.infrastructure.api.request

import com.mikelalvarezgo.crypto_wolf.modules.user.application.CreateUserCommand
import kotlinx.serialization.Serializable

@Serializable
data class CreateUserRequest(
    val id: String,
    val name: String,
    val surname: String,
    val taxId: String,
    val birthDate: String
) {
    fun toCommand(): CreateUserCommand = CreateUserCommand(id, name, surname, taxId, birthDate)
}