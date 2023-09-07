package components.backgrounds

import NativeLocalResource
import VideoPlayer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
internal fun BackgroundVideoFrame(nativeResource: NativeLocalResource) {
    VideoPlayer(
        modifier = Modifier
            .fillMaxSize(),
        nativeLocalResource = nativeResource
    )
}