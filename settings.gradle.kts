rootProject.name = "CryptoSimulator"

pluginManagement {
    val kotlinVersion: String by settings
    plugins {
        kotlin("jvm") version kotlinVersion
    }
}


include(":script-plugin")
include(":precompiled")
include(":binary-plugin")
include(":app")
