package platform

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
actual fun RemoteImage(imageUrl: String, modifier: Modifier, contentDescription: String?) {
    val model = ImageRequest.Builder(LocalContext.current)
        .data(imageUrl)
        .placeholder(0)
        .build()

    AsyncImage(
        modifier = modifier,
        model = model,
        contentDescription = contentDescription,
        contentScale = ContentScale.Crop,
    )
}
