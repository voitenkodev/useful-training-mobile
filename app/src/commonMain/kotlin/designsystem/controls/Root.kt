package designsystem.controls

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import designsystem.common.DesignComponent

@Composable
fun Root(
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues? = null,
    footer: (@Composable ColumnScope.() -> Unit)? = null,
    header: (@Composable () -> Unit)? = null,
    content: LazyListScope.() -> Unit,
) {
    Column(modifier = modifier) {
        LazyColumn(
            modifier = Modifier.weight(1f),
            contentPadding = contentPadding ?: PaddingValues(DesignComponent.size.rootSpace)
        ) {

            if (header != null) {
                item(key = "toolbar_spacer") { Spacer(modifier = Modifier.size(44.dp)) }
                item(key = "toolbar") { header.invoke() }
            }

            content.invoke(this)
        }
        footer?.invoke(this)
    }
}