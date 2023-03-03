package navigation.internal

import androidx.compose.runtime.Composable
import kotlinx.coroutines.flow.MutableStateFlow
import navigation.Animation
import navigation.GraphBuilder
import navigation.NavigatorCore
import navigation.ScreenScope

private val DefaultAnimation = Animation.None

internal data class Core(
    internal val transaction: MutableStateFlow<NavigationTransaction> = MutableStateFlow(NavigationTransaction(animation = DefaultAnimation)),
    private val backStack: MutableList<String> = mutableListOf(),
    private val screenMap: HashMap<String, ScreenConfigurations> = hashMapOf(),
    private val storeMap: MutableMap<String, ScopeStoreObject> = mutableMapOf()
) : NavigatorCore, GraphBuilder, ScreenScope {

    /* --------------------------- NavigatorCore --------------------------- */

    override fun navigate(screen: String, popToInclusive: Boolean) {
        if (backStack.lastOrNull() == screen) return
        val index = backStack.lastIndexOf(screen)
        if (index == -1) {
            val removed = backStack.lastOrNull()
            if (popToInclusive) backStack.removeLastOrNull()
            backStack.add(screen)
            val animation = screenMap[screen]?.animation ?: DefaultAnimation
            transaction.tryEmit(
                NavigationTransaction(
                    current = screen,
                    removed = removed,
                    type = TransitionVariant.FORWARD,
                    animation = animation
                )
            )
        } else {
            val removed = backStack.lastOrNull()

            backStack.removeAt(index)

            val animation = screenMap[removed]?.animation ?: DefaultAnimation

            transaction.tryEmit(
                NavigationTransaction(
                    current = screen,
                    removed = removed,
                    type = TransitionVariant.BACK,
                    animation = animation,
                )
            )
        }
    }

    override fun back() {
        val removed = backStack.removeLastOrNull()
        val current = backStack.lastOrNull()
        val animation = screenMap[removed]?.animation ?: DefaultAnimation
        transaction.tryEmit(
            NavigationTransaction(
                current = current,
                removed = removed,
                type = TransitionVariant.BACK,
                animation = animation
            )
        )
    }

    /* --------------------------- GraphBuilder --------------------------- */

    override fun screen(
        key: String,
        animation: Animation?,
        content: @Composable (ScreenScope) -> Unit
    ) {
        screenMap[key] = ScreenConfigurations(
            screen = key,
            render = content,
            animation = animation ?: DefaultAnimation
        )
    }

    /* --------------------------- Store --------------------------- */

    @Suppress("UNCHECKED_CAST")
    override fun <T : Any> getOrCreate(
        key: String,
        factory: () -> T,
        clear: (T) -> Unit
    ): T = storeMap.getOrPut(key) {
        ScopeStoreObject(value = factory.invoke(), clearValue = (clear as (Any) -> Unit))
    }.value as T

    /* --------------------------- Internal --------------------------- */

    @Composable
    internal fun draw(screen: String) {
        screenMap[screen]?.render?.invoke(this)
    }

    internal fun drop(screen: String) = storeMap.forEach {
        if (it.key.startsWith(screen)) {
            it.value.clearValue.invoke(it.value.value)
            storeMap -= it.key
        }
    }
}