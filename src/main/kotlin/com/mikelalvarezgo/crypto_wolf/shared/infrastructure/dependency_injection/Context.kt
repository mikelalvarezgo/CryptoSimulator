package com.mikelalvarezgo.crypto_wolf.shared.infrastructure.dependency_injection

import io.ktor.server.routing.*

interface Context {
    val routes: Routing.() -> Unit
}