import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import internal.LocalAppNavigator
import internal.NavigationCore
import internal.NavigatorImpl

@Composable
fun RootController(
    startScreen: Screen,
    finalize: () -> Unit,
    content: (@Composable Screen.() -> Unit)
) = CompositionLocalProvider(

    LocalAppNavigator provides NavigatorImpl().apply { direct(startScreen) },

    content = {
        val state = NavigationComponent.navigator.state.collectAsState()

        NavigationCore(
            currentScreen = state.value.current,
            screenToRemove = state.value.previous,
            isForward = state.value.type == TransitionType.FORWARD,
            content = { content.invoke(it) }
        )

        // Exit app logic (for different OS)
        if (state.value.stack.isEmpty()) {
            finalize.invoke()
        }
    }
)