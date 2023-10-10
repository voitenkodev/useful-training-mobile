package basic

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class DrawElement(
    val path: Path,
    val values: List<Float>,

    val lineConfigs: LineConfigs?,

    val listOfPoints: List<LinePoint>,

    val colors: Colors = Colors(
        backgroundColor = Color.Cyan
    )
) {

    data class LineConfigs(
        val color: Color,
        val width: Dp,
    )

    data class LinePoint(
        val x: Float,
        val y: Float
    )

    data class Colors(
        val backgroundColor: Color,
    )
}

internal fun generatePath(
    height: Float,
    width: Float,
    line: List<Float>,
    color: Color,
    bottomSpacing: Float = 0f
): DrawElement {

    val listOfPoints = mutableListOf<DrawElement.LinePoint>()

    val maxY = line.max()
    val minY = line.min()

    val spaceX = width / (line.size - 1)
    val spacyY = (height - bottomSpacing) / (maxY - minY)

    val p = Path().apply {
        for (i in line.indices) {
            val currentX = i * spaceX
            val currentY = height - bottomSpacing - ((line[i] - minY) * spacyY)

            if (i == 0) {
                moveTo(currentX, currentY)
            } else {

                val previousX = (i - 1) * spaceX
                val conX = (previousX + currentX) / 2f
                val conY = height - bottomSpacing - ((line[i - 1] - minY) * spacyY)

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
        lineConfigs = DrawElement.LineConfigs(
            color = color,
            width = 4.dp
        ),
        listOfPoints = listOfPoints
    )
}