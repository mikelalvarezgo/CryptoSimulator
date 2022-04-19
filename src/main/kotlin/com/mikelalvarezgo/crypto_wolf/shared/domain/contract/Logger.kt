package com.mikelalvarezgo.crypto_wolf.shared.domain.contract

interface Logger {
    fun info(msg: String, params: Map<String, Any>): Unit
    fun info(msg: String, throwable: Throwable): Unit
    fun info(msg: String): Unit
    fun warning(msg: String, params: Map<String, Any>): Unit
    fun warning(msg: String, throwable: Throwable): Unit
    fun warning(msg: String): Unit
    fun error(msg: String, params: Map<String, Any>): Unit
    fun error(msg: String, throwable: Throwable): Unit
    fun error(msg: String): Unit
    fun debug(msg: String, params: Map<String, Any>): Unit
    fun debug(msg: String, throwable: Throwable): Unit
}