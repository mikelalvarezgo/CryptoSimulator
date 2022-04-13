package com.mikelalvarezgo.crypto_wolf.shared.domain

import org.joda.time.DateTime

data class Stock(val currency: Currency, val quantity: Double, val purchaseDate: DateTime)

