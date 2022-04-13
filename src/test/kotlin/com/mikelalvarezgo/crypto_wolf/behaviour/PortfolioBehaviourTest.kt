package com.mikelalvarezgo.crypto_wolf.behaviour

import com.mikelalvarezgo.crypto_wolf.infrastructure.stub.PortfolioStub
import com.mikelalvarezgo.crypto_wolf.shared.domain.Bitcoin
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.doubles.shouldBeExactly

class PortfolioBehaviourTest : BehaviorSpec({
    given("A portfolio") {
        `when`("require total value") {
            then("should sum current values of different values") {
                val portFolio = PortfolioStub.gen()
                val expectedValue =
                    portFolio.stocks.filter { it.currency == Bitcoin }.fold(0.0) { acc, port -> acc + port.quantity }
                portFolio.calculate(Bitcoin, 1.0).shouldBeExactly(expectedValue)
            }
        }
    }
})