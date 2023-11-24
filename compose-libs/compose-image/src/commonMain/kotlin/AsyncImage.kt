import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.DefaultAlpha
import androidx.compose.ui.layout.ContentScale
import com.seiko.imageloader.model.ImageAction
import com.seiko.imageloader.rememberImageAction
import com.seiko.imageloader.rememberImageActionPainter

@Composable
public fun AsyncImage(
    url: String,
    modifier: Modifier = Modifier,
    alignment: Alignment = Alignment.Center,
    contentScale: ContentScale = ContentScale.Fit,
    alpha: Float = DefaultAlpha,
    colorFilter: ColorFilter? = null
) {
    val action =
        rememberImageAction("https://static.vecteezy.com/system/resources/previews/017/067/906/original/ufo-seamless-background-free-vector.jpg")

    val painter = rememberImageActionPainter(action.value)

    val shimmerVisibility = remember(key1 = action.value is ImageAction.Loading) {
        mutableStateOf(action.value is ImageAction.Loading)
    }

    Image(
        modifier = modifier.shimmerLoadingAnimation(shimmerVisibility.value),
        alignment = alignment,
        contentScale = contentScale,
        alpha = alpha,
        colorFilter = colorFilter,
        painter = painter,
        contentDescription = null
    )
}

private fun Modifier.shimmerLoadingAnimation(
    visible: Boolean,
    widthOfShadowBrush: Int = 500,
    angleOfAxisY: Float = 270f,
    durationMillis: Int = 1000
): Modifier {

    if (visible.not()) return this

    return composed {
        val c = Color(0xffa6a6a6)

        val shimmerColors = listOf(
            c.copy(alpha = 0.3f),
            c.copy(alpha = 0.5f),
            c.copy(alpha = 1.0f),
            c.copy(alpha = 0.5f),
            c.copy(alpha = 0.3f)
        )

        val transition = rememberInfiniteTransition(label = "")

        val translateAnimation = transition.animateFloat(
            initialValue = 0f,
            targetValue = (durationMillis + widthOfShadowBrush).toFloat(),
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = durationMillis,
                    easing = LinearEasing,
                ),
                repeatMode = RepeatMode.Restart,
            ),
            label = "Shimmer loading animation",
        )

        this.background(
            brush = Brush.linearGradient(
                colors = shimmerColors,
                start = Offset(x = translateAnimation.value - widthOfShadowBrush, y = 0.0f),
                end = Offset(x = translateAnimation.value, y = angleOfAxisY),
            )
        )
    }
}