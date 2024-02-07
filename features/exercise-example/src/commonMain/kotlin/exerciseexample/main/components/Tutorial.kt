package exerciseexample.main.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import atom.Design
import components.cards.HorizontalValueCard
import molecule.PaddingS
import molecule.TextLabel
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

        TextLabel(provideText = { "Tutorial" })

        PaddingS()

        HorizontalValueCard(
            title = "[En] Instructuin",
            description = "By \"Muscle & Strength\"",
            startIcon = Icons.youtube to Color(0xffff0100),
            endIcon = Icons.arrowRight to Design.colors.content,
            onClick = onClick
        )

//        Box {
//            VideoPlayer(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .aspectRatio(2f)
//                    .secondaryDefaultBackground(),
//                url = url,
//                onStart = { loadingState.value = false }
//            )
//
//            if (loadingState.value) {
//
//                val infiniteTransition = rememberInfiniteTransition()
//
//                val rotation by infiniteTransition.animateFloat(
//                    initialValue = 0f,
//                    targetValue = 360f,
//                    animationSpec = infiniteRepeatable(
//                        animation = tween(2000),
//                        repeatMode = RepeatMode.Restart
//                    )
//                )
//
//                Icon(
//                    modifier = Modifier
//                        .align(Alignment.Center)
//                        .size(Design.dp.componentM)
//                        .padding(Design.dp.paddingXS)
//                        .background(color = Design.colors.content, shape = Design.shape.circleShape)
//                        .graphicsLayer(rotationZ = rotation),
//                    imageVector = Icons.loading,
//                    color = Design.colors.primary
//                )
//            }
//        }
    }
}