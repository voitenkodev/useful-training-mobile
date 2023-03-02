package di

actual class PlatformConfiguration {
    actual val appName: String
        get() = "UsefulTraining"

    actual val platform: Platform
        get() = Platform.iOS
}