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

    override fun create(user: User) {
        MariaDbUserTable.insert {
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
        MariaDbUserTable.update {
            it[name] = user.name
            it[surname] = user.surname
            it[taxId] = user.taxId.value
            it[birthDate] = user.birthDateTime
            it[createdAt] = user.createdAt
            it[updatedAt] = user.updatedAt
        }
    }

    override fun find(id: UserId): Option<User> =
        MariaDbUserTable.select { MariaDbUserTable.userId eq id.raw() }.singleOrNone().map { MariaDbUserTable.fromRow(it) }

    override fun delete(id: UserId) {
        MariaDbUserTable.deleteWhere { MariaDbUserTable.userId eq id.raw() }
    }
}