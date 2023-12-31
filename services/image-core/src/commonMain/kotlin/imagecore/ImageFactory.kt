package imagecore

import androidx.compose.runtime.Composable
import coil3.ImageLoader
import coil3.annotation.ExperimentalCoilApi
import coil3.compose.setSingletonImageLoaderFactory

@OptIn(ExperimentalCoilApi::class)
@Composable
public fun ImageFactory() {
    setSingletonImageLoaderFactory { context ->
        ImageLoader.Builder(context)
            .components { add(coil3.fetch.NetworkFetcher.Factory()) }
            .build()
    }
}