package components

import Design
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import basic.BasicLineChart
import controls.TextFieldH2
import controls.TextFieldH3
import controls.secondaryBackground
import recomposeHighlighter
import round
import toShortString
import training.Training

@Composable
internal fun ChartsInfo(
    modifier: Modifier = Modifier,
    training: Training
) {
    Row(
        modifier = modifier.fillMaxWidth().recomposeHighlighter(),
        horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingM)
    ) {
        TrainingChart(
            title = "TONNAGE",
            values = training.exercises.map { it.tonnage.toFloat() },
            color = Design.colors.accent_tertiary,
            value = training.tonnage?.toShortString() ?: "-"
        )

        TrainingChart(
            title = "REPEATS",
            values = training.exercises.map { it.countOfLifting.toFloat() },
            color = Design.colors.accent_quinary,
            value = training.countOfLifting.toString()
        )

        TrainingChart(
            title = "INTENSITY",
            values = training.exercises.map { it.intensity.toFloat() },
            color = Design.colors.accent_quaternary,
            value = "${training.intensity?.round(1) ?: "-"}%"
        )
    }
}

@Composable
private fun RowScope.TrainingChart(
    title: String,
    value: String,
    values: List<Float>,
    color: Color
) {
    Box(
        modifier = Modifier
            .weight(1f)
            .secondaryBackground()
            .recomposeHighlighter(),
        contentAlignment = Alignment.Center
    ) {

        BasicLineChart(
            modifier = Modifier
                .fillMaxWidth()
                .secondaryBackground()
                .padding(top = Design.dp.paddingM)
                .height(Design.dp.component + Design.dp.paddingL)
                .recomposeHighlighter(),
            values = values,
            color = color.copy(alpha = 0.1f),
            bottomSpacing = 60f
        )

        Box(
            modifier = Modifier.height(46.dp)
        ) {

            TextFieldH2(
                modifier = Modifier.align(Alignment.TopCenter),
                provideText = { value },
                color = Design.colors.content
            )

            TextFieldH3(
                modifier = Modifier.align(Alignment.BottomCenter),
                provideText = { title },
                color = color
            )
        }
    }
}