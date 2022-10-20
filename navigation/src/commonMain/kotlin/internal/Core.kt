package internal

import Animation
import GraphBuilder
import NavigatorCore
import Render
import TransitionVariant
import androidx.compose.runtime.Composable
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

    internal val allowedScreens: MutableList<String> = mutableListOf(),
    internal val _screenMap: HashMap<String, Render> = hashMapOf()

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

    @Composable
    internal fun renderBackStack(session: NavigationSession) {
        session.current
//        backStack.onEach {
//            _screenMap[it]?.invoke()
//        }

//        AnimationCore(
//            currentScreen = session.current,
//            screenToRemove = session.removed,
//            isForward = session.type == TransitionVariant.FORWARD,
//            animation = Animation.Push(300),
//            content = {
//                _screenMap[it]?.invoke()
//            }
//        )
    }

    /* --------------------------- Internal --------------------------- */

    fun addScreens(
        screen: String,
        content: Render
    ) {
        allowedScreens.add(screen)
        _screenMap[screen] = content
    }
}