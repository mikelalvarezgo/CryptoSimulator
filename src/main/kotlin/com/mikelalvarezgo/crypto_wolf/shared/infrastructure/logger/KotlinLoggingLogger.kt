package com.mikelalvarezgo.crypto_wolf.shared.infrastructure.logger

import com.mikelalvarezgo.crypto_wolf.shared.domain.contract.Logger
import mu.KLogger
import mu.KotlinLogging

class KotlinLoggingLogger(name: String) : Logger {
    private val logger: KLogger = KotlinLogging.logger(name)
    override fun info(msg: String, params: Map<String, Any>) {
        logger.info(msg, params)
    }

    override fun info(msg: String, throwable: Throwable) {
        logger.info(msg, throwable)
    }

    override fun info(msg: String) {
        logger.info(msg)
    }

    override fun warning(msg: String, params: Map<String, Any>) {
        logger.warn(msg, params)
    }

    override fun warning(msg: String, throwable: Throwable) {
        logger.warn(msg, throwable)
    }

    override fun warning(msg: String) {
        logger.warn(msg)
    }


    override fun error(msg: String, params: Map<String, Any>) {
        logger.error(msg, params)
    }

    override fun error(msg: String, throwable: Throwable) {
        logger.error(msg, throwable)
    }

    override fun error(msg: String) {
        logger.error(msg)
    }

    override fun debug(msg: String, params: Map<String, Any>) {
        logger.debug(msg, params)
    }

    override fun debug(msg: String, throwable: Throwable) {
        logger.debug(msg, throwable)
    }
}