package components.overlay

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.graphicsLayer

@Composable
fun Modifier.alphaOverlay(
    durationMillis: Int,
    delayMillis: Int,
): Modifier = composed {
    val animatedValue = remember { mutableStateOf(0f) }

    val animatedFloat by animateFloatAsState(
        targetValue = animatedValue.value,
        animationSpec = tween(durationMillis, delayMillis)
    )

    LaunchedEffect(Unit) {
        animatedValue.value = 1f
    }

    this.then(
        Modifier.graphicsLayer(alpha = animatedFloat)
    )
}