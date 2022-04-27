package com.mikelalvarezgo.crypto_wolf.shared.domain.error

import arrow.core.ValidatedNel
import arrow.core.invalidNel
import arrow.core.validNel
import org.joda.time.DateTime

typealias Validation<ValidType> = ValidatedNel<ValidationError, ValidType>

object ValidationHelper {
    fun validateDate(value: String): Validation<DateTime> {
        val parsedDateTime = try {
            DateTime.parse(value)
        } catch (e: Throwable) {
            null
        }
        val result = when (parsedDateTime) {
            null -> InvalidDateTime(value).invalidNel()
            else -> parsedDateTime!!.validNel()
        }
        return result
    }
}
