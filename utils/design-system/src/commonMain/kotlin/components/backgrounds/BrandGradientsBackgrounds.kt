package components.backgrounds

import Design
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
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
fun BoxScope.BrandGradientCenterStart(
    color: Color = Design.colors.accent_primary,
) {

    val colorAnimation = animateColorAsState(
        color,
        animationSpec = tween(800)
    )

    BackgroundLight(
        color = colorAnimation.value,
        modifier = Modifier
            .align(Alignment.CenterEnd)
            .size(500.dp)
            .offset(
                x = -(220.dp),
                y = 180.dp
            ).graphicsLayer {
                alpha = 0.3f
                scaleX = 0.9f
                rotationY = -210f
                rotationX = -0f
            }
    )
}

@Composable
fun BoxScope.BrandGradientCenterEnd(
    color: Color = Design.colors.accent_primary,
) {

    val colorAnimation = animateColorAsState(
        color,
        animationSpec = tween(800)
    )

    BackgroundLight(
        color = colorAnimation.value,
        modifier = Modifier
            .align(Alignment.CenterEnd)
            .size(500.dp)
            .offset(
                x = 220.dp,
            ).graphicsLayer {
                alpha = 0.3f
                scaleX = 0.9f
                rotationY = +30f
                rotationX = -0f
            }
    )
}

@Composable
fun BoxScope.BrandGradientBottomEnd() {
    BackgroundLight(
        color = Design.colors.accent_primary,
        modifier = Modifier
            .align(Alignment.BottomEnd)
            .size(500.dp)
            .offset(
                x = 180.dp,
                y = 180.dp
            ).graphicsLayer {
                alpha = 0.5f
                scaleX = 0.9f
                rotationY = +30f
                rotationX = -30f
            }
    )
}

@Composable
private fun BackgroundLight(color: Color, modifier: Modifier) {
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
