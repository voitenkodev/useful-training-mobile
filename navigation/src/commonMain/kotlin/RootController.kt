import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.saveable.rememberSaveableStateHolder
import co.touchlab.kermit.Logger
import internal.AnimatedTransition
import internal.Core
import internal.LocalNavigator
import internal.NavComponent
import internal.TransitionVariant

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

        val navigator = NavComponent.navigator

        val transaction = NavComponent.navigator.transaction.collectAsState()

        Logger.i { "transaction = ${transaction.value}" }

        val stateHolder = rememberSaveableStateHolder()

        AnimatedTransition(
            targetState = transaction.value.current,
            animation = transaction.value.animation,
            isForwardDirection = transaction.value.type == TransitionVariant.FORWARD,
            content = { screen ->
                if (screen != null) {
                    stateHolder.SaveableStateProvider(screen) {
                        navigator.draw(screen)
                    }
                }
            }
        )

        LaunchedEffect(transaction.value) {
            if (transaction.value.type == TransitionVariant.BACK) {
                transaction.value.removed?.let {
                    stateHolder.removeState(it)
                    navigator.drop(it)
                }
            }
        }
    }
}