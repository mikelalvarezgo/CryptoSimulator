package com.mikelalvarezgo.crypto_wolf.shared.domain

import arrow.core.invalidNel
import arrow.core.validNel
import com.mikelalvarezgo.crypto_wolf.shared.domain.error.InvalidUserId
import com.mikelalvarezgo.crypto_wolf.shared.domain.error.Validation
import java.util.*


data class PortfolioId(val value: UUID) {
    fun raw(): String = value.toString()

    companion object UserIdCompanion {
        private fun isValid(value: String): Boolean {
            val idNullable: UUID? =
                try {
                    UUID.fromString(value)
                } catch (e: Throwable) {
                    null
                }
            return idNullable != null
        }

        fun unsafe(value: String): PortfolioId =
            if (isValid(value)) PortfolioId(UUID.fromString(value)) else throw InvalidUserId(value)

        fun fromString(value: String): Validation<PortfolioId> =
            if (isValid(value)) PortfolioId(UUID.fromString(value)).validNel() else InvalidUserId(value).invalidNel()
    }
}

