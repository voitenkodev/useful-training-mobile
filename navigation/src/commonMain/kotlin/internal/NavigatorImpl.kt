package internal

import NavController
import Navigator
import Screen
import TransitionType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

internal data class NavigatorImpl(
    private val _state: MutableStateFlow<NavController> = MutableStateFlow(NavController()),
    override val state: StateFlow<NavController> = _state,
) : Navigator {

    override fun direct(screen: Screen, popToInclusive: Boolean) {
        _state.tryEmit(state.value.direct(screen, popToInclusive))
    }

    override fun back() {
        _state.tryEmit(state.value.back())
    }
}

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

        val added = newList.last()

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
        current = if (newList.isNotEmpty()) newList.last() else this.current,
        previous = stack.lastOrNull(),
        type = TransitionType.BACK
    )
}