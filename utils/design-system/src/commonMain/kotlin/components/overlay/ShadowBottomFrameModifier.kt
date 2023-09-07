package components.overlay

import Design
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

@Composable
fun Modifier.shadowBottomFrame(
    color: Color = Design.colors.primary
) = this.drawWithContent {
    val gradientColors = listOf(Color.Transparent, color)

    val bottomStartY = this.size.height / 2
    val bottomTopEndY = this.size.height

    val bottomBrush = Brush.verticalGradient(
        colors = gradientColors,
        startY = bottomStartY,
        endY = bottomTopEndY
    )

    drawRect(brush = bottomBrush)
}