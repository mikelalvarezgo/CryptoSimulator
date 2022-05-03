package com.mikelalvarezgo.crypto_wolf.modules.user.infrastructure.api.request

import com.mikelalvarezgo.crypto_wolf.modules.user.application.UpdateUserCommand
import kotlinx.serialization.Serializable

@Serializable
data class UpdateUserRequest(
    val id: String,
    val name: String,
    val surname: String,
    val taxId: String,
    val birthDate: String
) {
    fun toCommand(): UpdateUserCommand = UpdateUserCommand(id, name, surname, taxId, birthDate)
}