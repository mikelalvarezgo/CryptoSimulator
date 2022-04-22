package com.mikelalvarezgo.crypto_wolf.shared.domain.error

class InvalidTaxId(val value: String) : ValidationError() {
    override fun toMessage(): String = "Invalid taxId $value"
}