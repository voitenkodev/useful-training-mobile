package redux

import org.reduxkotlin.ReducerForActionType

data class NavigatorState(
    val stack: List<Direction> = listOf(Direction.Auth),
)

sealed class NavigatorAction(action: String) : Action(ReduxGroups.NAVIGATOR, action) {

    data class GoTo(val direction: Direction) : NavigatorAction(action = "DIRECT_TO")

    data class BackTo(val direction: Direction) : NavigatorAction(action = "BACK_TO")
}

sealed class Direction(private val route: String) {
    object Auth : Direction(route = "auth_screen")
    object Trainings : Direction(route = "trainings_screen")
    object Training : Direction(route = "training_screen")
    object Review : Direction(route = "review_screen")
}

val navigatorReducer: ReducerForActionType<NavigatorState, NavigatorAction> = { state, action ->
    when (action) {
        is NavigatorAction.BackTo -> {
            val index = state.stack.lastIndexOf(action.direction)
            val newStack = if (index == -1) state.stack else state.stack.subList(0, index)
            state.copy(stack = newStack)
        }

        is NavigatorAction.GoTo -> {
            val newStack = buildList {
                addAll(state.stack)
                add(action.direction)
            }
            state.copy(stack = newStack)
        }
    }
}