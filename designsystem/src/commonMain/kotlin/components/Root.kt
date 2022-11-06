package components

import Design
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Root(
    modifier: Modifier = Modifier,

    loading: (@Composable () -> Unit)? = null,
    error: (@Composable () -> Unit)? = null,
    back: (@Composable () -> Unit)? = null,
    popup: (@Composable () -> Unit)? = null,

    header: @Composable (LazyItemScope.() -> Unit)? = null,
    footer: (@Composable ColumnScope.() -> Unit)? = null,

    content: (@Composable ColumnScope.() -> Unit)? = null,
    scrollableContent: (LazyListScope.() -> Unit)? = null,
) {
    Column(
        modifier = modifier.padding(
            start = Design.dp.padding,
            end = Design.dp.padding,
            bottom = Design.dp.padding
        ),
    ) {

        LazyColumn(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(Design.dp.padding),
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

                if (content != null) {
                    item(key = "content") {
                        Column(
                            verticalArrangement = Arrangement.spacedBy(Design.dp.padding),
                            content = content
                        )
                    }
                }

                scrollableContent?.invoke(this)
            }
        )
        footer?.invoke(this)
    }

    error?.invoke()

    loading?.invoke()

    popup?.invoke()

    back?.invoke()
}