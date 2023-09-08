package components.states

import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.ime
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.platform.LocalDensity

@Composable
fun keyboardFloatAsState(
    initialValue: Float = 1f,
    targetValue: Float = 0.5f,
    durationInMs: Int = 400
): State<Float> {

    // Threshold on change between two input fields (doesn't have sense, waiting for JC fix)
    val threshold = 0
    val isImeVisible = WindowInsets.ime.getBottom(LocalDensity.current) > 0
    val value = if (isImeVisible) targetValue else initialValue

    return animateFloatAsState(
        targetValue = value,
        animationSpec = tween(
            delayMillis = if (isImeVisible.not()) threshold else 0,
            durationMillis = durationInMs,
            easing = LinearOutSlowInEasing
        )
    )
}