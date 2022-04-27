package com.mikelalvarezgo.crypto_wolf.infrastructure.stub.generics

import org.apache.commons.lang3.RandomStringUtils

object StringStub {
    fun random(length: Int = IntStub.between(0, 50)): String = RandomStringUtils.random(length)

    fun randomAlphanumeric(length: Int = IntStub.between(0, 50)): String = RandomStringUtils.randomAlphanumeric(length)

    fun randomAlphabetic(length: Int = IntStub.between(0, 50)): String = RandomStringUtils.randomAlphabetic(length)

}