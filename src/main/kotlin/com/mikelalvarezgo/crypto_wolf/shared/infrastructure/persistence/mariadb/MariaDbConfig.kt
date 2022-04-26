package com.mikelalvarezgo.crypto_wolf.shared.infrastructure.persistence.mariadb

import com.typesafe.config.Config

class MariaDbConfig(
    private val url: String,
    private val port: Int,
    private val db: String,
    val driver: String,
    val user: String,
    val password: String
) {
    val completeUrl: String = "$url:$port:/$db"

    companion object MariaDbConfigHelper {
        fun fromConfig(config: Config): MariaDbConfig =
            MariaDbConfig(
                config.getString("url")!!,
                config.getInt("port")!!,
                config.getString("db")!!,
                config.getString("driver")!!,
                config.getString("user")!!,
                config.getString("password")!!
            )
    }
}