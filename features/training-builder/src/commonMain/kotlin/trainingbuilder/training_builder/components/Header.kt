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
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentHeight
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
import molecule.ButtonPrimary
import molecule.PaddingM
import molecule.PaddingWeight
import molecule.Shadow
import molecule.TextBody3
import molecule.TextH2
import percents
import resources.Icons
import trainingbuilder.training_builder.components.timer.TimerComponent

@Composable
internal fun Header(
    finish: () -> Unit,
    loading: Boolean,
    finishEnabled: Boolean,

    startDateMillis: Long,
    volume: Double,
    intensity: Double,
    fullFrontImage: ImageVector,
    fullBackImage: ImageVector,
    exerciseVolume: ImmutableList<Float>,
    exerciseIntensity: ImmutableList<Float>
) {
    Column(modifier = Modifier.statusBarsPadding()) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = Design.dp.paddingL,
                    end = Design.dp.paddingL
                )
                .height(Design.dp.componentS),
            verticalAlignment = Alignment.CenterVertically
        ) {

            TextH2(
                provideText = { "Training" },
                softWrap = false
            )

            PaddingWeight()

            ButtonPrimary(
                text = "Finish",
                onClick = finish,
                enabled = finishEnabled
            )
        }

        PaddingM()

        val expandedValue = remember { mutableStateOf(false) }

        val rotationState by animateFloatAsState(
            targetValue = if (expandedValue.value) 180f else 0f,
            label = "",
            animationSpec = tween(durationMillis = 200, easing = LinearEasing)
        )

        Column(
            modifier = Modifier.fillMaxWidth().animateContentSize()
        ) {

            Row(
                modifier = Modifier.fillMaxWidth().padding(horizontal = Design.dp.paddingM)
                    .height(intrinsicSize = IntrinsicSize.Min),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingM)
            ) {

                Column(
                    modifier = Modifier.weight(1f).fillMaxHeight(),
                    verticalArrangement = Arrangement.spacedBy(Design.dp.paddingS)
                ) {

                    OverviewValue(
                        modifier = Modifier.fillMaxWidth().wrapContentHeight(),
                        title = "Volume",
                        icon = Icons.handWeight,
                        color = Design.colors.yellow,
                        value = {
                            TextBody3(
                                provideText = { volume.kg(true) },
                                color = Design.colors.content,
                                maxLines = 1,
                            )
                        }
                    )

                    AnimatedVisibility(
                        modifier = Modifier.weight(1f),
                        visible = expandedValue.value,
                        enter = fadeIn(animationSpec = tween(durationMillis = 300)),
                        exit = fadeOut(animationSpec = tween(durationMillis = 300))
                    ) {
                        LineChart(
                            modifier = Modifier.fillMaxWidth().fillMaxHeight().border(
                                color = Design.palette.white10,
                                width = 1.dp,
                                shape = Design.shape.default
                            ).padding(
                                horizontal = Design.dp.paddingM, vertical = Design.dp.paddingM
                            ),
                            values = exerciseVolume,
                            bottomSpacing = 0f,
                            chartStyle = LineChartStyle(
                                lineColor = Design.colors.content, dotsStyle = LineChartDotsStyle(
                                    backgroundColor = Design.colors.yellow,
                                    width = 4.dp,
                                    type = LineChartDotsStyle.DotsType.START_END
                                )
                            )
                        )
                    }

                    AnimatedVisibility(
                        visible = expandedValue.value,
                        enter = fadeIn(animationSpec = tween(durationMillis = 300)),
                        exit = fadeOut(animationSpec = tween(durationMillis = 300))
                    ) {
                        OverviewValue(
                            modifier = Modifier.fillMaxWidth().wrapContentHeight()
                                .padding(top = Design.dp.paddingS),
                            title = "Intensity",
                            icon = Icons.equipment,
                            color = Design.colors.yellow,
                            value = {
                                TextBody3(
                                    provideText = { intensity.percents() },
                                    color = Design.colors.content,
                                    maxLines = 1,
                                )
                            }
                        )
                    }

                    AnimatedVisibility(
                        modifier = Modifier.weight(1f),
                        visible = expandedValue.value,
                        enter = fadeIn(animationSpec = tween(durationMillis = 300)),
                        exit = fadeOut(animationSpec = tween(durationMillis = 300))
                    ) {
                        LineChart(
                            modifier = Modifier.fillMaxWidth().fillMaxHeight().border(
                                color = Design.palette.white10,
                                width = 1.dp,
                                shape = Design.shape.default
                            ).padding(
                                horizontal = Design.dp.paddingM, vertical = Design.dp.paddingM
                            ),
                            bottomSpacing = 0f,
                            values = exerciseIntensity,
                            chartStyle = LineChartStyle(
                                lineColor = Design.colors.content, dotsStyle = LineChartDotsStyle(
                                    backgroundColor = Design.colors.yellow,
                                    width = 4.dp,
                                    type = LineChartDotsStyle.DotsType.START_END
                                )
                            )
                        )
                    }
                }

                Column(modifier = Modifier.weight(1.3f)) {

                    val duration =

                        Row(modifier = Modifier.fillMaxWidth()) {
                            OverviewValue(
                                modifier = Modifier.weight(1f).wrapContentHeight(),
                                title = "Duration",
                                icon = Icons.time,
                                color = Design.colors.yellow,
                                value = {
                                    TimerComponent(
                                        initialMillis = 123L,
                                        content = {
                                            TextBody3(
                                                provideText = { it },
                                                color = Design.colors.content,
                                                maxLines = 1,
                                            )
                                        })

                                }
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