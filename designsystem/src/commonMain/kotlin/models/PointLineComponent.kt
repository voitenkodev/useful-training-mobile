package models

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class PointLineComponent(
    val label: String,
    val yValue: List<Float>,
    val lineColor: Color,
    val fillColor: Color? = null,
    val pointColor: Color? = null,
    val pathWidth: Dp = 2.dp,
    val pathEffect: PathEffect? = null
)