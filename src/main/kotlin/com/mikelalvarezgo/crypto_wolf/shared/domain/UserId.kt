package com.mikelalvarezgo.crypto_wolf.shared.domain

import arrow.core.Option
import arrow.core.invalidNel
import arrow.core.validNel
import com.mikelalvarezgo.crypto_wolf.shared.domain.error.InvalidUserId
import com.mikelalvarezgo.crypto_wolf.shared.domain.error.Validation
import java.util.*


data class UserId(val value: UUID) {
    fun raw(): String = value.toString()

    companion object UserIdCompanion {
        private fun isValid(value: String): Boolean = Option(UUID.fromString(value)).isDefined()
        fun unsafe(value: String): UserId =
            if (isValid(value)) throw InvalidUserId(value) else UserId(UUID.fromString(value))

        fun fromString(value: String): Validation<UserId> =
            if (isValid(value)) UserId(UUID.fromString(value)).validNel() else InvalidUserId(value).invalidNel()
    }
}

