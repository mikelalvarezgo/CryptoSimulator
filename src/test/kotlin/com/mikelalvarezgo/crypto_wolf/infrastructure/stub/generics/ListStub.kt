package com.mikelalvarezgo.crypto_wolf.infrastructure.stub.generics

object ListStub {
    fun <T> random(maxElements: Int = IntStub.positive(), generator: () -> T): List<T> =
        (1..maxElements).map { generator() }
}