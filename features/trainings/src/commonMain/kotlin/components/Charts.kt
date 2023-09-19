package components

import Design
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import basic.BasicLineChart
import controls.TextFieldH2
import controls.secondaryBackground
import recomposeHighlighter
import training.Training

@Composable
internal fun ChartsInfo(
    training: Training
) {
    Row(
        modifier = Modifier.fillMaxWidth().recomposeHighlighter(),
        horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingM)
    ) {
        TrainingChart(
            title = "TONNAGE",
            values = training.exercises.map { it.tonnage.toFloat() },
            color = Design.colors.accent_tertiary
        )

        TrainingChart(
            title = "INTENSITY",
            values = training.exercises.map { it.intensity.toFloat() },
            color = Design.colors.accent_quaternary
        )
    }
}

@Composable
private fun RowScope.TrainingChart(
    title: String,
    values: List<Float>,
    color: Color
) {
    Column(
        modifier = Modifier
            .weight(1f)
            .padding(vertical = Design.dp.paddingS)
            .recomposeHighlighter(),
        verticalArrangement = Arrangement.spacedBy(Design.dp.paddingS)
    ) {
        TextFieldH2(
            provideText = { title }
        )

        BasicLineChart(
            modifier = Modifier
                .fillMaxWidth()
                .secondaryBackground()
                .padding(vertical = Design.dp.paddingS)
                .height(Design.dp.component)
                .recomposeHighlighter(),
            values = values,
            color = color
        )
    }
}