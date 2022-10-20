import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import internal.AnimationCore
import internal.Core
import internal.LocalNavigator
import internal.NavComponent
import internal.NavigationSession


private var core: Core? = null

private fun provideCore(
    startScreen: String,
    content: GraphBuilder.() -> Unit
) {
    if (core == null)
        core = Core().apply {
            content.invoke(this)
            navigate(startScreen)
        }
}

@Composable
public fun RootController(
    startScreen: String,
    content: GraphBuilder.() -> Unit
) {
    provideCore(startScreen, content)
    val core = core ?: error("need to provide core, please use `provideCore`")
    CompositionLocalProvider(LocalNavigator provides core) {
        val impl = NavComponent.navigator
        val state = NavComponent.navigator.session.collectAsState()
        Draw(state.value, impl)
    }
}

@Composable
private fun Draw(
    value: NavigationSession,
    impl: Core
) {
    AnimationCore(
        currentScreen = value.current,
        screenToRemove = value.removed,
        isForward = value.type == TransitionVariant.FORWARD,
    ) { currentScreen ->
        impl._screenMap[currentScreen]?.invoke()
    }
}