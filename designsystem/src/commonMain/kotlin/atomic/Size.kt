package atomic

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun AppDp() = AppDp(
    padding = 12.dp,
    collapsedAppBar = 80.dp,
    expandedAppBar = 240.dp,
    component = 48.dp,
)

data class AppDp(
    val padding: Dp,
    val collapsedAppBar: Dp,
    val expandedAppBar: Dp,
    val component: Dp,
)