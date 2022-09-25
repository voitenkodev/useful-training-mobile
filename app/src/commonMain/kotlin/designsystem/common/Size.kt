package designsystem.common

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun AppSize() = AppSize(
    space = 12.dp,
    footer = 56.dp,
    header = 56.dp,
)

data class AppSize(
    val space: Dp,
    val footer: Dp,
    val header: Dp,
)