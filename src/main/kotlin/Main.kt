import com.mikelalvarezgo.crypto_wolf.shared.infrastructure.logger.KotlinLoggingLogger

fun main(args: Array<String>) {
    val logger: KotlinLoggingLogger = KotlinLoggingLogger("crypto-wolf")
    logger.info("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    logger.info("Program arguments: ${args.joinToString()}")
}