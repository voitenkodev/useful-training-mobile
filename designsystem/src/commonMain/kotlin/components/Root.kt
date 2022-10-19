package components

import DesignComponent
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

    header: @Composable (LazyItemScope.() -> Unit)? = null,
    footer: (@Composable ColumnScope.() -> Unit)? = null,

    content: (@Composable ColumnScope.() -> Unit)? = null,
    scrollableContent: (LazyListScope.() -> Unit)? = null,
) {
    Column(
        modifier = modifier.padding(
            start = DesignComponent.size.space,
            end = DesignComponent.size.space,
            bottom = DesignComponent.size.space
        ),
    ) {
        LazyColumn(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(DesignComponent.size.space),
            content = {
                if (header != null) {
                    item(key = "header_spacer") { Spacer(modifier = Modifier.size(44.dp)) }
                    stickyHeader(key = "header") { header.invoke(this) }
                }

                if (content != null) {
                    item(key = "content") {
                        Column(verticalArrangement = Arrangement.spacedBy(DesignComponent.size.space)) {
                            content.invoke(this)
                        }
                    }
                }
                scrollableContent?.invoke(this)
            }
        )
        footer?.invoke(this)
    }

    error?.invoke()

    loading?.invoke()

    back?.invoke()
}