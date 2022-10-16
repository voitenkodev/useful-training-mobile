data class NavigatorState(
    val stack: List<Direction> = listOf(Direction.Auth),
    val added: Direction? = Direction.Auth,
    val removed: Direction? = null,
    val type: TransitionTypee? = TransitionTypee.FORWARD,
)

sealed class NavigatorAction(action: String) : Action(ReduxGroups.NAVIGATOR, action) {

    data class NAVIGATE(val direction: Direction, val popToInclusive: Boolean = false) : NavigatorAction(action = "NAVIGATE")

    object BACK : NavigatorAction(action = "BACK")
}

enum class TransitionTypee { FORWARD, BACK }

enum class Direction(val route: String) {
    Auth(route = "auth_screen"),
    Trainings(route = "trainings_screen"),
    Training(route = "training_screen"),
    Review(route = "review_screen")
}

val navigatorReducer: ReducerForActionType<NavigatorState, GlobalState, NavigatorAction> = { state, _, action ->
    when (action) {
        is NavigatorAction.NAVIGATE -> {
            val index = state.stack.lastIndexOf(action.direction)

            if (index == -1) {
                val newList = buildList {
                    addAll(if (action.popToInclusive) state.stack.subList(0, state.stack.lastIndex) else state.stack)
                    add(action.direction)
                }
                val added = newList.lastOrNull() ?: state.added
                state.copy(
                    stack = newList,
                    added = added,
                    removed = state.stack.lastOrNull(),
                    type = TransitionTypee.FORWARD
                )
            } else {
                val newList = state.stack.subList(0, index + 1)
                val added = newList.lastOrNull()
                state.copy(
                    stack = newList,
                    added = added,
                    removed = state.stack.lastOrNull(),
                    type = TransitionTypee.BACK
                )
            }
        }

        NavigatorAction.BACK -> {
            val lastIndex = state.stack.lastIndex
            val newList = if (lastIndex == 0) emptyList() else state.stack.subList(0, lastIndex)
            state.copy(
                stack = newList,
                removed = state.stack.lastOrNull(),
                added = state.added,
                type = TransitionTypee.BACK
            )
        }
    }
}