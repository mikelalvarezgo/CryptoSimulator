package com.mikelalvarezgo.crypto_wolf.modules.health_check.infrastructure.dependency_injection

import com.mikelalvarezgo.crypto_wolf.modules.health_check.domain.Checkable
import com.mikelalvarezgo.crypto_wolf.modules.health_check.infrastructure.routes.HealthCheckController
import com.mikelalvarezgo.crypto_wolf.shared.infrastructure.dependency_injection.Context
import io.ktor.server.routing.*

class HealthCheckContext : Context {
    override val routes: Routing.() -> Unit = HealthCheckController(listOf<Checkable>()).routes
}