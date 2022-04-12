package com.mikelalvarezgo.crypto_wolf.modules.health_check.infrastructure.routes

import arrow.core.Option
import com.mikelalvarezgo.crypto_wolf.modules.health_check.domain.Checkable
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.HealthCheckRoutes(checkables: List<Checkable>) {
    route("/healthcheck"){
        route("/ready") {
            post {
                if (checkables.map { it.check() }.contains(false)){
                    call.respondText("Failure!", status = HttpStatusCode.InternalServerError)
                } else{
                    call.respondText("OK!", status = HttpStatusCode.NoContent)
                }
            }
        }
        route("/version"){
            get{
                val version: String? = javaClass.`package`.implementationVersion
                call.respondText(version.orEmpty(), status = HttpStatusCode.OK)

            }
        }
    }
}