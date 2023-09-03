package components

import NativeLocalResource
import VideoPlayer
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import controls.primaryBackground
import controls.primaryFrame
import kotlinx.coroutines.delay

// TODO Probably move it do design-system
@Composable
internal fun BackgroundVideo(
    nativeResource: NativeLocalResource,
    durationInMs: Long
) {
    val animatedValue = remember { mutableStateOf(1f) }

    val animatedFloat by animateFloatAsState(
        targetValue = animatedValue.value,
        animationSpec = tween(durationMillis = 1700)
    )

    LaunchedEffect(Unit) {
        delay(500)
        animatedValue.value = 0.7f
        delay(durationInMs) // Finish of video (hack until fix iOS get duration of video from Player)
        animatedValue.value = 1.0f
    }

    VideoPlayer(
        modifier = Modifier
            .fillMaxSize(),
        nativeLocalResource = nativeResource
    )

    Spacer(
        Modifier
            .fillMaxSize()
            .primaryFrame()
    )

    Spacer(
        Modifier
            .fillMaxSize()
            .alpha(animatedFloat)
            .primaryBackground()
    )
}