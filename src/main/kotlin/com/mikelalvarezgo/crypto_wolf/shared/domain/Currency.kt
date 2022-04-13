package com.mikelalvarezgo.crypto_wolf.shared.domain

sealed interface Currency {
    val symbol: String

    companion object CurrencyHelper {
        val values: List<Currency> =
            listOf<Currency>(Bitcoin, Ethereum)
    }

}

object Bitcoin : Currency {
    override val symbol: String = "BTC"
}

object Ethereum : Currency {
    override val symbol: String = "ETH"
}
