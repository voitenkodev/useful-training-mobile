package components

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
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import atomic.icons.HandWeight
import atomic.icons.Weight
import basic.BasicLineChart
import controls.TextFieldBody2
import controls.TextFieldH4
import controls.accentBackground
import controls.tertiaryBackground
import recomposeHighlighter
import toDoubleOrIntString
import toShortString
import training.Training

@Composable
internal fun TrainingHeader(
    modifier: Modifier = Modifier,
    training: Training
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
                .tertiaryBackground(),
            title = "TONNAGE",
            value = training.tonnage?.toShortString() ?: "-",
            icon = Weight,
            values = training.exercises.map { it.tonnage.toFloat() }
        )

        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(Design.dp.paddingM)
        ) {

            DefaultItem(
                title = "Duration",
                subTitle = training.durationTime,
                icon = Time
            )

            DefaultItem(
                title = "Intensity",
                subTitle = training.intensity?.toDoubleOrIntString() ?: "-",
                icon = HandWeight
            )
        }
    }
}

@Composable
private fun DefaultItem(
    title: String,
    subTitle: String,
    icon: ImageVector
) {
    Row(
        modifier = Modifier
            .tertiaryBackground()
            .padding(Design.dp.paddingS),
        horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingS),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Icon(
            modifier = Modifier
                .size(Design.dp.componentS)
                .accentBackground()
                .padding(Design.dp.paddingS),
            tint = Design.colors.primary,
            imageVector = icon,
            contentDescription = null
        )

        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.Center
        ) {

            TextFieldH4(
                provideText = { title }
            )

            TextFieldBody2(
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
    values: List<Float>,
) {
    Column(modifier = modifier.recomposeHighlighter()) {

        BasicLineChart(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(start = Design.dp.paddingM, end = Design.dp.paddingM, top = Design.dp.paddingM)
                .recomposeHighlighter(),
            values = values,
            color = Design.colors.accent_primary,
            bottomSpacing = 20f,
            circleColor = Design.colors.content
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(Design.dp.paddingS),
            horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingS),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(
                modifier = Modifier
                    .size(Design.dp.componentS)
                    .accentBackground()
                    .padding(Design.dp.paddingS),
                tint = Design.colors.primary,
                imageVector = icon,
                contentDescription = null
            )

            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.Center
            ) {

                TextFieldH4(
                    provideText = { title },
                    maxLines = 1
                )

                TextFieldBody2(
                    provideText = { value },
                    color = Design.colors.caption,
                    maxLines = 1
                )
            }
        }
    }
}