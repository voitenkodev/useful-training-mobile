package components.brand

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.CubicBezierEasing
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlin.random.Random

private enum class AlienAnimationState { INITIAL, STARTED, FINISHED }

@Composable
public fun Alien() {
    val animController = remember { mutableStateOf(AlienAnimationState.INITIAL) }
    val customEasing = CubicBezierEasing(0.30f, 1f, 0.72f, 1f)

    val levitationX = remember { Animatable(0f) }
    val levitationY = remember { Animatable(0f) }
    val rotation = remember { Animatable(0f) }
    val appear = remember { Animatable(-500f) }

    val boundBell by rememberInfiniteTransition().animateFloat(
        initialValue = 4f,
        targetValue = -4f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 2000, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        )
    )

    LaunchedEffect(Unit) {
        animController.value = AlienAnimationState.STARTED
        delay(1300)
        appear.animateTo(
            targetValue = 0f,
            animationSpec = tween(durationMillis = 2500, easing = customEasing)
        )
        animController.value = AlienAnimationState.FINISHED
    }

    LaunchedEffect(animController.value) {
        while (true) {
            val randomX = Random.nextInt(-5, 5)
            levitationX.animateTo(
                targetValue = randomX.toFloat(),
                animationSpec = tween(
                    durationMillis = Random.nextInt(2300, 4400),
                    easing = FastOutSlowInEasing
                )
            )
        }
    }

    LaunchedEffect(animController.value) {
        while (true) {
            val randomY = Random.nextInt(-5, 5)
            levitationY.animateTo(
                targetValue = randomY.toFloat(),
                animationSpec = tween(
                    durationMillis = Random.nextInt(2300, 4400),
                    easing = FastOutSlowInEasing
                )
            )
        }
    }

    LaunchedEffect(animController.value) {
        while (true) {
            val randomRotation = Random.nextInt(-5, 5).toFloat()
            rotation.animateTo(
                targetValue = randomRotation,
                animationSpec = tween(
                    durationMillis = Random.nextInt(2300, 4400),
                    easing = FastOutSlowInEasing
                )
            )
        }
    }

    Image(
        modifier = Modifier
            .size(90.dp)
            .graphicsLayer(
                transformOrigin = TransformOrigin(
                    pivotFractionX = 0.5f,
                    pivotFractionY = 0.0f,
                ),
                rotationZ = boundBell
            ).offset(x = appear.value.dp, y = 0.dp)
            .offset(x = levitationX.value.dp, y = levitationY.value.dp)
            .rotate(rotation.value),
        imageVector = icons.Alien,
        contentDescription = null
    )
}