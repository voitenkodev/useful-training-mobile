package components

import Design
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import chart.basic.BasicLineChart
import controls.TextFieldH2
import controls.secondaryBackground
import training.Training

@Composable
internal fun ChartsInfo(
    training: Training
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingS)
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
            verticalArrangement = Arrangement.spacedBy(Design.dp.paddingS)
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