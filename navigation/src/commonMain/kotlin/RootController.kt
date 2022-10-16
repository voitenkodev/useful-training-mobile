import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import internal.LocalAppNavigator
import internal.NavigationComponent
import internal.NavigationCore

@Composable
fun RootController(
    initial: Screen,
    finalize: () -> Unit,
    content: (@Composable NavigationState.() -> Unit)
) = CompositionLocalProvider(

    LocalAppNavigator provides NavigationState().apply { this.direct(initial) },

    content = {
        val current = NavigationComponent.navigationState
        val state: State<NavController> = current.state.collectAsState()

        NavigationCore(
            currentScreen = state.value.current?.link,
            screenToRemove = state.value.previous?.link,
            isForward = state.value.type == TransitionType.FORWARD,
            content = { content.invoke(current) }
        )

        // Exit app logic (for different OS)
        if (state.value.stack.isEmpty()) {
            finalize.invoke()
            return@CompositionLocalProvider
        }
    }
)