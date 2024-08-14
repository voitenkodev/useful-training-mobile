package heightpicker

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

public data class HeightPickerStyle(
    var normalLineColor: Color,
    var tenStepLineColor: Color,
    var fiveStepLineColor: Color,

    val oneLineLength: Dp = 20.dp,
    val fiveStepLineLength: Dp = 28.dp,
    val tenStepLineLength: Dp = 40.dp,

    var strokeWidth: Dp = 3.dp,
    var spaceInterval: Int = 26,
    var visibilityRange: Int = 30
)