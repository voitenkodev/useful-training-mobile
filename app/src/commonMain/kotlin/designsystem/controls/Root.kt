package designsystem.controls

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import designsystem.common.DesignComponent

@Composable
fun RootPrimary(
    modifier: Modifier = Modifier,
    footer: (@Composable ColumnScope.() -> Unit)? = null,
    title: String? = null,
    menu: (@Composable RowScope.() -> Unit)? = null,
    paddingValues: PaddingValues? = null,
    content: LazyListScope.() -> Unit,
) = Column(
    modifier = modifier.padding(DesignComponent.size.rootSpace),
) {

    LazyContent(
        modifier = Modifier.weight(1f),
        title = title,
        menu = menu,
        content = content,
        paddingValues = paddingValues
    )

    footer?.invoke(this)
}

@Composable
fun RootSecondary(
    modifier: Modifier = Modifier,
    floating: (@Composable BoxScope.() -> Unit)? = null,
    title: String? = null,
    menu: (@Composable RowScope.() -> Unit)? = null,
    paddingValues: PaddingValues? = null,
    content: LazyListScope.() -> Unit,
) = Box(
    modifier = modifier.padding(DesignComponent.size.rootSpace),
) {

    LazyContent(
        modifier = Modifier.fillMaxSize(),
        title = title,
        menu = menu,
        content = content,
        paddingValues = paddingValues
    )

    floating?.invoke(this)
}

@Composable
private fun LazyContent(
    modifier: Modifier = Modifier,
    title: String?,
    menu: @Composable (RowScope.() -> Unit)?,
    paddingValues: PaddingValues? = null,
    content: LazyListScope.() -> Unit,
) = LazyColumn(modifier = modifier,
    verticalArrangement = Arrangement.spacedBy(DesignComponent.size.itemSpace),
    contentPadding = paddingValues ?: PaddingValues(bottom = DesignComponent.size.rootSpace),
    content = {
        toolbarItem(title = title, menu = menu)
        content.invoke(this)
    })

private fun LazyListScope.toolbarItem(
    title: String?, menu: @Composable (RowScope.() -> Unit)?
) {
    if (title != null || menu != null) {
        item(key = "toolbar_spacer") { Spacer(modifier = Modifier.size(44.dp)) }
        stickyHeader(key = "toolbar") {
            Row(
                modifier = Modifier.fillMaxWidth().background(DesignComponent.colors.primary),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                if (title != null) TextFieldH1(modifier = Modifier.weight(1f), text = title)
                else Spacer(modifier = Modifier.weight(1f))
                menu?.invoke(this)
            }
        }
    }
}