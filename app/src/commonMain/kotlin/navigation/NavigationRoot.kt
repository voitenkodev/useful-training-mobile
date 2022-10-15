package navigation

import Direction
import GlobalState
import NavigationHost
import NavigatorState
import TransitionType
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import selectState

@Composable
fun NavigatorRoot(
    graph: @Composable (Direction) -> Unit,
    finalize: () -> Unit
) {

    val state by selectState<GlobalState, NavigatorState> { this.navigatorState }

    NavigationHost(
        currentScreen = state.added?.route,
        screenToRemove = state.removed?.route,
        isForward = state.type == TransitionType.FORWARD,
        content = { direct -> Direction.values().find { it.route == direct }?.let { graph.invoke(it) } }
    )

    // Exit app logic
    if (state.stack.isEmpty()) {
        finalize.invoke()
        return
    }
}