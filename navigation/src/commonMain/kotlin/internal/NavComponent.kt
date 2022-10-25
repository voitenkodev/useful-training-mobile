package internal

import androidx.compose.runtime.Composable

internal object NavComponent {

    internal val navigator: Core
        @Composable
        get() = LocalNavigator.current
}