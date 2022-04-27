package com.mikelalvarezgo.crypto_wolf

import com.mikelalvarezgo.crypto_wolf.infrastructure.CryptoWolfContext
import com.mikelalvarezgo.crypto_wolf.plugins.configureRouting
import com.mikelalvarezgo.crypto_wolf.plugins.configureSerialization
import com.mikelalvarezgo.crypto_wolf.shared.infrastructure.logger.KotlinLoggingLogger
import com.typesafe.config.Config
import com.typesafe.config.ConfigFactory
import io.ktor.server.application.*

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

fun Application.module() {
    val logger: KotlinLoggingLogger = KotlinLoggingLogger("crypto-wolf")
    val config: Config = ConfigFactory.defaultApplication().getConfig("crypto_wolf")!!
    val context = CryptoWolfContext(logger, config)
    logger.info("Starting application....")
    configureRouting(context.routes)
    configureSerialization()
    logger.info("READY!")
}