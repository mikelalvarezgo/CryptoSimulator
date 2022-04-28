package com.mikelalvarezgo.crypto_wolf.modules.user.application

import com.mikelalvarezgo.crypto_wolf.modules.user.domain.User
import com.mikelalvarezgo.crypto_wolf.modules.user.domain.service.UserGetter
import com.mikelalvarezgo.crypto_wolf.shared.domain.Query
import com.mikelalvarezgo.crypto_wolf.shared.domain.UseCase
import com.mikelalvarezgo.crypto_wolf.shared.domain.UserId
import com.mikelalvarezgo.crypto_wolf.shared.domain.error.Validation

class GetUserUseCase(val getter: UserGetter) : UseCase<GetUserQuery, User> {
    override fun execute(request: GetUserQuery): Validation<User> =
        validate(request).map { getter.get(it) }

    private fun validate(request: GetUserQuery): Validation<UserId> = UserId.fromString(request.id)
}

data class GetUserQuery(
    val id: String
) : Query<User> {}
