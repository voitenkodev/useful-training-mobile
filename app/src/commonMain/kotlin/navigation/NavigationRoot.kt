package navigation

import BackHandler
import Direction
import GlobalState
import NavigationHost
import NavigatorAction
import NavigatorState
import TransitionType
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import rememberDispatcher
import selectState

@Composable
fun NavigatorRoot(
    graph: @Composable (Direction) -> Unit,
    finalize: () -> Unit
) {

    val state by selectState<GlobalState, NavigatorState> { this.navigatorState }
    val dispatcher = rememberDispatcher()

    if (state.added == null) {
        finalize.invoke()
        return
    }

    NavigationHost(
        currentScreen = state.added?.route,
        screenToRemove = state.removed?.route,
        isForward = state.type == TransitionType.FORWARD,
        content = { direct -> Direction.values().find { it.route == direct }?.let { graph.invoke(it) } }
    )

    BackHandler(action = { dispatcher(NavigatorAction.BACK) })
}