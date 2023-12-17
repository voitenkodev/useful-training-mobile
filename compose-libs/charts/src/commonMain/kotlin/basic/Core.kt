package basic

import androidx.compose.ui.graphics.Path

internal data class DrawElement(
    val path: Path,
    val values: List<Float>,

    val listOfPoints: List<LinePoint>,
) {

    data class LinePoint(
        val x: Float,
        val y: Float
    )
}

internal fun generatePath(
    height: Float,
    width: Float,
    line: List<Float>,
    bottomSpacing: Float = 0f,
    topSpacing: Float = 0f,
): DrawElement {

    val listOfPoints = mutableListOf<DrawElement.LinePoint>()

    val maxY = line.max()
    val minY = line.min()

    val spaceX = if (line.size > 1) width / (line.size - 1) else 0f
    val spaceY = if (maxY > minY) (height - bottomSpacing - topSpacing) / (maxY - minY) else 0f

    val p = Path().apply {
        for (i in line.indices) {
            val currentX = i * spaceX
            val currentY = height - bottomSpacing - ((line[i] - minY) * spaceY)

            if (i == 0) {
                moveTo(currentX, currentY)
            } else {

                val previousX = (i - 1) * spaceX
                val conX = (previousX + currentX) / 2f
                val conY = height - bottomSpacing - ((line[i - 1] - minY) * spaceY)

                cubicTo(
                    x1 = conX,
                    y1 = conY,
                    x2 = conX,
                    y2 = currentY,
                    x3 = currentX,
                    y3 = currentY
                )
            }

            listOfPoints.add(DrawElement.LinePoint(x = currentX, y = currentY))
        }
    }

    return DrawElement(
        path = p,
        values = line,
        listOfPoints = listOfPoints,
    )
}