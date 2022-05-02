package com.mikelalvarezgo.crypto_wolf.modules.user.application

import com.mikelalvarezgo.crypto_wolf.modules.user.domain.service.UserDeleter
import com.mikelalvarezgo.crypto_wolf.shared.domain.Command
import com.mikelalvarezgo.crypto_wolf.shared.domain.UseCase
import com.mikelalvarezgo.crypto_wolf.shared.domain.UserId
import com.mikelalvarezgo.crypto_wolf.shared.domain.error.Validation

class DeleteUserUseCase(private val deleter: UserDeleter) : UseCase<DeleteUserCommand, Unit> {
    override fun execute(request: DeleteUserCommand): Validation<Unit> =
        validate(request).map { deleter.delete(it) }

    private fun validate(request: DeleteUserCommand): Validation<UserId> = UserId.fromString(request.id)
}

data class DeleteUserCommand(
    val id: String
) : Command {}
