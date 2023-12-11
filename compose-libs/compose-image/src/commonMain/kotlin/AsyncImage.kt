import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.DefaultAlpha
import androidx.compose.ui.layout.ContentScale
import com.seiko.imageloader.model.ImageAction
import com.seiko.imageloader.rememberImageAction
import com.seiko.imageloader.rememberImageActionPainter

@Composable
public fun AsyncImage(
    url: String?,
    modifier: Modifier = Modifier,
    alignment: Alignment = Alignment.Center,
    contentScale: ContentScale = ContentScale.Fit,
    alpha: Float = DefaultAlpha,
    colorFilter: ColorFilter? = null
) {
    val action = rememberImageAction(url ?: "")

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