package di

import androidx.compose.runtime.staticCompositionLocalOf

enum class Platform { Android, iOS }

expect class PlatformConfiguration {
    val appName: String
    val platform: Platform
}

internal val LocalPlatform = staticCompositionLocalOf<Platform> { error("no default platform") }