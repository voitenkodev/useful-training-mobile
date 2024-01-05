package atom

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

internal fun dp() = Dp(
    paddingXS = 4.dp,
    paddingS = 8.dp,
    paddingM = 16.dp,
    paddingL = 24.dp,
    paddingXL = 32.dp,
    componentXS = 26.dp,
    componentS = 42.dp,
    componentM = 50.dp,
    componentL = 56.dp,
    componentXL = 146.dp,
    componentXXL = 200.dp
)

public data class Dp(
    val paddingXS: Dp,
    val paddingS: Dp,
    val paddingM: Dp,
    val paddingL: Dp,
    val paddingXL: Dp,
    val componentXS: Dp,
    val componentS: Dp,
    val componentM: Dp,
    val componentL: Dp,
    val componentXL: Dp,
    val componentXXL: Dp
)