package trainingbuilder.training_builder.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.vector.ImageVector
import atom.Design
import kg
import molecule.ButtonIconTransparent
import molecule.ButtonPrimarySmall
import molecule.PaddingS
import molecule.PaddingWeight
import molecule.Shadow
import molecule.TextH2
import resources.Icons

@Composable
internal fun Header(
    finish: () -> Unit,
    loading: Boolean,
    finishEnabled: Boolean,

    volume: Double,
    fullFrontImage: ImageVector,
    fullBackImage: ImageVector
) {
    Column(modifier = Modifier.statusBarsPadding()) {

        PaddingS()

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(Design.dp.componentM),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            TextH2(
                modifier = Modifier.padding(horizontal = Design.dp.paddingM),
                provideText = { "Training" },
                softWrap = false
            )

            PaddingWeight()

            ButtonPrimarySmall(
                modifier = Modifier.padding(horizontal = Design.dp.paddingM),
                text = "Finish",
                onClick = finish,
                loading = loading,
                enabled = finishEnabled
            )
        }

        PaddingS()

        val expandedValue = remember { mutableStateOf(false) }

        val rotationState by animateFloatAsState(
            targetValue = if (expandedValue.value) 180f else 0f,
            label = "",
            animationSpec = tween(durationMillis = 200, easing = LinearEasing)
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .animateContentSize()
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(Design.dp.paddingS),
                verticalAlignment = Alignment.CenterVertically
            ) {

                OverviewValue(
                    modifier = Modifier.weight(1f),
                    title = "Duration",
                    description = "123",
                    icon = Icons.time,
                    color = Design.colors.yellow
                )

                OverviewValue(
                    modifier = Modifier.weight(1f),
                    title = "Volume",
                    description = volume.kg(false),
                    icon = Icons.weight,
                    color = Design.colors.yellow
                )

                ButtonIconTransparent(
                    modifier = Modifier.rotate(rotationState),
                    imageVector = Icons.arrowDown,
                    onClick = { expandedValue.value = expandedValue.value.not() },
                )

                PaddingS()
            }

            AnimatedVisibility(
                visible = expandedValue.value,
                enter = fadeIn(animationSpec = tween(durationMillis = 300)),
                exit = fadeOut(animationSpec = tween(durationMillis = 300))
            ) {
                Row {
                    HeapMap(
                        modifier = Modifier.weight(2f),
                        fullFrontImage = fullFrontImage,
                        fullBackImage = fullBackImage
                    )

                    Spacer(Modifier.weight(1f))
                }
            }
        }

        PaddingS()

        Shadow()
    }
}