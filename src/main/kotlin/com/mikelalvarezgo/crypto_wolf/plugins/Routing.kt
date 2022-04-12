package com.mikelalvarezgo.crypto_wolf.plugins

import com.mikelalvarezgo.crypto_wolf.modules.health_check.domain.Checkable
import com.mikelalvarezgo.crypto_wolf.modules.health_check.infrastructure.routes.HealthCheckRoutes
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        HealthCheckRoutes(listOf<Checkable>())
    }
}