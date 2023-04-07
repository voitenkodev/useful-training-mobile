package navigation

import androidx.compose.runtime.Composable
import navigation.internal.LocalNavigator

@Composable
internal fun findNavigator(): NavigatorCore = LocalNavigator.current

internal interface NavigatorCore {
    fun navigate(screen: String, popToInclusive: Boolean = false, args: Map<String, Any> = emptyMap())
    fun back()
}

internal interface GraphBuilder {
    fun screen(
        key: String,
        animation: Animation? = null,
        content: @Composable (ScreenScope) -> Unit
    )
}

internal interface ScreenScope {
    fun <T : Any> getOrCreate(key: String, factory: () -> T, clear: (T) -> Unit): T

    val args: Map<String, Any>
}