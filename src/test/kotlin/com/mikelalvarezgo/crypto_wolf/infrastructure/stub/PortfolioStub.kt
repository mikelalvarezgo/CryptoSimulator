package com.mikelalvarezgo.crypto_wolf.infrastructure.stub

import com.mikelalvarezgo.crypto_wolf.infrastructure.stub.generics.IntStub
import com.mikelalvarezgo.crypto_wolf.infrastructure.stub.generics.ListStub
import com.mikelalvarezgo.crypto_wolf.shared.domain.Portfolio
import com.mikelalvarezgo.crypto_wolf.shared.domain.PortfolioId
import com.mikelalvarezgo.crypto_wolf.shared.domain.Stock

object PortfolioStub {
    fun gen(
        id: PortfolioId = PortfolioIdStub.gen(),
        stocks: List<Stock> = ListStub.random(IntStub.between(1, 2)) { StockStub.random() }): Portfolio =
        Portfolio(id, stocks)
}