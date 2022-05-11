package com.mikelalvarezgo.crypto_wolf.modules.portfolio.domain.contract

import arrow.core.Option
import com.mikelalvarezgo.crypto_wolf.modules.user.domain.User
import com.mikelalvarezgo.crypto_wolf.modules.portfolio.domain.Portfolio
import com.mikelalvarezgo.crypto_wolf.shared.domain.UserId

interface PortfolioRepository {
    fun create(portfolio: Portfolio): Unit
    fun update(portfolio: Portfolio): Unit
    fun find(portfolioId: Portfolio: UserId): Option<User>
    fun delete(id: UserId): Unit
}