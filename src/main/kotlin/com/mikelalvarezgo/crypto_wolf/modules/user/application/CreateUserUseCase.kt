package com.mikelalvarezgo.crypto_wolf.modules.user.application

import arrow.core.valid
import arrow.core.zip
import arrow.typeclasses.Semigroup
import com.mikelalvarezgo.crypto_wolf.modules.user.domain.User
import com.mikelalvarezgo.crypto_wolf.modules.user.domain.contract.UserRepository
import com.mikelalvarezgo.crypto_wolf.shared.domain.Command
import com.mikelalvarezgo.crypto_wolf.shared.domain.TaxId
import com.mikelalvarezgo.crypto_wolf.shared.domain.UseCase
import com.mikelalvarezgo.crypto_wolf.shared.domain.UserId
import com.mikelalvarezgo.crypto_wolf.shared.domain.error.Validation
import com.mikelalvarezgo.crypto_wolf.shared.domain.error.ValidationError
import com.mikelalvarezgo.crypto_wolf.shared.domain.error.ValidationHelper
import org.joda.time.DateTime

class CreateUserUseCase(val repository: UserRepository) : UseCase<CreateUserCommand, Unit> {
    override fun execute(request: CreateUserCommand): Validation<Unit> =
        validate(request).map { repository.create(it) }

    private fun validate(request: CreateUserCommand): Validation<User> {
        val validUserId = UserId.fromString(request.id)
        val validTaxId = TaxId.fromString(request.taxId)
        val validDate = ValidationHelper.validateDate(request.birthDate)
        val validatedUser: Validation<User> = validUserId.zip(
            Semigroup.nonEmptyList<ValidationError>(),
            validTaxId,
            request.surname.valid(),
            request.surname.valid(),
            validDate
        ) { userId, taxId, name, surname, birthDate ->
            User(userId, name, surname, birthDate, taxId, DateTime.now(), DateTime.now())
        }
        return validatedUser
    }
}

data class CreateUserCommand(
    val id: String,
    val name: String,
    val surname: String,
    val taxId: String,
    val birthDate: String
) : Command {}
