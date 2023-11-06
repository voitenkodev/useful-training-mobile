package weightpicker

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

public data class WeightPickerStyle(
    val scaleWidth: Dp = 100.dp,
    val radius: Dp = 550.dp,
    val normalLineColor: Color,
    val fiveStepLineColor: Color,
    val tenStepLineColor: Color,
    val backgroundColor: Color,
    val designLinesColor: Color,
    val normalLineLength: Dp = 15.dp,
    val fiveStepLineLength: Dp = 25.dp,
    val tenStepLineLength: Dp = 35.dp,
    var strokeWidth: Dp = 1.dp,
    val scaleIndicatorLength: Dp = 60.dp,
    val indicatorColor: Color
)