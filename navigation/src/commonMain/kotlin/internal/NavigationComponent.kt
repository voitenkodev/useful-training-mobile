package internal

import NavigationState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf


internal object NavigationComponent {

    val navigationState: NavigationState
        @Composable
        get() = LocalAppNavigator.current

}

internal val LocalAppNavigator = staticCompositionLocalOf<NavigationState> { error("No Navigator provided") }
