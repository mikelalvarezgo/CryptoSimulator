package com.mikelalvarezgo.crypto_wolf.infrastructure.stub.generics

import kotlin.math.absoluteValue
import kotlin.random.Random

object DoubleStub {
    fun random(): Double = Random.nextDouble()

    fun positive(): Double = Random.nextDouble().absoluteValue

    fun between(min: Double, max: Double) = Random.nextDouble(min, max)
}