package components

import DesignComponent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Root2(
    modifier: Modifier = Modifier,
    header: @Composable (LazyItemScope.() -> Unit)? = null,
    footer: (@Composable ColumnScope.() -> Unit)? = null,
    floating: (@Composable BoxScope.() -> Unit)? = null,
    contentPadding: PaddingValues? = null,

    loading: (@Composable () -> Unit)? = null,
    error: (@Composable () -> Unit)? = null,
    back: (@Composable () -> Unit)? = null,

    content: LazyListScope.() -> Unit,
) {

    @Composable
    fun Content(
        modifier: Modifier = Modifier,
        contentPadding: PaddingValues
    ) = LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(DesignComponent.size.space),
        contentPadding = contentPadding,
        content = {
            if (header != null) {
                item(key = "header_spacer") { Spacer(modifier = Modifier.size(44.dp)) }
                stickyHeader(key = "header") { header.invoke(this) }
            }
            content.invoke(this)
        }
    )

    if (footer != null && floating == null) {
        Column(
            modifier = modifier.padding(
                start = DesignComponent.size.space,
                end = DesignComponent.size.space,
                bottom = DesignComponent.size.space
            ),
            verticalArrangement = Arrangement.spacedBy(DesignComponent.size.space)
        ) {
            Content(
                modifier = Modifier.weight(1f),
                contentPadding = contentPadding ?: PaddingValues(vertical = DesignComponent.size.space)
            )
            footer.invoke(this)
        }
    } else if (footer == null && floating != null) {
        Box(modifier = modifier) {
            Content(
                modifier = Modifier.fillMaxSize(),
                contentPadding = contentPadding ?: PaddingValues(DesignComponent.size.space)
            )
            floating.invoke(this)
        }
    } else if (footer != null && floating != null) {
        Column(
            modifier = modifier.padding(
                bottom = DesignComponent.size.space,
                start = DesignComponent.size.space,
                end = DesignComponent.size.space
            ),
            verticalArrangement = Arrangement.spacedBy(DesignComponent.size.space)
        ) {
            Box(modifier = Modifier.weight(1f)) {
                Content(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(vertical = DesignComponent.size.space)
                )
                floating.invoke(this)
            }
            footer.invoke(this)
        }
    } else {
        Content(
            modifier = modifier,
            contentPadding = PaddingValues(DesignComponent.size.space)
        )
    }

    error?.invoke()

    loading?.invoke()

    back?.invoke()
}