package com.mikelalvarezgo.crypto_wolf.modules.user.infrastructure.persistence

import com.mikelalvarezgo.crypto_wolf.modules.user.domain.User
import com.mikelalvarezgo.crypto_wolf.shared.domain.TaxId
import com.mikelalvarezgo.crypto_wolf.shared.domain.UserId
import com.mikelalvarezgo.crypto_wolf.shared.infrastructure.persistence.mariadb.MariaDbTable
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.ResultRow
import org.joda.time.DateTime

object MariaDbUserTable : MariaDbTable<User>() {
    override val tableName: String = "Users"
    private val id: Column<Int> = integer("id").autoIncrement().primaryKey()
    val userId: Column<String> = varchar("user_id", 50).uniqueIndex()
    val name: Column<String> = varchar("name", 50)
    val surname: Column<String> = varchar("surname", 50)
    val taxId: Column<String> = varchar("tax_id", 50)
    val birthDate: Column<DateTime> = datetime("birth_date")
    val createdAt: Column<DateTime> = datetime("created_at")
    val updatedAt: Column<DateTime> = datetime("updated_at")
    override fun fromRow(resultRow: ResultRow): User =
        User(
            UserId.unsafe(resultRow[userId]),
            resultRow[name],
            resultRow[surname],
            resultRow[birthDate],
            TaxId.unsafe(resultRow[taxId]),
            resultRow[createdAt],
            resultRow[updatedAt]
        )
}