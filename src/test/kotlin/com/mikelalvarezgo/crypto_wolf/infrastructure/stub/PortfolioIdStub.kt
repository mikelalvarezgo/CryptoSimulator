package com.mikelalvarezgo.crypto_wolf.infrastructure.stub

import com.mikelalvarezgo.crypto_wolf.infrastructure.stub.generics.IntStub
import com.mikelalvarezgo.crypto_wolf.infrastructure.stub.generics.ListStub
import com.mikelalvarezgo.crypto_wolf.shared.domain.Portfolio
import com.mikelalvarezgo.crypto_wolf.shared.domain.PortfolioId
import com.mikelalvarezgo.crypto_wolf.shared.domain.Stock
import java.util.UUID

object PortfolioIdStub {
    fun gen(id: UUID = UUID.randomUUID()): PortfolioId = PortfolioId(id)
}