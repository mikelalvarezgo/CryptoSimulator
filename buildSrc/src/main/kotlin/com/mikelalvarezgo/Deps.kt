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
        "org.mariadb.jdbc:mariadb-java-client:${Versions.mariaDBDriver}",

        // Monitoring metrics
        "io.ktor:ktor-server-metrics-micrometer:${Versions.ktor}",

        // Logging
        "ch.qos.logback:logback-classic:${Versions.logback}",
        "io.github.microutils:kotlin-logging:${Versions.kotlinLogging}",

        // Tools
        "io.arrow-kt:arrow-optics:${Versions.arrow}",
        "io.arrow-kt:arrow-core:${Versions.arrow}",
        "org.http4k:http4k-core:${Versions.http4k}"
    )

    val testing = listOf<String>(
        "io.ktor:ktor-server-test-host:${Versions.ktor}",
        "io.kotest:kotest-runner-junit5:${Versions.kotest}",
        "org.jetbrains.kotlin:kotlin-test-junit:${Versions.kotlin}",
        "org.mockito.kotlin:mockito-kotlin:${Versions.mockito}",
        "io.kotest:kotest-assertions-core-jvm:${Versions.kotest}",
        "org.apache.commons:commons-lang3:${Versions.apacheCommons}"
    )

}