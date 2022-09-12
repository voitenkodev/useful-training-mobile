package designsystem.common

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun AppSize() = AppSize(
    rootSpace = 12.dp,
    itemSpace = 12.dp
)

data class AppSize(
    val rootSpace: Dp,
    val itemSpace: Dp
)