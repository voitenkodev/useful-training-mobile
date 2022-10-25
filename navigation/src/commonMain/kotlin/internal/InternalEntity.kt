package internal

import Animation
import ScreenScope
import androidx.compose.runtime.Composable

private typealias Render = @Composable (ScreenScope) -> Unit

internal enum class TransitionVariant { FORWARD, BACK }

internal data class NavigationTransaction(
    val current: String? = null,
    val removed: String? = null,
    val type: TransitionVariant? = null,
    val animation: Animation,
)

internal data class ScreenConfigurations(
    val screen: String,
    val render: Render,
    val animation: Animation
)

internal data class ScopeStoreObject(
    val value: Any,
    val clearValue: (Any) -> Unit
)