package com.mikelalvarezgo.crypto_wolf.shared.infrastructure.persistence.mariadb

import org.jetbrains.exposed.sql.SchemaUtils

interface MariaDdTableHelper<T> {
    val table: MariaDbTable<T>
    fun create(): Unit = SchemaUtils.create(table)
}