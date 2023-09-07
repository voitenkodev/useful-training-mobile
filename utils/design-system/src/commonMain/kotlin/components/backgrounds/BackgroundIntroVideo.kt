package components.backgrounds

import Videos
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun BackgroundIntroVideo(
    modifier: Modifier = Modifier
) {
    BackgroundVideoFrame(
        modifier = modifier,
        nativeResource = Videos.intro
    )
}