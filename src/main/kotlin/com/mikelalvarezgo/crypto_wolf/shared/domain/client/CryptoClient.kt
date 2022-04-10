package com.mikelalvarezgo.crypto_wolf.shared.domain.client

import com.mikelalvarezgo.crypto_wolf.shared.domain.Currency

interface CryptoClient {
    fun getCurrentValue(currency: Currency): Int
}