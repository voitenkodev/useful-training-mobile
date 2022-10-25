package internal

import GraphBuilder
import NavigatorCore
import ScreenScope
import androidx.compose.runtime.Composable
import kotlinx.coroutines.flow.MutableStateFlow

private typealias Render = @Composable (ScreenScope) -> Unit

internal enum class TransitionVariant { FORWARD, BACK }

internal data class NavigationTransaction(
    val current: String? = null,
    val removed: String? = null,
    val type: TransitionVariant? = null
)

internal data class ScopeStoreObject(
    val value: Any,
    val clearValue: (Any) -> Unit
)

internal data class Core(
    /** Last Navigation session **/
    internal val transaction: MutableStateFlow<NavigationTransaction> = MutableStateFlow(NavigationTransaction()),
    /** Backstack of screens **/
    private val backStack: MutableList<String> = mutableListOf(),
    /** Pool of screens **/
    private val screenMap: HashMap<String, Render> = hashMapOf(),
    /** Pool of screen objects **/
    private val storeMap: MutableMap<String, ScopeStoreObject> = mutableMapOf()
) : NavigatorCore, GraphBuilder, ScreenScope {

    /* --------------------------- NavigatorCore --------------------------- */

    override fun navigate(screen: String, popToInclusive: Boolean) {
        val index = backStack.lastIndexOf(screen)
        if (index == -1) {
            val removed = backStack.lastOrNull()
            if (popToInclusive) backStack.removeLastOrNull()
            backStack.add(screen)
            transaction.tryEmit(
                NavigationTransaction(
                    current = screen,
                    removed = removed,
                    type = TransitionVariant.FORWARD
                )
            )
        } else {
            val removed = backStack.lastOrNull()
            backStack.removeAt(index)
            transaction.tryEmit(
                NavigationTransaction(
                    current = screen,
                    removed = removed,
                    type = TransitionVariant.BACK
                )
            )
        }
    }


    override fun back() {
        val removed = backStack.removeLastOrNull()
        transaction.tryEmit(
            NavigationTransaction(
                current = backStack.lastOrNull(),
                removed = removed,
                type = TransitionVariant.BACK,
            )
        )
    }

    /* --------------------------- GraphBuilder --------------------------- */

    override fun screen(screen: String, content: @Composable (ScreenScope) -> Unit) {
        screenMap[screen] = content
    }

    /* --------------------------- Store --------------------------- */

    @Suppress("UNCHECKED_CAST")
    override fun <T : Any> getOrCreate(
        key: String, factory: () -> T,
        clear: (T) -> Unit
    ): T {
        return storeMap.getOrPut(key) {
            ScopeStoreObject(
                value = factory.invoke(),
                clearValue = (clear as (Any) -> Unit)
            )
        }.value as T
    }

    /* --------------------------- Internal --------------------------- */

    @Composable
    internal fun render(screen: String) {
        screenMap[screen]?.invoke(this)
    }

    internal fun remove(screen: String) {
        storeMap.forEach {
            if (it.key.startsWith(screen)) {
                it.value.clearValue.invoke(it.value.value)
                storeMap -= it.key
            }
        }
    }
}