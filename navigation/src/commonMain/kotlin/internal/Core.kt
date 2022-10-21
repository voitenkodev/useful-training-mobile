package internal

import GraphBuilder
import NavigatorCore
import Render
import TransitionVariant
import kotlinx.coroutines.flow.MutableStateFlow

public data class NavigationSession(
    val current: String? = null,
    val removed: String? = null,
    val type: TransitionVariant? = null
)

internal data class Core(

    override val session: MutableStateFlow<NavigationSession> = MutableStateFlow(NavigationSession()),

    private val _backStack: MutableList<String> = mutableListOf(),
    internal val backStack: List<String> = _backStack,

    private val allowedScreens: MutableList<String> = mutableListOf(),
    private val _screenMap: HashMap<String, Render> = hashMapOf(),
    internal val screenMap: Map<String, Render> = _screenMap

) : NavigatorCore, GraphBuilder {

    /* --------------------------- NavigatorCore --------------------------- */

    override fun navigate(screen: String, popToInclusive: Boolean) {

        val index = backStack.lastIndexOf(screen)

        if (index == -1) {

            val removed = _backStack.lastOrNull()

            if (popToInclusive) _backStack.removeLastOrNull()

            _backStack.add(screen)
            session.tryEmit(
                NavigationSession(
                    current = screen,
                    removed = removed,
                    type = TransitionVariant.FORWARD
                )
            )
        } else {
            val removed = backStack.lastOrNull()

            _backStack.removeAt(index)

            session.tryEmit(
                NavigationSession(
                    current = screen,
                    removed = removed,
                    type = TransitionVariant.BACK
                )
            )
        }
    }


    override fun back() {
        val removed = _backStack.removeLastOrNull()

        session.tryEmit(
            NavigationSession(
                current = _backStack.lastOrNull(),
                removed = removed,
                type = TransitionVariant.BACK,
            )
        )
    }

    /* --------------------------- GraphBuilder --------------------------- */

    override fun screen(
        screen: String,
        content: Render
    ) {
        allowedScreens.add(screen)
        _screenMap[screen] = content
    }
}