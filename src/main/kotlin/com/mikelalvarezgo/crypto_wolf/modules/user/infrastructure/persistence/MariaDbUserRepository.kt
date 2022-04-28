package com.mikelalvarezgo.crypto_wolf.modules.user.infrastructure.persistence

import arrow.core.Option
import arrow.core.singleOrNone
import com.mikelalvarezgo.crypto_wolf.modules.user.domain.User
import com.mikelalvarezgo.crypto_wolf.modules.user.domain.contract.UserRepository
import com.mikelalvarezgo.crypto_wolf.shared.domain.UserId
import org.jetbrains.exposed.sql.deleteWhere
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.update

class MariaDbUserRepository : UserRepository {

    override fun create(user: User) {
        transaction {
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
    }

    override fun update(user: User) {
        transaction {
            MariaDbUserTable.update {
                it[name] = user.name
                it[surname] = user.surname
                it[taxId] = user.taxId.value
                it[birthDate] = user.birthDateTime
                it[createdAt] = user.createdAt
                it[updatedAt] = user.updatedAt
            }
        }
    }

    override fun find(id: UserId): Option<User> =
       transaction {
           MariaDbUserTable.select { MariaDbUserTable.userId eq id.raw() }.singleOrNone()
               .map { MariaDbUserTable.fromRow(it) }
       }

    override fun delete(id: UserId) {
        transaction {
            MariaDbUserTable.deleteWhere { MariaDbUserTable.userId eq id.raw() }
        }
    }
}