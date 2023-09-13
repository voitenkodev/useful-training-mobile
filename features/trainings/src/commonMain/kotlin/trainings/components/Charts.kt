package trainings.components

import Design
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import chart.basic.BasicLineChart
import controls.TextFieldBody2
import controls.TextFieldH2
import controls.secondaryBackground
import recomposeHighlighter
import training.Training

@Composable
internal fun ChartsInfo(
    training: Training
) {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingM)
    ) {

        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(Design.dp.paddingS)
        ) {

            TextFieldH2(
                provideText = { "TONNAGE" }
            )

            BasicLineChart(
                modifier = Modifier
                    .fillMaxWidth()
                    .secondaryBackground()
                    .padding(vertical = Design.dp.paddingS)
                    .height(Design.dp.component),
                values = training.exercises.map { it.tonnage.toFloat() },
                color = Design.colors.accent_tertiary
            )
        }

        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {

            TextFieldH2(
                provideText = { "INTENSITY" }
            )

            BasicLineChart(
                modifier = Modifier
                    .fillMaxWidth()
                    .secondaryBackground()
                    .padding(vertical = Design.dp.paddingS)
                    .height(Design.dp.component),
                values = training.exercises.map { it.intensity.toFloat() },
                color = Design.colors.accent_quaternary
            )
        }
    }
}

@Composable
private fun Section(
    provideLabel: () -> String,
    provideValue: () -> String,
    compareValue: () -> String?
) = Row(
    modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = Design.dp.paddingM)
        .recomposeHighlighter(),
) {

    TextFieldBody2(
        modifier = Modifier.recomposeHighlighter(),
        provideText = provideLabel,
        color = Design.colors.caption,
    )

    Spacer(
        modifier = Modifier.weight(1f)
    )

    TextFieldBody2(
        modifier = Modifier.recomposeHighlighter(),
        provideText = provideValue,
        fontWeight = FontWeight.Bold,
    )

    TextFieldBody2(
        modifier = Modifier.recomposeHighlighter(),
        provideText = compareValue,
        fontWeight = FontWeight.Bold,
        color = Design.colors.caption
    )
}
