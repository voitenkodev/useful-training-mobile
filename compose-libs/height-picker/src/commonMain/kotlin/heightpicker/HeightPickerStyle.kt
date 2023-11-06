package heightpicker

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

public data class HeightPickerStyle(
    var normalLineColor: Color,
    var tenStepLineColor: Color,
    var fiveStepLineColor: Color,
    var backgroundColor: Color,
    var indicatorColor: Color,
    val normalLineLength: Dp = 7.dp,
    val fiveStepLineLength: Dp = 12.dp,
    val tenStepLineLength: Dp = 17.dp,
    var strokeWidth: Dp = 1.dp,
    var spaceInterval: Int = 26
)