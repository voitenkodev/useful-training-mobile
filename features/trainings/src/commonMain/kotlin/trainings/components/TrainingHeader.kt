package trainings.components

import Design
import Time
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import atomic.icons.HandWeight
import atomic.icons.Weight
import basic.BasicLineChart
import kotlinx.collections.immutable.ImmutableList
import molecular.ButtonIconSecondary
import molecular.TextBody2
import molecular.TextH4
import molecular.accentDefaultBackground
import molecular.secondaryDefaultBackground
import recomposeHighlighter
import trainings.state.Training

@Composable
internal fun TrainingHeader(
    modifier: Modifier = Modifier,
    training: Training,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
            .recomposeHighlighter(),
        horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingM)
    ) {

        ChartBlock(
            modifier = Modifier
                .weight(0.8f)
                .fillMaxHeight()
                .secondaryDefaultBackground(),
            title = "TONNAGE",
            value = training.tonnage,
            icon = Weight,
            values = training.tonnageExerciseList
        )

        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(Design.dp.paddingM)
        ) {

            DefaultItem(
                modifier = Modifier
                    .secondaryDefaultBackground()
                    .padding(Design.dp.paddingS),
                title = "Duration",
                subTitle = training.duration,
                icon = Time
            )

            DefaultItem(
                modifier = Modifier
                    .secondaryDefaultBackground()
                    .padding(Design.dp.paddingS),
                title = "Intensity",
                subTitle = training.intensity,
                icon = HandWeight
            )
        }
    }
}

@Composable
private fun DefaultItem(
    modifier: Modifier = Modifier,
    title: String,
    subTitle: String,
    icon: ImageVector
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingS),
        verticalAlignment = Alignment.CenterVertically
    ) {

        ButtonIconSecondary(
            modifier = Modifier
                .size(Design.dp.componentS)
                .accentDefaultBackground()
                .padding(Design.dp.paddingS),
            color = Design.colors.content,
            imageVector = icon
        )

        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.Center
        ) {

            TextH4(
                provideText = { title }
            )

            TextBody2(
                provideText = { subTitle },
                color = Design.colors.caption
            )
        }
    }
}

@Composable
private fun ChartBlock(
    modifier: Modifier = Modifier,
    title: String,
    value: String,
    icon: ImageVector,
    values: ImmutableList<Float>,
) {
    Column(modifier = modifier.recomposeHighlighter()) {

        BasicLineChart(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(start = Design.dp.paddingM, end = Design.dp.paddingM, top = Design.dp.paddingM)
                .recomposeHighlighter(),
            values = values,
            color = Design.colors.accentPrimary,
            bottomSpacing = 20f,
            circleColor = Design.colors.content
        )

        DefaultItem(
            modifier = Modifier
                .padding(Design.dp.paddingS),
            title = title,
            subTitle = value,
            icon = icon
        )
    }
}