package bottommenu

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import bottommenu.screen.BottomMenuContent

@Composable
public fun BottomMenuFeature(
    items: List<Pair<ImageVector, String>>,
    onClick: (index: Int) -> Unit,
    screen: @Composable () -> Unit
) {
    BottomMenuContent(
        items = items,
        onClick = onClick,
        screen = screen
    )
}
