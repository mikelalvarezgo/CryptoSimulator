package com.mikelalvarezgo.crypto_wolf.shared.domain.error

class InvalidDateTime(val value: String) : ValidationError() {
    override fun toMessage(): String = "Invalid date $value"
}