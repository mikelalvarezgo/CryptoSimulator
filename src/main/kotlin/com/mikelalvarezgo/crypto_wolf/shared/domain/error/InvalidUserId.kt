package com.mikelalvarezgo.crypto_wolf.shared.domain.error

class InvalidUserId(val value: String) : ValidationError() {
    override fun toMessage(): String = "Invalid userId $value"
}