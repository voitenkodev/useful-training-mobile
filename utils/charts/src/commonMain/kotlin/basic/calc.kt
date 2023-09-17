package basic

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class DrawElement(
    val path: Path,
    val values: List<Float>,

    val lineConfigs: LineConfigs?,

    val colors: Colors = Colors(
        backgroundColor = Color.Cyan
    )

) {

    data class LineConfigs(
        val color: Color,
        val width: Dp
    )

    data class Colors(
        val backgroundColor: Color,
    )
}

internal fun generatePath(
    height: Float,
    width: Float,
    line: List<Float>,
    color: Color
): DrawElement {

    val maxY = line.max()
    val minY = line.min()

    val spaceX = width / (line.size - 1)
    val spacyY = height / (maxY - minY)

    val p = Path().apply {
        for (i in line.indices) {
            val currentX = i * spaceX
            val currentY = height - ((line[i] - minY) * spacyY)

            if (i == 0) {
                moveTo(currentX, currentY)
            } else {

                val previousX = (i - 1) * spaceX
                val conX = (previousX + currentX) / 2f
                val conY = height - ((line[i - 1] - minY) * spacyY)

                cubicTo(
                    x1 = conX,
                    y1 = conY,
                    x2 = conX,
                    y2 = currentY,
                    x3 = currentX,
                    y3 = currentY
                )
            }

        }
    }
    return DrawElement(
        path = p,
        values = line,
        lineConfigs = DrawElement.LineConfigs(
            color = color,
            width = 2.dp
        )
    )
}

//fun createPathLine(
//    height: Float,
//    width: Float,
//    values: List<Float>,
//): List<DrawElement> {
//    val maxY = values.maxOfOrNull { it } ?: 0.0f
//    val minY = values.minOfOrNull { it } ?: 0.0f
//
//    val spaceX = width / ((values.maxOfOrNull { it } ?: 1f) - 1)
//    val spaceY = height / (maxY - minY)
//
//    return values.map { line ->
//        val path = Path()
//        var previousX = 0f
//        var previousY = 0f
//
//        for ((i, yValue) in values.withIndex()) {
//            val currentX = i * spaceX
//            val currentY = height - ((yValue - minY) * spaceY)
//
//            if (i == 0) {
//                path.moveTo(currentX, currentY)
//            } else {
//                val conX = (previousX + currentX) / 2f
//                val conY = (previousY + currentY) / 2f
//                path.cubicTo(
//                    x1 = conX,
//                    y1 = conY,
//                    x2 = conX,
//                    y2 = currentY,
//                    x3 = currentX,
//                    y3 = currentY
//                )
//            }
////            val offset = Offset(currentX, currentY)
////            line.offsets.add(offset)
////            onEach?.invoke(offset)
//
//            previousX = currentX
//            previousY = currentY
//        }
//
//        DrawElement(
//            path = path,
//            value = line,
//            lineConfigs = DrawElement.LineConfigs(
//                color = Color.Cyan,
//                width = 2.dp
//            )
//        )
//    }
//}