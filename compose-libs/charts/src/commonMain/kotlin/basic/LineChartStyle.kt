package basic

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


public data class LineChartStyle(
    val lineColor: Color,
    val lineWidth: Dp = 4.dp,

    val labelStyle: LineChartLabelStyle? = null,
    val dotsStyle: LineChartDotsStyle? = null,
    val backgroundStyle: LineChartBackgroundStyle? = null
)

public data class LineChartLabelStyle(
    val backgroundColor: Color,
    val borderColor: Color,
    val borderWidth: Dp,
    val textColor: Color,
    val paddings: Dp,
    val spaceTillLine: Dp
)


public data class LineChartBackgroundStyle(
    val backgroundColor: Color
)

public data class LineChartDotsStyle(
    val backgroundColor: Color,
    val width: Dp,
    val type: DotsType
) {
    public enum class DotsType { ALL, START_END }
}