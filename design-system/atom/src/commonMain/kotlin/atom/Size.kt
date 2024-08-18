package atom

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

internal fun dp() = Dp(
    paddingXS = 4.dp,
    paddingS = 8.dp,
    paddingM = 16.dp,
    paddingL = 24.dp,
    paddingXL = 32.dp,
    paddingXXL = 62.dp,


    iconS = 16.dp,
    iconM = 20.dp,


    componentS = 42.dp,
    componentM = 54.dp,
    componentXL = 64.dp,
    componentXXL = 148.dp
)

public data class Dp(
    val paddingXS: Dp,
    val paddingS: Dp,
    val paddingM: Dp,
    val paddingL: Dp,
    val paddingXL: Dp,
    val paddingXXL: Dp,

    val iconS: Dp,
    val iconM: Dp,

    val componentS: Dp,

    // Button, Input, Toolbar
    val componentM: Dp,

    // Calendar item
    val componentXL: Dp,

    // Muscle group image
    val componentXXL: Dp,
)