package components

import Design
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp

@Composable
fun BoxScope.SlowFloatingElement() {
    var isVisible by remember { mutableStateOf(true) }

    // Animation parameters
    val animationDuration = 3000 // Milliseconds
    val animationRange = 20.dp

    val offsetY = remember { Animatable(0f) }
    LaunchedEffect(isVisible) {
        if (isVisible) {
            offsetY.animateTo(
                targetValue = animationRange.value,
                animationSpec = infiniteRepeatable(
                    animation = tween(durationMillis = animationDuration, easing = LinearEasing),
                    repeatMode = RepeatMode.Reverse
                )
            )
        } else {
            offsetY.animateTo(0f, animationSpec = tween(durationMillis = 200))
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .offset(y = offsetY.value.dp)
            .align(Alignment.BottomCenter)
    ) {
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.Red)
                .clickable { isVisible = !isVisible }
        ) {
            // Your content for the floating element goes here
            // For example, you can add an image or some text
        }
    }
}

@Composable
fun BoxScope.BlueYellowOvalsScreenBackground() {

    val animationDuration = 2000
    val animationRange = 30.dp

    val offsetY = remember { Animatable(0f) }
    val offsetX = remember { Animatable(0f) }

    LaunchedEffect(Unit) {
        offsetY.animateTo(
            targetValue = animationRange.value,
            animationSpec = infiniteRepeatable(
                animation = tween(durationMillis = animationDuration, easing = LinearEasing),
                repeatMode = RepeatMode.Reverse
            )
        )
        offsetX.animateTo(
            targetValue = animationRange.value,
            animationSpec = infiniteRepeatable(
                animation = tween(durationMillis = animationDuration, easing = LinearEasing),
                repeatMode = RepeatMode.Reverse
            )
        )
    }

    BackgroundLight(
        color = Design.colors.accent_primary,
        modifier = Modifier
            .fillMaxHeight(0.5f)
            .fillMaxWidth()
            .offset(y = offsetY.value.dp)
            .offset(x = 150.dp)
            .align(Alignment.BottomCenter)
            .graphicsLayer {
                rotationZ = -45f
                scaleY = 1.7f
                scaleX = 1.7f

//                alpha = 0.5f
//                scaleX = 0.9f
//                rotationY = -30f
            }
    )

    BackgroundLight(
        color = Design.colors.accent_tertiary,
        modifier = Modifier
            .fillMaxHeight(0.5f)
            .fillMaxWidth()
            .offset(x = (-250).dp)
            .align(Alignment.BottomCenter)
            .graphicsLayer {
                rotationZ = 45f
                scaleY = 1.7f
                scaleX = 1.7f
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