package com.mikelalvarezgo.crypto_wolf.shared.domain.error

abstract class DomainError : Throwable() {
    abstract fun toMessage(): String
}
