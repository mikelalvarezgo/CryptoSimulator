package com.mikelalvarezgo.crypto_wolf.modules.user.infrastructure.persistence

import arrow.core.Option
import arrow.core.singleOrNone
import com.mikelalvarezgo.crypto_wolf.modules.user.domain.User
import com.mikelalvarezgo.crypto_wolf.modules.user.domain.contract.UserRepository
import com.mikelalvarezgo.crypto_wolf.shared.domain.TaxId
import com.mikelalvarezgo.crypto_wolf.shared.domain.UserId
import com.mikelalvarezgo.crypto_wolf.shared.infrastructure.persistence.mariadb.MariaDbTable
import org.jetbrains.exposed.sql.*
import org.joda.time.DateTime

class MariaDbUserRepository : UserRepository {
    object UserTable : MariaDbTable<User>() {
        private val id: Column<Int> = integer("id").autoIncrement()
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

    override fun create(user: User) {
        UserTable.insert {
            it[userId] = user.id.raw()
            it[name] = user.name
            it[surname] = user.surname
            it[taxId] = user.taxId.value
            it[birthDate] = user.birthDateTime
            it[createdAt] = user.createdAt
            it[updatedAt] = user.updatedAt
        }
    }

    override fun update(user: User) {
        UserTable.update {
            it[name] = user.name
            it[surname] = user.surname
            it[taxId] = user.taxId.value
            it[birthDate] = user.birthDateTime
            it[createdAt] = user.createdAt
            it[updatedAt] = user.updatedAt
        }
    }

    override fun find(id: UserId): Option<User> =
        UserTable.select { UserTable.userId eq id.raw() }.singleOrNone().map { UserTable.fromRow(it) }

    override fun delete(id: UserId) {
        UserTable.deleteWhere { UserTable.userId eq id.raw() }
    }
}