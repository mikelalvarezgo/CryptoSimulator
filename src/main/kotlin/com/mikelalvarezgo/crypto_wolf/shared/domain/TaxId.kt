package com.mikelalvarezgo.crypto_wolf.shared.domain

import arrow.core.invalidNel
import arrow.core.validNel
import com.mikelalvarezgo.crypto_wolf.shared.domain.error.InvalidTaxId
import com.mikelalvarezgo.crypto_wolf.shared.domain.error.Validation

data class TaxId(val value: String) {
    fun raw(): String = value.toString()

    companion object TaxIdCompanion {
        private fun isValid(value: String): Boolean = value.length == 11
        fun unsafe(value: String): TaxId =
            if (isValid(value)) TaxId(value) else throw InvalidTaxId(value)

        fun fromString(value: String): Validation<TaxId> =
            if (isValid(value)) TaxId(value).validNel() else InvalidTaxId(value).invalidNel()
    }
}
