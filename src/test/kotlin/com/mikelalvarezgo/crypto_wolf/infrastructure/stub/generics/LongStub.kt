package com.mikelalvarezgo.crypto_wolf.infrastructure.stub.generics

import kotlin.math.absoluteValue
import kotlin.random.Random

object LongStub {
    fun random(): Long = Random.nextLong()

    fun positive(): Long = Random.nextLong().absoluteValue

    fun between(min: Long, max: Long) = Random.nextLong(min, max)
}