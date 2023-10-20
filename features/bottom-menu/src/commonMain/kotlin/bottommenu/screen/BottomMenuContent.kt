package bottommenu.screen

import Design
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import bottommenu.components.MenuItem
import platformBottomInset

@Composable
internal fun BottomMenuContent(
    items: List<Pair<ImageVector, String>>,
    selected: Pair<ImageVector, String>,
    onClick: (index: Int) -> Unit,
    screen: @Composable () -> Unit
) {
    Content(
        items = items,
        selected = selected,
        onClick = onClick,
        screen = screen
    )
}

@Composable
private fun Content(
    items: List<Pair<ImageVector, String>>,
    selected: Pair<ImageVector, String>,
    onClick: (index: Int) -> Unit,
    screen: @Composable () -> Unit
) {

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Box(
            modifier = Modifier.weight(1f),
            content = { screen.invoke() }
        )

        Row(
            modifier = Modifier
                .background(color = Design.colors.tertiary)
                .platformBottomInset()
                .background(color = Design.colors.tertiary)
                .padding(Design.dp.paddingS)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            repeat(items.size) {
                MenuItem(
                    modifier = Modifier.weight(1f),
                    text = items[it].second,
                    icon = items[it].first,
                    isSelected = selected == items[it],
                    onClick = { onClick.invoke(it) }
                )
            }
        }
    }
}