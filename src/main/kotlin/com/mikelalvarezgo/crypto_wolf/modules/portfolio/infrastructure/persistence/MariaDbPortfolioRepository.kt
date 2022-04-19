package com.mikelalvarezgo.crypto_wolf.modules.portfolio.infrastructure.persistence

import arrow.core.Option
import com.mikelalvarezgo.crypto_wolf.modules.portfolio.domain.PortfolioRepository
import com.mikelalvarezgo.crypto_wolf.shared.domain.Portfolio
import com.mikelalvarezgo.crypto_wolf.shared.domain.PortfolioId
import kotlinx.coroutines.Dispatchers
import org.jetbrains.exposed.sql.*

import org.jetbrains.exposed.sql.transactions.experimental.suspendedTransactionAsync

class MariaDbPortfolioRepository(db: Database): PortfolioRepository {
    object PortfolioTable : Table() {
        val id = integer("_id").autoIncrement() // Column<Int>
        val name = varchar("name", 50) // Column<String>

        val primaryKey = PrimaryKey(id, name = "PK_portfolio_id")
    }
    override suspend fun create(portfolio: Portfolio) {
        suspendedTransactionAsync(Dispatchers.IO, db){
            PortfolioTable.insert { portfolio }
        }
    }

    override suspend fun update(portfolio: Portfolio) {
        TODO("Not yet implemented")
    }

    override suspend fun find(id: PortfolioId): Option<Portfolio> {
        TODO("Not yet implemented")
    }

    override suspend fun delete(id: PortfolioId) {
        TODO("Not yet implemented")
    }
}