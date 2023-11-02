package components.overlay

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import atom.Design

@Composable
public fun Modifier.shadowBottomFrame(
    gradientColors: List<Color> = listOf(
        Color.Transparent,
        Design.colors.primary
    )
): Modifier = this.drawWithContent {

    val brush = Brush.verticalGradient(
        colors = gradientColors,
    )

    drawRect(brush = brush)
}