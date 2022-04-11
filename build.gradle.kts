import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
plugins {
        com.mikelalvarezgo.Plugins.topLevelPlugins.forEach { (n, v) -> id(n) version v }
}

group = "com.mikelalvarezgo"
version = "1.0-SNAPSHOT"

allprojects {
    repositories {
        mavenCentral()
    }
    apply(plugin = "java")
    apply(plugin = "org.jetbrains.kotlin.jvm")
    dependencies{
     com.mikelalvarezgo.Deps.implementations.forEach(::implementation)
     com.mikelalvarezgo.Deps.testing.forEach(::testImplementation)
    }
}
repositories {
    mavenCentral()
}
val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    jvmTarget = "15"
}