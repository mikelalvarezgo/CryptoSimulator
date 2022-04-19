package com.mikelalvarezgo.crypto_wolf.shared.domain

import java.util.UUID

data class PortfolioId(val value: UUID) {
    fun raw(): String = value.toString()
}
