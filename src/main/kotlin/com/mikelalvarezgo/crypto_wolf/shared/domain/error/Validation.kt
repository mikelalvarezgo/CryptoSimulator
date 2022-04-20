package com.mikelalvarezgo.crypto_wolf.shared.domain.error

import arrow.core.Validated

typealias Validation<ValidType> = Validated<ValidationError, ValidType>
