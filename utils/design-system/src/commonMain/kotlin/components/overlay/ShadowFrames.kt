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

    val startY = this.size.height / 2
    val endY = this.size.height

    val brush = Brush.verticalGradient(
        colors = gradientColors,
        startY = startY,
        endY = endY
    )

    drawRect(brush = brush)
}

@Composable
fun Modifier.shadowTopFrame(
    color: Color = Design.colors.primary
) = this.drawWithContent {
    val gradientColors = listOf(color, Color.Transparent)

    val startY = 0f
    val endY = this.size.height / 2

    val brush = Brush.verticalGradient(
        colors = gradientColors,
        startY = startY,
        endY = endY
    )

    drawRect(brush = brush)
}