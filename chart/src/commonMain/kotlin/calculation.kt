import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.DrawScope

internal fun DrawScope.calculatePath(
    lines: List<PointLine>,
    onEach: ((Offset) -> Unit)? = null
): List<PointLine> {

    val maxY = lines.maxOfOrNull { item -> item.yValue.max() } ?: 0.0f
    val minY = lines.minOfOrNull { item -> item.yValue.min() } ?: 0.0f

    val spaceX = size.width / ((lines.maxOfOrNull { it.yValue.size } ?: 1) - 1)
    val spacyY = size.height / (maxY - minY)

    val result = lines.map {
        val p = Path().apply {
            for (i in it.yValue.indices) {
                val currentX = i * spaceX
                val currentY = size.height - ((it.yValue[i] - minY) * spacyY)

                if (i == 0) {
                    moveTo(currentX, currentY)
                } else {

                    val previousX = (i - 1) * spaceX
                    val conX1 = (previousX + currentX) / 2f
                    val conX2 = (previousX + currentX) / 2f
                    val conY1 = size.height - ((it.yValue[i - 1] - minY) * spacyY)

                    cubicTo(
                        x1 = conX1,
                        y1 = conY1,
                        x2 = conX2,
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