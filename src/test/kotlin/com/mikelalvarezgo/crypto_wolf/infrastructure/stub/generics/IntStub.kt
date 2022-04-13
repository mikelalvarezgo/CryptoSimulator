package com.mikelalvarezgo.crypto_wolf.infrastructure.stub.generics

import kotlin.math.absoluteValue
import kotlin.random.Random

object IntStub {
    fun random(): Int = Random.nextInt()

    fun positive(): Int = Random.nextInt().absoluteValue

    fun between(min: Int, max: Int) = Random.nextInt(min, max)
}