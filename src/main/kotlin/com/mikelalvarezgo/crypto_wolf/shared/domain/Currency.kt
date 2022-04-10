package com.mikelalvarezgo.crypto_wolf.shared.domain

sealed interface Currency{
    val symbol: String
}

object Bitcoin:Currency {
    override val symbol: String = "BTC"
}
