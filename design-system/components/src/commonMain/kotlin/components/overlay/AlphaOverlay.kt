package components.overlay

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import atom.Design

@Composable
public fun AlphaOverlay(
    modifier: Modifier = Modifier,
    visibilityCondition: () -> Boolean = { true },
    initialAlpha: Float = 1f,
    targetAlpha: Float = 0f,
    animationDuration: Int = 1200,
    delayDuration: Int = 500
) {

    val animatedValue = remember { mutableStateOf(initialAlpha) }
    val animatedFloat by animateFloatAsState(
        targetValue = animatedValue.value,
        animationSpec = tween(
            durationMillis = animationDuration,
            delayMillis = delayDuration
        )
    )

    LaunchedEffect(visibilityCondition()) {
        if (visibilityCondition()) animatedValue.value = targetAlpha
    }

    Spacer(
        modifier = modifier
            .graphicsLayer(alpha = animatedFloat)
            .background(color = Design.colors.primary)
    )
}