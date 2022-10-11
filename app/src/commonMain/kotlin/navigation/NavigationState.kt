package navigation

import NavigationHost
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import platform.BackHandler
import redux.Direction
import redux.GlobalState
import redux.NavigatorAction
import redux.NavigatorState
import redux.rememberDispatcher
import redux.selectState

@Composable
fun NavigatorState(graph: @Composable (Direction) -> Unit) {

    val state by selectState<GlobalState, NavigatorState> { this.navigatorState }
    val dispatcher = rememberDispatcher()

    NavigationHost(
        currentScreen = state.added.route,
        screenToRemove = state.removed?.route,
        isForward = state.type == redux.TransitionType.FORWARD,
        content = { direct -> Direction.values().find { it.route == direct }?.let { graph.invoke(it) } }
    )

    BackHandler(action = { dispatcher(NavigatorAction.BACK) })
}