package com.mikelalvarezgo.crypto_wolf.shared.infrastructure.logger

import com.mikelalvarezgo.crypto_wolf.shared.domain.contract.Logger

object DummyLogger : Logger {
    override fun info(msg: String, params: Map<String, Any>) = Unit

    override fun info(msg: String, throwable: Throwable) = Unit

    override fun info(msg: String) = Unit

    override fun warning(msg: String, params: Map<String, Any>) = Unit

    override fun warning(msg: String, throwable: Throwable) = Unit

    override fun warning(msg: String) = Unit

    override fun error(msg: String, params: Map<String, Any>) = Unit

    override fun error(msg: String, throwable: Throwable) = Unit

    override fun error(msg: String) = Unit

    override fun debug(msg: String, params: Map<String, Any>) = Unit

    override fun debug(msg: String, throwable: Throwable) = Unit

}