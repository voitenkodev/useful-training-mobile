package atom

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin
import kotlin.random.Random

private data class Star(
    var x: Float,
    var y: Float,
    var alpha: Float,
    var velocity: Float
) {
    private val initialAlpha = alpha

    fun update(value: Float) {
        val x = (value - initialAlpha).toDouble()
        val newAlpha = 0.5f + (0.5f * sin(x).toFloat())
        alpha = newAlpha
    }
}

@Composable
internal fun SpaceBackground(modifier: Modifier = Modifier) {

    val infinitelyAnimatedFloat = rememberInfiniteTransition().animateFloat(
        initialValue = 0f,
        targetValue = 2f * PI.toFloat(),
        animationSpec = infiniteRepeatable(
            animation = tween(5000),
            repeatMode = RepeatMode.Restart
        )
    )

    BoxWithConstraints(modifier = modifier.fillMaxSize()) {

        val density = LocalDensity.current
        val width = with(density) { maxWidth.toPx() }
        val height = with(density) { maxHeight.toPx() }

        val stars = remember {
            buildList {
                repeat(500) {
                    val star = Star(
                        x = (Random.nextFloat() * width),
                        y = (Random.nextFloat() * height),
                        alpha = (Random.nextFloat() * 2.0 * PI).toFloat(),
                        velocity = (Random.nextFloat() * 2f + 1f)
                    )
                    add(star)
                }
            }
        }

        Canvas(modifier = Modifier.fillMaxSize()) {
            for (star in stars) {
                star.update(infinitelyAnimatedFloat.value)
                val deltaX = (star.alpha * cos(star.alpha))
                val deltaY = (star.alpha * sin(star.alpha))
                star.x += deltaX
                star.y += deltaY

                drawCircle(
                    color = Color.White.copy(alpha = 0.3f),
                    center = Offset(star.x, star.y),
                    radius = 2f,
                    alpha = star.alpha,
                )

                if (star.x < 0) {
                    star.x = width
                }
                if (star.x > width) {
                    star.x = 0f
                }
                if (star.y < 0) {
                    star.y = height
                }
                if (star.y > height) {
                    star.y = 0f
                }
            }
        }
    }
}