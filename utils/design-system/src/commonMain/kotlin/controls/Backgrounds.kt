package controls

import Design
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun BoxScope.BottomScreenGradient(height: Dp = 173.dp) {
    val color = Color.Black
    Box(
        modifier = Modifier
            .align(Alignment.BottomCenter)
            .fillMaxWidth()
            .height(height)
            .background(
                brush = Brush.verticalGradient(
                    0.03f to color.copy(alpha = 0f),
                    0.164f to color.copy(alpha = 0.4f),
                    0.203f to color.copy(alpha = 0.5f),
                    0.385f to color.copy(alpha = 0.73f),
                    1f to color.copy(alpha = 1f),
                )
            )
    )
}

@Composable
fun BoxScope.TopScreenGradient(height: Dp = 176.dp) {
    val color = Color(14, 14, 27)
    Box(
        modifier = Modifier
            .align(Alignment.TopCenter)
            .fillMaxWidth()
            .height(height)
            .background(
                brush = Brush.verticalGradient(
                    0.126f to color.copy(alpha = 1f),
                    0.307f to color.copy(alpha = 0.8f),
                    0.458f to color.copy(alpha = 0.7f),
                    0.573f to color.copy(alpha = 0.52f),
                    0.715f to color.copy(alpha = 0.2f),
                    0.767f to color.copy(alpha = 0.18f),
                    0.824f to color.copy(alpha = 0.16f),
                    0.879f to color.copy(alpha = 0.09f),
                    0.966f to color.copy(alpha = 0f),
                )
            )
    )
}

@Composable
fun Modifier.primaryFrame(
    height: Dp = 176.dp,
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

@Composable
fun Modifier.primaryBackground() = this
    .background(
        color = Design.colors.primary
    )

@Composable
fun Modifier.secondaryBackground() = this
    .background(
        color = Design.colors.secondary,
        shape = Design.shape.default
    ).clip(
        shape = Design.shape.default
    )

@Composable
fun Modifier.tertiaryBackground() = this
    .background(
        color = Design.colors.tertiary,
        shape = Design.shape.default
    ).clip(
        shape = Design.shape.default
    )

@Composable
fun Modifier.reversedBackground() = this
    .background(
        color = Design.colors.content,
        shape = Design.shape.default
    ).clip(
        shape = Design.shape.default
    )