package com.mikelalvarezgo.crypto_wolf.shared.domain.error

abstract class ValidationError : Throwable() {
    abstract fun toMessage(): String
}
