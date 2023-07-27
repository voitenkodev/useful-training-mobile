package chart

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class PointLine(
    val yValue: List<Float>,
    val label: String = String(),
    val lineColor: Color,
    val fillColor: Color? = null,
    val width: Dp = 2.dp,
    val pathEffect: PathEffect? = null,
    val point: PointCircle? = null,
) {

    // Need to fill using canvas board
    var path: Path = Path()
    var offsets: MutableList<Offset> = mutableListOf()
}

data class PointCircle(
    val color: Color,
    val radius: Dp = 4.dp,
)