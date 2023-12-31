import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.DefaultAlpha
import androidx.compose.ui.layout.ContentScale
import coil3.compose.AsyncImage
import coil3.compose.AsyncImagePainter
import coil3.compose.LocalPlatformContext
import coil3.request.ImageRequest

@Composable
public fun AsyncImage(
    url: String?,
    modifier: Modifier = Modifier,
    alignment: Alignment = Alignment.Center,
    contentScale: ContentScale = ContentScale.Fit,
    alpha: Float = DefaultAlpha,
    colorFilter: ColorFilter? = null
) {
    val shimmerVisibility = remember { mutableStateOf(false) }

    AsyncImage(
        modifier = modifier.shimmerLoadingAnimation(shimmerVisibility.value),
        model = ImageRequest.Builder(LocalPlatformContext.current)
            .data(url)
            .build(),
        contentDescription = null,
        alignment = alignment,
        onState = { shimmerVisibility.value = it is AsyncImagePainter.State.Loading },
        contentScale = contentScale,
        alpha = alpha,
        colorFilter = colorFilter
    )
}