package com.mikelalvarezgo.crypto_wolf.infrastructure.stub

import com.mikelalvarezgo.crypto_wolf.infrastructure.stub.generics.DatetimeStub
import com.mikelalvarezgo.crypto_wolf.infrastructure.stub.generics.DoubleStub
import com.mikelalvarezgo.crypto_wolf.shared.domain.Currency
import com.mikelalvarezgo.crypto_wolf.shared.domain.Stock
import org.joda.time.DateTime

object StockStub {
    fun random(
        currency: Currency = CurrencyStub.random(),
        quantity: Double = DoubleStub.positive(),
        purchaseDate: DateTime = DatetimeStub.random()
    ): Stock = Stock(currency, quantity, purchaseDate)
}