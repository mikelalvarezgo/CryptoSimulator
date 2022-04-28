package com.mikelalvarezgo.crypto_wolf.modules.user.infrastructure.api.response

import com.mikelalvarezgo.crypto_wolf.modules.user.domain.User
import kotlinx.serialization.Serializable

@Serializable
data class GetUserResponse(
    val id: String,
    val name: String,
    val surname: String,
    val birthDateTime: String,
    val taxId: String,
    val createdAt: String,
    val updatedAt: String
) {
    companion object GetUserResponseHelper {
        fun fromModel(user: User): GetUserResponse = GetUserResponse(
            user.id.raw(),
            user.name,
            user.surname,
            user.birthDateTime.toString(),
            user.taxId.value,
            user.createdAt.toString(),
            user.updatedAt.toString()
        )
    }
}
