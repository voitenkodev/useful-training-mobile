package design.chart

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Path

internal fun calculatePath(
    height: Float,
    width: Float,
    lines: List<PointLine>,
    onEach: ((Offset) -> Unit)? = null
): List<PointLine> {

    val maxY = lines.maxOfOrNull { item -> item.yValue.max() } ?: 0.0f
    val minY = lines.minOfOrNull { item -> item.yValue.min() } ?: 0.0f

    val spaceX = width / ((lines.maxOfOrNull { it.yValue.size } ?: 1) - 1)
    val spacyY = height / (maxY - minY)

    val result = lines.map {
        val p = Path().apply {
            for (i in it.yValue.indices) {
                val currentX = i * spaceX
                val currentY = height - ((it.yValue[i] - minY) * spacyY)

                if (i == 0) {
                    moveTo(currentX, currentY)
                } else {

                    val previousX = (i - 1) * spaceX
                    val conX = (previousX + currentX) / 2f
                    val conY = height - ((it.yValue[i - 1] - minY) * spacyY)

                    cubicTo(
                        x1 = conX,
                        y1 = conY,
                        x2 = conX,
                        y2 = currentY,
                        x3 = currentX,
                        y3 = currentY
                    )
                }
                val offset = Offset(currentX, currentY)
                it.offsets.add(offset)
                onEach?.invoke(offset)
            }
        }
        it.apply { path = p }
    }
    return result
}