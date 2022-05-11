package com.mikelalvarezgo.crypto_wolf.shared.domain.error

class InvalidPortfolioId(val value: String) : ValidationError() {
    override fun toMessage(): String = "Invalid portfolioId $value"
}