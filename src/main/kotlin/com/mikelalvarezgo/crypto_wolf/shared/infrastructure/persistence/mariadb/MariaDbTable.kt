package com.mikelalvarezgo.crypto_wolf.shared.infrastructure.persistence.mariadb

import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.Table

abstract class MariaDbTable<T> : Table() {
    abstract override val tableName: String
    abstract fun fromRow(resultRow: ResultRow): T
}