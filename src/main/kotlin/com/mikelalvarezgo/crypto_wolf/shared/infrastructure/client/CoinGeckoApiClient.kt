package com.mikelalvarezgo.crypto_wolf.shared.infrastructure.client

import com.mikelalvarezgo.crypto_wolf.shared.domain.Currency
import com.mikelalvarezgo.crypto_wolf.shared.domain.client.CryptoClient

class CoinGeckoApiClient:CryptoClient  {
    override fun getCurrentValue(currency: Currency): Int {
        TODO("Not yet implemented")
    }

}