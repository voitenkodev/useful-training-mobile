package components.animation

import androidx.compose.animation.core.Easing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.drawscope.rotate

@Composable
public fun Modifier.rotatedBackgroundAnimation(
    colors: List<Color>,
    shape: Shape,
    animationDurationInMillis: Int = 1000,
    easing: Easing = LinearEasing
): Modifier {
    return composed {
        val brush = Brush.sweepGradient(colors)
        val infiniteTransition = rememberInfiniteTransition(label = "animatedBorder")
        val angle by infiniteTransition.animateFloat(
            initialValue = 0f,
            targetValue = 360f,
            animationSpec = infiniteRepeatable(
                animation = tween(durationMillis = animationDurationInMillis, easing = easing),
                repeatMode = RepeatMode.Restart
            ), label = "angleAnimation"
        )

        this.clip(shape)
            .drawBehind {
                rotate(angle) {
                    drawCircle(brush = brush, radius = size.width, blendMode = BlendMode.SrcIn)
                }
            }
    }
}