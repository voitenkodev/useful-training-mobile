package navigation

import platform.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
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

    AnimatedHost(
        currentScreen = state.added,
        screenToRemove = state.removed,
        animationType = AnimationType.Push(300),
        isForward = state.type == redux.TransitionType.FORWARD,
        content = graph
    )

    BackHandler(action = { dispatcher(NavigatorAction.BACK) })
}