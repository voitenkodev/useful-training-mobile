package trainingbuilder.training_builder.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.ui.unit.dp
import atom.Design
import basic.LineChart
import basic.LineChartDotsStyle
import basic.LineChartStyle
import kg
import kotlinx.collections.immutable.ImmutableList
import molecule.ButtonIconTransparent
import molecule.ButtonPrimarySmall
import molecule.PaddingM
import molecule.PaddingS
import molecule.Shadow
import molecule.TextH2
import percents
import resources.Icons

@Composable
internal fun Header(
    finish: () -> Unit,
    loading: Boolean,
    finishEnabled: Boolean,

    volume: Double,
    reps: Int,
    intensity: Double,
    fullFrontImage: ImageVector,
    fullBackImage: ImageVector,
    exerciseVolume: ImmutableList<Float>
) {
    Column(modifier = Modifier.statusBarsPadding()) {

        PaddingS()

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(Design.dp.componentM),
        ) {

            TextH2(
                modifier = Modifier.align(Alignment.Center),
                provideText = { "Training" },
                softWrap = false
            )

            ButtonPrimarySmall(
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .padding(horizontal = Design.dp.paddingM),
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
                    .padding(horizontal = Design.dp.paddingM)
                    .height(intrinsicSize = IntrinsicSize.Min),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingM)
            ) {

                Column(
                    modifier = Modifier.weight(1f).fillMaxHeight(),
                    verticalArrangement = Arrangement.spacedBy(Design.dp.paddingM)
                ) {
                    OverviewValue(
                        title = "Duration",
                        description = "123",
                        icon = Icons.time,
                        color = Design.colors.yellow
                    )

                    AnimatedVisibility(
                        visible = expandedValue.value,
                        enter = fadeIn(animationSpec = tween(durationMillis = 300)),
                        exit = fadeOut(animationSpec = tween(durationMillis = 300))
                    ) {
                        OverviewValue(
                            modifier = Modifier.fillMaxWidth(),
                            title = "Reps",
                            description = reps.toString(),
                            icon = Icons.exercises,
                            color = Design.colors.yellow
                        )
                    }

                    AnimatedVisibility(
                        visible = expandedValue.value,
                        enter = fadeIn(animationSpec = tween(durationMillis = 300)),
                        exit = fadeOut(animationSpec = tween(durationMillis = 300))
                    ) {
                        OverviewValue(
                            modifier = Modifier.fillMaxWidth(),
                            title = "Intensity",
                            description = intensity.percents(),
                            icon = Icons.equipment,
                            color = Design.colors.yellow
                        )
                    }

                    AnimatedVisibility(
                        visible = expandedValue.value,
                        enter = fadeIn(animationSpec = tween(durationMillis = 300)),
                        exit = fadeOut(animationSpec = tween(durationMillis = 300))
                    ) {
                        LineChart(
                            modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight()
                                .border(
                                    color = Design.palette.white10,
                                    width = 1.dp,
                                    shape = Design.shape.default
                                ).padding(
                                    horizontal = Design.dp.paddingM,
                                    vertical = Design.dp.paddingS
                                ),
                            values = exerciseVolume,
                            chartStyle = LineChartStyle(
                                lineColor = Design.colors.content,
                                dotsStyle = LineChartDotsStyle(
                                    backgroundColor = Design.colors.orange,
                                    width = 4.dp,
                                    type = LineChartDotsStyle.DotsType.START_END
                                )
                            )
                        )
                    }
                }

                Column(modifier = Modifier.weight(1f)) {
                    Row {
                        OverviewValue(
                            modifier = Modifier.weight(1f),
                            title = "Volume",
                            description = volume.kg(false),
                            icon = Icons.handWeight,
                            color = Design.colors.yellow
                        )

                        ButtonIconTransparent(
                            modifier = Modifier.rotate(rotationState),
                            imageVector = Icons.arrowDown,
                            onClick = { expandedValue.value = expandedValue.value.not() },
                        )
                    }

                    AnimatedVisibility(
                        visible = expandedValue.value,
                        enter = fadeIn(animationSpec = tween(durationMillis = 300)),
                        exit = fadeOut(animationSpec = tween(durationMillis = 300))
                    ) {
                        HeapMap(
                            modifier = Modifier.weight(1f)
                                .padding(top = Design.dp.paddingM, end = Design.dp.paddingS),
                            fullFrontImage = fullFrontImage,
                            fullBackImage = fullBackImage
                        )
                    }
                }
            }

            PaddingM()

            Shadow()
        }
    }
}