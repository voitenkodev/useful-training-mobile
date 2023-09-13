package atomic

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

internal fun appDp() = AppDp(
    paddingXS = 4.dp,
    paddingS = 8.dp,
    paddingM = 16.dp,
    paddingL = 32.dp,
    header = 56.dp,
    bigHeader = 74.dp,
    component = 56.dp,
    fixedWidth = 300.dp
)

data class AppDp(
    val paddingXS: Dp,
    val paddingS: Dp,
    val paddingM: Dp,
    val paddingL: Dp,
    val header: Dp,
    val bigHeader: Dp,
    val component: Dp,
    val fixedWidth: Dp,
)