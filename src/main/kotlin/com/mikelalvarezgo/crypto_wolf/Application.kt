package com.mikelalvarezgo.crypto_wolf

import com.mikelalvarezgo.crypto_wolf.plugins.configureRouting
import com.mikelalvarezgo.crypto_wolf.plugins.configureSerialization
import com.mikelalvarezgo.crypto_wolf.shared.infrastructure.logger.KotlinLoggingLogger
import io.ktor.server.application.*

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

fun Application.module() {
    val logger: KotlinLoggingLogger = KotlinLoggingLogger("crypto-wolf")

    logger.info("Starting application....")
    configureRouting()
    configureSerialization()
    logger.info("READY!")
}