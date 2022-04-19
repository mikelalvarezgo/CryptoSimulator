package com.mikelalvarezgo.crypto_wolf.shared.domain

data class Portfolio(val id: PortfolioId, val stocks: List<Stock>) {
    fun <T : Currency> calculate(currency: T, currentValue: Double): Double =
        stocks
            .filter { it.currency == currency }
            .fold(0.0) { acc, stock -> (acc + stock.quantity * currentValue) }
}
