package com.mikelalvarezgo.crypto_wolf.shared.domain.error

import arrow.core.ValidatedNel
import arrow.core.invalidNel
import arrow.core.validNel
import org.joda.time.DateTime

typealias Validation<ValidType> = ValidatedNel<ValidationError, ValidType>

object ValidationHelper {
    fun validateDate(value: String): Validation<DateTime> {
        val result = when (val parsedDateTime = DateTime.parse(value)) {
            null -> InvalidDateTime(value).invalidNel()
            else -> parsedDateTime!!.validNel()
        }
        return result
    }
}
