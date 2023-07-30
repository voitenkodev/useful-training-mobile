package components

import Design
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp

@Composable
fun BoxScope.BlueYellowOvalsScreenBackground() {

    BackgroundLight(
        color = Design.colors.accent_secondary,
        modifier = Modifier
            .size(500.dp)
            .offset(
                x = (-340).dp,
                y = (-250).dp
            )
            .align(Alignment.TopCenter)
            .graphicsLayer {
                alpha = 0.5f
                scaleY = 1.7f
                scaleX = 1.7f
            }
    )

    BackgroundLight(
        color = Design.colors.accent_primary,
        modifier = Modifier
            .size(500.dp)
            .offset(
                x = 280.dp,
                y = 100.dp
            )
            .align(Alignment.CenterEnd)
            .graphicsLayer {
                alpha = 0.5f
                scaleY = 1.7f
                scaleX = 1.7f
            }
    )

    BackgroundLight(
        color = Design.colors.accent_tertiary,
        modifier = Modifier
            .fillMaxSize(0.2f)
            .align(Alignment.BottomStart)
            .graphicsLayer {
                alpha = 0.5f
                scaleY = 8.0f
                scaleX = 8.0f
            }
    )
}

@Composable
fun BackgroundLight(color: Color, modifier: Modifier) {
    val brush = Brush.radialGradient(
        0.01f to color.copy(alpha = 0.9f),
        0.09f to color.copy(alpha = 0.87f),
        0.17f to color.copy(alpha = 0.82f),
        0.24f to color.copy(alpha = 0.76f),
        0.31f to color.copy(alpha = 0.68f),
        0.38f to color.copy(alpha = 0.59f),
        0.45f to color.copy(alpha = 0.51f),
        0.52f to color.copy(alpha = 0.44f),
        0.60f to color.copy(alpha = 0.36f),
        0.68f to color.copy(alpha = 0.29f),
        0.76f to color.copy(alpha = 0.22f),
        0.84f to color.copy(alpha = 0.15f),
        0.92f to color.copy(alpha = 0.08f),
        0.99f to color.copy(alpha = 0f),
    )
    Box(modifier = modifier.background(brush = brush))
}