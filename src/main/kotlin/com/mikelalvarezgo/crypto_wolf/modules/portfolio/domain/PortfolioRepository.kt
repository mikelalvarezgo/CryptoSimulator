package com.mikelalvarezgo.crypto_wolf.modules.portfolio.domain

import arrow.core.Option
import com.mikelalvarezgo.crypto_wolf.shared.domain.Portfolio
import com.mikelalvarezgo.crypto_wolf.shared.domain.PortfolioId
import kotlin.Unit

interface PortfolioRepository {
    suspend fun create(portfolio:Portfolio): Unit
    suspend fun update(portfolio: Portfolio): Unit
    suspend fun find(id: PortfolioId): Option<Portfolio>
    suspend fun delete(id: PortfolioId): Unit
}
