package components.backgrounds

import Videos
import androidx.compose.runtime.Composable

@Composable
fun BackgroundIntroVideo() {
    BackgroundVideoFrame(nativeResource = Videos.intro)
}