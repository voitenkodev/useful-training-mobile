package redux

import org.reduxkotlin.ReducerForActionType

data class NavigatorState(
    val stack: List<Direction> = listOf(Direction.Auth),
    val added: Direction = Direction.Auth,
    val removed: Direction? = null,
    val type: TransitionType? = TransitionType.FORWARD,
)

sealed class NavigatorAction(action: String) : Action(ReduxGroups.NAVIGATOR, action) {

    data class NAVIGATE(val direction: Direction) : NavigatorAction(action = "NAVIGATE")
    object BACK : NavigatorAction(action = "BACK")
}

enum class TransitionType { FORWARD, BACK }

sealed class Direction(val route: String) {
    object Auth : Direction(route = "auth_screen")
    object Trainings : Direction(route = "trainings_screen")
    object Training : Direction(route = "training_screen")
    object Review : Direction(route = "review_screen")
}

val navigatorReducer: ReducerForActionType<NavigatorState, NavigatorAction> = { state, action ->
    when (action) {
        is NavigatorAction.NAVIGATE -> {
            val index = state.stack.lastIndexOf(action.direction)

            if (index == -1) {
                val newList = buildList {
                    addAll(state.stack)
                    add(action.direction)
                }
                val added = newList.lastOrNull() ?: state.added
                state.copy(
                    stack = newList,
                    added = added,
                    removed = state.stack.lastOrNull(),
                    type = TransitionType.FORWARD
                )
            } else {
                val newList = state.stack.subList(0, index + 1)
                val added = newList.lastOrNull() ?: state.added
                state.copy(
                    stack = newList,
                    added = added,
                    removed = state.stack.lastOrNull(),
                    type = TransitionType.BACK
                )
            }
        }

        NavigatorAction.BACK -> {
            val lastIndex = state.stack.lastIndex
            val newList = state.stack.subList(0, lastIndex)
            val added = newList.lastOrNull() ?: state.added
            state.copy(
                stack = state.stack.subList(0, lastIndex),
                removed = state.stack.lastOrNull(),
                added = added,
                type = TransitionType.BACK
            )
        }
    }
}