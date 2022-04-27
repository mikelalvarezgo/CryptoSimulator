package com.mikelalvarezgo.crypto_wolf

import com.mikelalvarezgo.crypto_wolf.modules.user.infrastructure.persistence.MariaDbUserTableHelper
import com.mikelalvarezgo.crypto_wolf.shared.infrastructure.persistence.mariadb.MariaDbConfig
import com.typesafe.config.Config
import com.typesafe.config.ConfigFactory
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.transactions.transaction

fun main(args: Array<String>): Unit = PersistenceBuilder().run()

class PersistenceBuilder {
    val config: Config = ConfigFactory.defaultApplication().getConfig("crypto_wolf")!!
    val dbConfig: MariaDbConfig = MariaDbConfig.fromConfig(config.getConfig("persistence.mariadb")!!)

    val userTableHelper = MariaDbUserTableHelper()

    fun run() {
        val dbConnection = Database.connect(dbConfig.completeUrl, dbConfig.driver, dbConfig.user, dbConfig.password)
        transaction { userTableHelper.create() }

    }

}