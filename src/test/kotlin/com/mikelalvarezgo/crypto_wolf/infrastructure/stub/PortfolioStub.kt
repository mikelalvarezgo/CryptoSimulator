package com.mikelalvarezgo.crypto_wolf.infrastructure.stub

import com.mikelalvarezgo.crypto_wolf.infrastructure.stub.generics.IntStub
import com.mikelalvarezgo.crypto_wolf.infrastructure.stub.generics.ListStub
import com.mikelalvarezgo.crypto_wolf.modules.portfolio.domain.Portfolio
import com.mikelalvarezgo.crypto_wolf.shared.domain.Stock

object PortfolioStub {
    fun gen(stocks: List<Stock> = ListStub.random(IntStub.between(1, 2)) { StockStub.random() }): Portfolio =
        Portfolio(stocks)
}