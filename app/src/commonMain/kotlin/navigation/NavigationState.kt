package navigation

import BackHandler
import NavigationHost
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import Direction
import GlobalState
import NavigatorAction
import NavigatorState
import TransitionType
import rememberDispatcher
import selectState

@Composable
fun NavigatorState(graph: @Composable (Direction) -> Unit) {

    val state by selectState<GlobalState, NavigatorState> { this.navigatorState }
    val dispatcher = rememberDispatcher()

    NavigationHost(
        currentScreen = state.added.route,
        screenToRemove = state.removed?.route,
        isForward = state.type == TransitionType.FORWARD,
        content = { direct -> Direction.values().find { it.route == direct }?.let { graph.invoke(it) } }
    )

    BackHandler(action = { dispatcher(NavigatorAction.BACK) })
}