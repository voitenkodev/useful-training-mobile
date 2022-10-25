package internal

import GraphBuilder
import NavigatorCore
import Store
import androidx.compose.runtime.Composable
import kotlinx.coroutines.flow.MutableStateFlow

private typealias Render = @Composable (Store) -> Unit

internal enum class TransitionVariant { FORWARD, BACK }

internal data class NavigationSession(
    val current: String? = null,
    val removed: String? = null,
    val type: TransitionVariant? = null
)

internal data class Core(
    /** Last Navigation session **/
    internal val session: MutableStateFlow<NavigationSession> = MutableStateFlow(NavigationSession()),
    /** Backstack of screens **/
    private val backStack: MutableList<String> = mutableListOf(),
    /** Pool of screens **/
    private val screenMap: HashMap<String, Render> = hashMapOf(),
    /** Pool of screen objects **/
    internal val storeMap: StoreImpl = StoreImpl
) : NavigatorCore, GraphBuilder {

    /* --------------------------- NavigatorCore --------------------------- */

    override fun navigate(screen: String, popToInclusive: Boolean) {

        val index = backStack.lastIndexOf(screen)

        if (index == -1) {

            val removed = backStack.lastOrNull()

            if (popToInclusive) backStack.removeLastOrNull()

            backStack.add(screen)
            session.tryEmit(
                NavigationSession(
                    current = screen,
                    removed = removed,
                    type = TransitionVariant.FORWARD
                )
            )
        } else {
            val removed = backStack.lastOrNull()

            backStack.removeAt(index)

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
        val removed = backStack.removeLastOrNull()

        session.tryEmit(
            NavigationSession(
                current = backStack.lastOrNull(),
                removed = removed,
                type = TransitionVariant.BACK,
            )
        )
    }

    /* --------------------------- GraphBuilder --------------------------- */

    override fun screen(screen: String, content: @Composable (Store) -> Unit) {
        screenMap[screen] = content
    }

    /* --------------------------- Internal --------------------------- */

    @Composable
    internal fun render(screen: String) {
        screenMap[screen]?.invoke(storeMap)
    }

    internal fun remove(screen: String) {
        storeMap.remove(screen)
    }
}