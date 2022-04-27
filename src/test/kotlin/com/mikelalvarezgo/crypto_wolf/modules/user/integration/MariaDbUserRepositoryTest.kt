package com.mikelalvarezgo.crypto_wolf.modules.user.integration

import com.mikelalvarezgo.crypto_wolf.infrastructure.IntegrationTestCase
import com.mikelalvarezgo.crypto_wolf.infrastructure.stub.user.UserIdStub
import com.mikelalvarezgo.crypto_wolf.infrastructure.stub.user.UserStub
import io.kotest.matchers.shouldBe
import org.jetbrains.exposed.sql.transactions.transaction

class MariaDbUserRepositoryTest : IntegrationTestCase({
    given("MariaDbUserRepository") {
        `when`("creating a user") {
            then("should store user in database") {
                val userId = UserIdStub.random()
                val user = UserStub.random(userId)
                val context = initializeContext()
                transaction {
                    val result = context.userContext.repository.create(user)
                    result.shouldBe(Unit)
                    val userStored = context.userContext.repository.find(userId)
                    userStored.isDefined() shouldBe true
                    userStored.map { it shouldBe user }
                }
            }
        }
    }
})