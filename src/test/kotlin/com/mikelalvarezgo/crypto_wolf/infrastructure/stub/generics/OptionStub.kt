package com.mikelalvarezgo.crypto_wolf.infrastructure.stub.generics

import arrow.core.Option
import arrow.core.none
import arrow.core.some
import kotlin.random.Random

object OptionStub {
    fun <T> random(generator: () -> T): Option<T> =
        if (Random.nextBoolean()) generator().some() else none<T>()
}