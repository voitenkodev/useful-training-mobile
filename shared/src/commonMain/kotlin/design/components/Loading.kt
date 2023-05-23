package design.components

import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import design.Design
import utils.recomposeHighlighter

@Composable
internal fun Loading(visible: Boolean) {

    if (!visible) return

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black.copy(alpha = 0.5f))
            .clickable(enabled = false) {}
            .recomposeHighlighter(),
        contentAlignment = Alignment.Center,
        content = {
            Box(
                Modifier
                    .background(
                        color = Design.colors.content,
                        shape = RoundedCornerShape(20.dp)
                    )
                    .padding(20.dp)
                    .recomposeHighlighter()
            ) {
                ProgressIndicatorLoading()
            }
        }
    )
}

@Composable
fun ProgressIndicatorLoading() {

    val infiniteTransition = rememberInfiniteTransition()

    val angle by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 600
            }
        )
    )

    CircularProgressIndicator(
        progress = 1f,
        modifier = Modifier
            .size(60.dp)
            .rotate(angle)
            .border(
                12.dp,
                brush = Brush.sweepGradient(
                    listOf(
                        Design.colors.content,
                        Design.colors.accent_primary.copy(alpha = 0.5f),
                        Design.colors.accent_primary
                    )
                ),
                shape = CircleShape
            ),
        strokeWidth = 1.dp,
        color = Design.colors.content
    )
}