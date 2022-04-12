package com.mikelalvarezgo.crypto_wolf

import com.mikelalvarezgo.crypto_wolf.plugins.configureRouting
import com.mikelalvarezgo.crypto_wolf.plugins.configureSerialization
import io.ktor.server.application.*

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

fun Application.module() {
    println("Starting application....")
    configureRouting()
    configureSerialization()
    println("READY!")
}