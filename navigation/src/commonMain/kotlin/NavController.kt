import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

enum class TransitionType { FORWARD, BACK }

data class NavigationState(
    private val _state: MutableStateFlow<NavController> = MutableStateFlow(NavController()),
    val state: StateFlow<NavController> = _state,
) {

    fun direct(screen: Screen, popToInclusive: Boolean = false) = _state.tryEmit(state.value.direct(screen, popToInclusive))

    fun back() = _state.tryEmit(state.value.back())

}

data class NavController(
    val stack: List<Screen> = listOf(),
    val current: Screen? = null,
    val previous: Screen? = null,
    val type: TransitionType? = TransitionType.FORWARD,
)

private fun NavController.direct(
    screen: Screen,
    popToInclusive: Boolean = false
): NavController {
    val index = stack.lastIndexOf(screen)

    if (index == -1) {

        val newList = buildList {
            addAll(if (popToInclusive) stack.subList(0, stack.lastIndex) else stack)
            add(screen)
        }
        val added = newList.lastOrNull() ?: current

        return this.copy(
            stack = newList,
            current = added,
            previous = stack.lastOrNull(),
            type = TransitionType.FORWARD
        )
    } else {

        val newList = stack.subList(0, index + 1)

        val added = newList.lastOrNull()

        return this.copy(
            stack = newList,
            current = added,
            previous = stack.lastOrNull(),
            type = TransitionType.BACK
        )
    }
}

private fun NavController.back(): NavController {
    val lastIndex = stack.lastIndex
    val newList = if (lastIndex == 0) emptyList() else stack.subList(0, lastIndex)
    return this.copy(
        stack = newList,
        current = if (newList.isNotEmpty()) newList.lastOrNull() else this.current,
        previous = stack.lastOrNull(),
        type = TransitionType.BACK
    )
}