package components.overlay

import Design
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun Modifier.shadowFrame(
    height: Dp = 76.dp,
    color: Color = Design.colors.primary
) = this.drawWithContent {
    val gradientColors = listOf(color, Color.Transparent)

    val topStartY = 0f
    val topEndY = height.toPx()

    val bottomStartY = this.size.height - height.toPx()
    val bottomTopEndY = this.size.height

    val topBrush = Brush.verticalGradient(
        colors = gradientColors,
        startY = topStartY,
        endY = topEndY
    )

    val bottomBrush = Brush.verticalGradient(
        colors = gradientColors.asReversed(),
        startY = bottomStartY,
        endY = bottomTopEndY
    )

    drawRect(brush = topBrush)

    drawRect(brush = bottomBrush)
}