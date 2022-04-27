package com.mikelalvarezgo.crypto_wolf.infrastructure

import com.mikelalvarezgo.crypto_wolf.shared.infrastructure.logger.DummyLogger
import com.typesafe.config.ConfigFactory
import io.kotest.core.spec.style.BehaviorSpec

open class IntegrationTestCase(private val body: BehaviorSpec.() -> Unit = {}) : BehaviorSpec(body) {
    companion object IntegrationTestCaseHelper {
        fun initializeContext(): CryptoWolfContext {
            println("creating context....")
            val context = CryptoWolfContext(DummyLogger, ConfigFactory.defaultApplication().getConfig("crypto_wolf")!!)
            context.dbConnection
            return context
        }
    }
}