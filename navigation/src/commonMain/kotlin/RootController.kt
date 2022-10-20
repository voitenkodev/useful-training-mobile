import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.saveable.rememberSaveableStateHolder
import internal.AnimatedTransition
import internal.Core
import internal.LocalNavigator
import internal.NavComponent


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


        val stateHolder = rememberSaveableStateHolder()

        AnimatedTransition(
            targetState = state.value.current,
            animation = Animation.Push(400),
            isForwardDirection = state.value.type == TransitionVariant.FORWARD,
            content = { screen ->
                if (screen != null) {
                    stateHolder.SaveableStateProvider(screen) {
                        impl._screenMap[screen]?.invoke()
                    }
                }
            }
        )

        LaunchedEffect(state.value) {
            if (state.value.type == TransitionVariant.BACK) {
                state.value.removed?.let { stateHolder.removeState(it) }
            }
        }
    }
}