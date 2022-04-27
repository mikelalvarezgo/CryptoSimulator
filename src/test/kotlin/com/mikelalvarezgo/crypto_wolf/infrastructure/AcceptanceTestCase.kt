package com.mikelalvarezgo.crypto_wolf.infrastructure

import com.mikelalvarezgo.crypto_wolf.shared.infrastructure.logger.DummyLogger
import com.typesafe.config.ConfigFactory
import io.kotest.core.spec.style.FeatureSpec

open class AcceptanceTestCase(private val body: FeatureSpec.() -> Unit = {}) : FeatureSpec(body) {
    companion object AcceptanceTestCaseHelper {
        val context = CryptoWolfContext(DummyLogger, ConfigFactory.defaultApplication().getConfig("crypto_wolf")!!)
    }
}