package com.mikelalvarezgo.crypto_wolf.infrastructure.stub.user

import com.mikelalvarezgo.crypto_wolf.infrastructure.stub.generics.StringStub
import com.mikelalvarezgo.crypto_wolf.shared.domain.TaxId

object TaxIdStub {
    fun random(id: String = StringStub.random(11)): TaxId = TaxId(id)
}