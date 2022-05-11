package com.mikelalvarezgo.crypto_wolf.modules.portfolio.domain

import com.mikelalvarezgo.crypto_wolf.shared.domain.Currency
import com.mikelalvarezgo.crypto_wolf.shared.domain.Stock

data class Portfolio(val stocks: List<Stock>) {
    fun <T : Currency> calculate(currency: T, currentValue: Double): Double =
        stocks
            .filter { it.currency == currency }
            .fold(0.0) { acc, stock -> (acc + stock.quantity * currentValue) }
}
