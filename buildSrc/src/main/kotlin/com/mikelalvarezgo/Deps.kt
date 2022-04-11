package com.mikelalvarezgo
object Deps {

    val implementations = listOf<String>(
        // Ktor Server
        "io.ktor:ktor-server-core:${Versions.ktor}",
        "io.ktor:ktor-server-netty:${Versions.ktor}",

        // Monitoring metrics
        "io.ktor:ktor-server-metrics-micrometer:${Versions.ktor}",

        // Logging
        "ch.qos.logback:logback-classic:${Versions.logback}",

        // Tools
        "io.arrow-kt:arrow-optics:${Versions.arrow}",
        "io.arrow-kt:arrow-core:${Versions.arrow}",
        "org.http4k:http4k-core:${Versions.http4k}"
    )

    val testing = listOf<String>(
        "io.kotest:kotest-assertions-core-jvm:${Versions.kotest}"
    )

}