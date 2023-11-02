package components.roots

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import atom.Design
import platformInsets

@Deprecated("Use designSystem.Root")
@Composable
public fun ScrollableRoot(
    modifier: Modifier = Modifier,

    loading: (@Composable () -> Unit)? = null,
    error: (@Composable () -> Unit)? = null,
    back: (@Composable () -> Unit)? = null,
    popups: (@Composable () -> Unit)? = null,

    header: @Composable (LazyItemScope.() -> Unit)? = null,
    footer: (@Composable ColumnScope.() -> Unit)? = null,

    listState: LazyListState = rememberLazyListState(),
    content: (LazyListScope.() -> Unit)? = null,
) {

    val focusManager = LocalFocusManager.current
    Column(
        modifier = modifier
            .platformInsets()
            .padding(
                start = Design.dp.paddingM,
                end = Design.dp.paddingM,
                bottom = Design.dp.paddingM
            ).pointerInput(Unit) {
                detectTapGestures(
                    onTap = { focusManager.clearFocus() },
                )
            }/*.pointerInput(Unit) {
                detectSwipe(
                    onSwipeDown = {
                        focusManager.clearFocus()
                    }
                )
            }*/,
        verticalArrangement = Arrangement.spacedBy(Design.dp.paddingM)
    ) {

        LazyColumn(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(Design.dp.paddingM),
            state = listState,
            content = {
                if (header != null) {
                    item(key = "header_spacer") {
                        Spacer(modifier = Modifier.size(44.dp))
                    }
                    stickyHeader(
                        key = "header",
                        content = header
                    )
                }

                content?.invoke(this)
            }
        )

        footer?.invoke(this)
    }

    error?.invoke()

    loading?.invoke()

    popups?.invoke()

    back?.invoke()
}