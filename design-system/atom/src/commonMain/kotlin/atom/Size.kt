package atom

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

internal fun dp() = Dp(
    paddingXS = 4.dp,
    paddingS = 8.dp,
    paddingM = 16.dp,
    paddingL = 24.dp,
    paddingXL = 32.dp,

    iconXS = 14.dp,
    iconS = 16.dp,
    iconM = 20.dp,
    iconL = 24.dp,

    componentXS = 42.dp,
    componentSM = 54.dp,
    componentL = 64.dp,
    componentXL = 120.dp,
    componentXXL = 148.dp,

    shapeSmall = 12.dp,
    shapeDefault = 12.dp,
    shapeLarge = 24.dp
)

public data class Dp(
    val paddingXS: Dp,
    val paddingS: Dp,
    val paddingM: Dp,
    val paddingL: Dp,
    val paddingXL: Dp,

    val iconXS: Dp,
    val iconS: Dp,
    val iconM: Dp,
    val iconL: Dp,

    val componentXS: Dp,
    val componentSM: Dp,
    val componentL: Dp,
    val componentXL: Dp,
    val componentXXL: Dp,

    val shapeSmall: Dp,
    val shapeDefault: Dp,
    val shapeLarge: Dp,
)