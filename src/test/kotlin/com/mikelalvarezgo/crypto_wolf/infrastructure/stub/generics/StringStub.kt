package com.mikelalvarezgo.crypto_wolf.infrastructure.stub.generics

import org.apache.commons.lang3.RandomStringUtils

object StringStub {
    fun random(length: Int = IntStub.positive()): String = RandomStringUtils.random(length)

    fun randomAlphanumeric(length: Int = IntStub.positive()): String = RandomStringUtils.randomAlphanumeric(length)

    fun randomAlphabetic(length: Int = IntStub.positive()): String = RandomStringUtils.randomAlphabetic(length)

}