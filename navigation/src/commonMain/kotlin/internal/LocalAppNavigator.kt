package internal

import androidx.compose.runtime.compositionLocalOf

internal val LocalAppNavigator = compositionLocalOf<NavigatorImpl> { error("No Navigator provided") }
