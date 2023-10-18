package components.backgrounds

import Design
import NativeLocalResource
import VideoPlayer
import Videos
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha

@Composable
fun BackgroundIntro(
    modifier: Modifier = Modifier
) {
    BackgroundVideoFrame(
        modifier = modifier,
        nativeResource = Videos.intro
    )
}

@Composable
private fun BackgroundVideoFrame(
    modifier: Modifier,
    nativeResource: NativeLocalResource
) {

    Box(modifier = modifier) {
        VideoPlayer(
            modifier = Modifier
                .fillMaxSize(),
            nativeLocalResource = nativeResource
        )
    }

    Spacer(
        modifier = Modifier
            .fillMaxSize()
            .alpha(0.3f)
            .background(color = Design.colors.primary)
    )
}