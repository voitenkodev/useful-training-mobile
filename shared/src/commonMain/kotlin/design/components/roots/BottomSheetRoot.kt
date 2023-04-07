package design.components.roots

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.Dp
import design.controls.BottomSheet

@Composable
internal fun BottomSheetRoot(
    modifier: Modifier = Modifier,

    loading: (@Composable () -> Unit)? = null,
    error: (@Composable () -> Unit)? = null,
    back: (@Composable () -> Unit)? = null,
    popups: (@Composable () -> Unit)? = null,

    footer: (@Composable ColumnScope.() -> Unit)? = null,

    collapsed: Dp,
    expanded: Dp,

    topBar: @Composable BoxScope.(progress: Float) -> Unit,

    listState: LazyListState = rememberLazyListState(),

    content: LazyListScope.() -> Unit,
) {

    val focusManager = LocalFocusManager.current

    Column {
        BottomSheet(
            modifier = modifier
                .weight(1f)
                .pointerInput(Unit) {
                    detectTapGestures(onTap = { focusManager.clearFocus() })
                },
            collapsed = collapsed,
            expanded = expanded,
            listState = listState,
            topBar = topBar,
            content = content
        )
        footer?.invoke(this)
    }

    error?.invoke()

    loading?.invoke()

    popups?.invoke()

    back?.invoke()
}