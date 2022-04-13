package com.mikelalvarezgo.crypto_wolf.infrastructure.stub

import com.mikelalvarezgo.crypto_wolf.infrastructure.stub.generics.IntStub
import com.mikelalvarezgo.crypto_wolf.shared.domain.Currency

object CurrencyStub {
    fun random(): Currency =
        Currency.values.get(IntStub.between(1, Currency.values.size))
}