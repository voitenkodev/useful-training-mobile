package components.overlay

import Design
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

@Composable
fun Modifier.shadowBottomFrame(
    gradientColors: List<Color> = listOf(Color.Transparent, Design.colors.primary)
) = this.drawWithContent {

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
    gradientColors: List<Color> = listOf(Design.colors.primary, Color.Transparent)
) = this.drawWithContent {

    val startY = 0f
    val endY = this.size.height / 2

    val brush = Brush.verticalGradient(
        colors = gradientColors,
        startY = startY,
        endY = endY
    )

    drawRect(brush = brush)
}