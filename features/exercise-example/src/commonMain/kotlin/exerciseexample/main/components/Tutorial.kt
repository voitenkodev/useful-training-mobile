package exerciseexample.main.components

import VideoPlayer
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import atom.Design
import molecule.Icon
import molecule.TextLabel
import molecule.secondaryDefaultBackground
import resources.Icons

@Composable
internal fun Tutorial(
    url: String,
    onClick: () -> Unit
) {
    val loadingState = remember { mutableStateOf(true) }

    Column(
        modifier = Modifier.padding(horizontal = Design.dp.paddingM),
        verticalArrangement = Arrangement.spacedBy(Design.dp.paddingS)
    ) {

        TextLabel(provideText = { "Video tutorial" })

        Box {
            VideoPlayer(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(2f)
                    .secondaryDefaultBackground(),
                url = url,
                onStart = { loadingState.value = false }
            )

            if (loadingState.value) {

                val infiniteTransition = rememberInfiniteTransition()

                val rotation by infiniteTransition.animateFloat(
                    initialValue = 0f,
                    targetValue = 360f,
                    animationSpec = infiniteRepeatable(
                        animation = tween(2000),
                        repeatMode = RepeatMode.Restart
                    )
                )

                Icon(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .size(Design.dp.componentM)
                        .padding(Design.dp.paddingXS)
                        .background(color = Design.colors.content, shape = Design.shape.circleShape)
                        .graphicsLayer(rotationZ = rotation),
                    imageVector = Icons.loading,
                    color = Design.colors.primary
                )
            }
        }
    }
}