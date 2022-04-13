package com.mikelalvarezgo.crypto_wolf.infrastructure.stub.generics

import org.joda.time.DateTime

object DatetimeStub {
    fun random(): DateTime = DateTime.now().minus(LongStub.random())
    fun now(): DateTime = DateTime.now()
}