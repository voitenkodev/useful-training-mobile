import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import co.touchlab.kermit.Logger
import internal.AnimationCore
import internal.Core
import internal.LocalNavigator
import internal.NavComponent
import internal.NavigationSession

@Composable
public fun CsRootController(
    startScreen: String,
    content: GraphBuilder.() -> Unit
): Unit = CompositionLocalProvider(LocalNavigator provides Core().apply {
    content.invoke(this)
    navigate(startScreen)
}) {
    val impl = NavComponent.navigator

    val state = NavComponent.navigator.session.collectAsState()

    Draw(state.value, impl)
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

    LaunchedEffect(Unit) {

    }
}