package com.mikelalvarezgo.crypto_wolf.infrastructure

import com.mikelalvarezgo.crypto_wolf.modules.health_check.infrastructure.dependency_injection.HealthCheckContext
import com.mikelalvarezgo.crypto_wolf.modules.user.infrastructure.dependency_injection.UserContext
import com.mikelalvarezgo.crypto_wolf.shared.domain.contract.Logger
import com.mikelalvarezgo.crypto_wolf.shared.infrastructure.dependency_injection.Context
import com.mikelalvarezgo.crypto_wolf.shared.infrastructure.persistence.mariadb.MariaDbConfig
import com.typesafe.config.ConfigFactory
import io.ktor.server.routing.*
import org.jetbrains.exposed.sql.Database

class CryptoWolfContext(val logger: Logger) : Context {
    val config = ConfigFactory.defaultApplication()
    val dbConfig: MariaDbConfig = MariaDbConfig.fromConfig(config.getConfig("persistence.mariadb")!!)
    val dbConnection = Database.connect(dbConfig.completeUrl, dbConfig.driver, dbConfig.user, dbConfig.password)

    val healthCheckContext: HealthCheckContext = HealthCheckContext()
    val userContext: UserContext = UserContext(logger)
    override val routes: Routing.() -> Unit = healthCheckContext.routes.also { userContext }
}