package components.roots

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import recomposeHighlighter

@Composable
public fun Root(
    modifier: Modifier = Modifier,
    loading: (@Composable () -> Unit)? = null,
    error: (@Composable () -> Unit)? = null,
    back: (@Composable () -> Unit)? = null,
    popups: (@Composable () -> Unit)? = null,
    content: (@Composable BoxScope.() -> Unit),
) {

    val focusManager = LocalFocusManager.current

    Box(
        modifier = modifier
            .fillMaxSize()
            .pointerInput(Unit) {
                detectTapGestures(
                    onTap = { focusManager.clearFocus() },
                )
            }.recomposeHighlighter(),
        content = content
    )

    error?.invoke()

    loading?.invoke()

    popups?.invoke()

    back?.invoke()
}