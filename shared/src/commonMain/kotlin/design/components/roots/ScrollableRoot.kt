package design.components.roots

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
import design.Design
import utils.recomposeHighlighter

@Composable
internal fun ScrollableRoot(
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
            .padding(
                start = Design.dp.padding,
                end = Design.dp.padding,
                bottom = Design.dp.padding
            ).pointerInput(Unit) {
                detectTapGestures(onTap = { focusManager.clearFocus() })
            }.recomposeHighlighter()
    ) {

        LazyColumn(
            modifier = Modifier.weight(1f).recomposeHighlighter(),
            verticalArrangement = Arrangement.spacedBy(Design.dp.padding),
            state = listState,
            content = {
                if (header != null) {
                    item(key = "header_spacer") {
                        Spacer(modifier = Modifier.size(44.dp).recomposeHighlighter())
                    }
                    stickyHeader(
                        key = "header",
                        content = header
                    )
                }

                content?.invoke(this)
            }
        )

        if (footer != null) {

            Spacer(Modifier.size(Design.dp.padding))

            footer.invoke(this)
        }
    }

    error?.invoke()

    loading?.invoke()

    popups?.invoke()

    back?.invoke()
}