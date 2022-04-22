package com.mikelalvarezgo.crypto_wolf.plugins

import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.configureRouting(rutes: Routing.() -> Unit) {
    routing { rutes }
}