package design.components.roots

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import design.Design

@Composable
internal fun Root(
    modifier: Modifier = Modifier,

    loading: (@Composable () -> Unit)? = null,
    error: (@Composable () -> Unit)? = null,
    back: (@Composable () -> Unit)? = null,
    popups: (@Composable () -> Unit)? = null,

    header: @Composable (ColumnScope.() -> Unit)? = null,
    footer: (@Composable ColumnScope.() -> Unit)? = null,

    content: (@Composable ColumnScope.() -> Unit)? = null,
) {

    val focusManager = LocalFocusManager.current

    Column(
        modifier = modifier
            .padding(
                start = Design.dp.padding,
                end = Design.dp.padding,
                bottom = Design.dp.padding
            ).pointerInput(Unit) {
                detectTapGestures(onTap = { focusManager.clearFocus() })
            },
        verticalArrangement = Arrangement.spacedBy(Design.dp.padding)
    ) {

        header?.invoke(this)

        content?.invoke(this)

        Spacer(modifier = Modifier.weight(1f))

        footer?.invoke(this)
    }

    error?.invoke()

    loading?.invoke()

    popups?.invoke()

    back?.invoke()
}