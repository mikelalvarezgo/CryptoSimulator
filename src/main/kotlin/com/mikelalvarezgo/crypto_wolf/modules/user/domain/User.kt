package com.mikelalvarezgo.crypto_wolf.modules.user.domain

import com.mikelalvarezgo.crypto_wolf.shared.domain.TaxId
import com.mikelalvarezgo.crypto_wolf.shared.domain.UserId
import org.joda.time.DateTime

data class User(
    val id: UserId, val name: String, val surname: String,
    val birthDateTime: DateTime, val taxId: TaxId, val createdAt: DateTime, val updatedAt: DateTime
)
