package design.atomic

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

fun appDp() = AppDp(
    padding = 12.dp,
    header = 56.dp,
    bigHeader = 74.dp,
    component = 48.dp,
)

data class AppDp(
    val padding: Dp,
    val header: Dp,
    val bigHeader: Dp,
    val component: Dp,
)