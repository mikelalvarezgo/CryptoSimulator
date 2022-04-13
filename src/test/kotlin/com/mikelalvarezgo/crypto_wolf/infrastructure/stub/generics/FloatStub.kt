package com.mikelalvarezgo.crypto_wolf.infrastructure.stub.generics

import kotlin.math.absoluteValue
import kotlin.random.Random

object FloatStub {
    fun random(): Float = Random.nextFloat()

    fun positive(): Float = Random.nextFloat().absoluteValue

}