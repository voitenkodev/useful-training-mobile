package navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.saveable.rememberSaveableStateHolder
import navigation.internal.AnimatedTransition
import navigation.internal.Core
import navigation.internal.LocalNavigator
import navigation.internal.NavComponent
import navigation.internal.TransitionVariant

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
fun RootController(
    startScreen: String,
    content: GraphBuilder.() -> Unit
) {

    provideCore(startScreen, content)

    val core = core ?: error("need to provide core, please use `provideCore`")

    CompositionLocalProvider(LocalNavigator provides core) {

        val navigator = NavComponent.navigator

        val transaction = NavComponent.navigator.transaction.collectAsState()

        val stateHolder = rememberSaveableStateHolder()

        AnimatedTransition(
            targetState = transaction.value.current,
            animation = transaction.value.animation,
            isForwardDirection = transaction.value.type == TransitionVariant.FORWARD,
            content = { screen ->
                if (screen != null) {
                    stateHolder.SaveableStateProvider(screen.route) {
                        navigator.draw(screen)
                    }
                }
            }
        )

        LaunchedEffect(transaction.value) {
            if (transaction.value.type == TransitionVariant.BACK) {
                transaction.value.removed?.let {
                    stateHolder.removeState(it.route)
                    navigator.drop(it)
                }
            }
        }
    }
}