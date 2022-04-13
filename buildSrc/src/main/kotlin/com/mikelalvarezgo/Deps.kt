package com.mikelalvarezgo

object Deps {

    val implementations = listOf<String>(
        // Ktor Server
        "io.ktor:ktor-server-core:${Versions.ktor}",
        "io.ktor:ktor-server-netty:${Versions.ktor}",
        "io.ktor:ktor-server-content-negotiation:${Versions.ktor}",
        //serialization
        "io.ktor:ktor-serialization-kotlinx-json:${Versions.ktor}",

        // DB
        "org.jetbrains.exposed:exposed:${Versions.exposed}",
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
        "io.ktor:ktor-server-test-host:${Versions.ktor}",
        "org.jetbrains.kotlin:kotlin-test-junit:${Versions.kotlin}",
        "io.kotest:kotest-assertions-core-jvm:${Versions.kotest}"
    )

}