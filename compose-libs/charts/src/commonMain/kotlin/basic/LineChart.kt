package basic

import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.text.style.TextOverflow
import atom.Design
import kg
import round
import kotlin.math.sqrt

@Composable
public fun LineChart(
    modifier: Modifier = Modifier,
    values: List<Float>,
    chartStyle: LineChartStyle,
    bottomSpacing: Float = 40F
) {

    val textMeasurer = rememberTextMeasurer()
    val style = Design.typography.Body4.copy(
        color = chartStyle.labelStyle?.textColor ?: Design.colors.content,
        fontWeight = FontWeight.Bold
    )

    val spaceDimensions = remember {
        textMeasurer.measure(
            text = "Test",
            style = style,
            maxLines = 1,
            softWrap = false,
            overflow = TextOverflow.Visible
        )
    }

    Canvas(modifier = modifier) {

        if (values.isEmpty()) {

            val canvasWidth = size.width
            val canvasHeight = size.height
            val stroke = 4f
            val circleRadius = size.minDimension / 4
            val circleCenter = Offset(canvasWidth / 2f, canvasHeight / 2f)

            drawCircle(
                color = Color.Gray,
                radius = circleRadius,
                center = circleCenter,
                style = Stroke(width = stroke)
            )

            val diagonalLength = circleRadius / sqrt(2.0).toFloat()

            val startOffset = Offset(
                circleCenter.x - diagonalLength,
                circleCenter.y - diagonalLength
            )

            val endOffset = Offset(
                circleCenter.x + diagonalLength,
                circleCenter.y + diagonalLength
            )

            drawLine(
                color = Color.Gray,
                start = startOffset,
                end = endOffset,
                strokeWidth = stroke
            )

            return@Canvas
        }


        val labelTopSpace = chartStyle.labelStyle?.let {
            spaceDimensions.size.height + chartStyle.labelStyle.spaceTillLine.toPx()
        } ?: 0f

        val drawElement = generatePath(
            width = size.width,
            height = size.height,
            line = values,
            bottomSpacing = bottomSpacing,
            topSpacing = labelTopSpace
        )

        // Line
        drawPath(
            path = drawElement.path,
            color = chartStyle.lineColor,
            style = Stroke(width = chartStyle.lineWidth.toPx(), cap = StrokeCap.Round)
        )

        // Background
        val bgStyle = chartStyle.backgroundStyle
        if (bgStyle != null) {
            drawPath(
                path = drawElement.path.apply {
                    lineTo(size.width, size.height); lineTo(
                    0f,
                    size.height
                )
                },
                brush = Brush.verticalGradient(
                    0.0f to bgStyle.backgroundColor.copy(alpha = 0.6f),
                    0.9f to bgStyle.backgroundColor.copy(alpha = 0.0f)
                )
            )
        }

        // Dots
        val dotsStyle = chartStyle.dotsStyle
        if (dotsStyle != null) {
            val dotsList = when (dotsStyle.type) {
                LineChartDotsStyle.DotsType.ALL -> drawElement.listOfPoints
                LineChartDotsStyle.DotsType.START_END -> if (drawElement.listOfPoints.size >= 2) listOfNotNull(
                    drawElement.listOfPoints.firstOrNull(),
                    drawElement.listOfPoints.lastOrNull(),
                ) else emptyList()
            }

            dotsList.forEach points@{ point ->
                drawCircle(
                    color = dotsStyle.backgroundColor,
                    radius = dotsStyle.width.toPx(),
                    center = Offset(point.x, point.y)
                )
            }

        }

        // Labels
        val labelsStyle = chartStyle.labelStyle

        if (labelsStyle != null) {
            drawElement.listOfPoints.forEachIndexed { index, point ->

                val text = drawElement
                    .values
                    .getOrNull(index)
                    ?.toDouble()
                    ?.round(1)
                    ?.kg(true) ?: return@forEachIndexed

                val padding = labelsStyle.paddings.toPx()

                val spaceTillLine = labelsStyle.spaceTillLine.toPx()

                val dimensions = textMeasurer.measure(
                    text = text,
                    style = style,
                    maxLines = 1,
                    softWrap = false,
                    overflow = TextOverflow.Visible
                )

                val startPoint = when (index) {
                    0 -> point.x + padding
                    drawElement.listOfPoints.lastIndex -> point.x - dimensions.size.width - padding
                    else -> point.x - (dimensions.size.width / 2)
                }

                // Label background
                drawRoundRect(
                    color = labelsStyle.backgroundColor,
                    topLeft = Offset(
                        startPoint - (padding * 2),
                        point.y - (dimensions.size.height / 2) - padding - spaceTillLine
                    ),
                    size = Size(
                        dimensions.size.width.toFloat() + (padding * 4),
                        dimensions.size.height.toFloat() + (padding * 2),
                    ),
                    cornerRadius = CornerRadius(
                        x = dimensions.size.height.toFloat() + (padding * 2) / 2,
                        y = dimensions.size.height.toFloat() + (padding * 2) / 2
                    )
                )

                // Label border
                drawRoundRect(
                    color = labelsStyle.borderColor,
                    topLeft = Offset(
                        startPoint - (padding * 2),
                        point.y - (dimensions.size.height / 2) - padding - spaceTillLine
                    ),
                    size = Size(
                        dimensions.size.width.toFloat() + (padding * 4),
                        dimensions.size.height.toFloat() + (padding * 2),
                    ),
                    cornerRadius = CornerRadius(
                        x = dimensions.size.height.toFloat() + (padding * 2) / 2,
                        y = dimensions.size.height.toFloat() + (padding * 2) / 2
                    ),
                    style = Stroke(
                        width = labelsStyle.borderWidth.toPx()
                    )
                )

                // Label text
                drawText(
                    textLayoutResult = dimensions,
                    topLeft = Offset(
                        x = startPoint,
                        y = point.y - (dimensions.size.height / 2) - spaceTillLine
                    )
                )
            }
        }
    }
}
