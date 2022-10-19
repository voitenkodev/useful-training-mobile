package internal

import androidx.compose.runtime.compositionLocalOf

internal val LocalNavigator = compositionLocalOf<Core> { error("No Navigator provided") }
