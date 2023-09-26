package components

import Design
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import controls.TextFieldBody1
import controls.TextFieldH3
import controls.secondaryBackground
import recomposeHighlighter
import training.Training

@Composable
internal fun SummaryInfo(
    training: Training
) {

    TextFieldH3(
        modifier = Modifier.fillMaxWidth(),
        provideText = { "SUMMARY" }
    )
    Spacer(
        modifier = Modifier.size(Design.dp.paddingS)
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .secondaryBackground()
            .padding(Design.dp.paddingM),
        verticalArrangement = Arrangement.spacedBy(Design.dp.paddingM)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            TextFieldBody1(
                modifier = Modifier.recomposeHighlighter(),
                provideText = { "Duration" },
                color = Design.colors.caption,
            )

            TextFieldBody1(
                modifier = Modifier.recomposeHighlighter(),
                provideText = { training.durationTime },
                fontWeight = FontWeight.Bold,
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            TextFieldBody1(
                modifier = Modifier.recomposeHighlighter(),
                provideText = { "Tonnage" },
                color = Design.colors.caption,
            )

            TextFieldBody1(
                modifier = Modifier.recomposeHighlighter(),
                provideText = { "${training.tonnage}kg" },
                fontWeight = FontWeight.Bold,
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            TextFieldBody1(
                modifier = Modifier.recomposeHighlighter(),
                provideText = { "Intensity" },
                color = Design.colors.caption,
            )

            TextFieldBody1(
                modifier = Modifier.recomposeHighlighter(),
                provideText = { "${training.intensity}%" },
                fontWeight = FontWeight.Bold,
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            TextFieldBody1(
                modifier = Modifier.recomposeHighlighter(),
                provideText = { "Repeats" },
                color = Design.colors.caption,
            )

            TextFieldBody1(
                modifier = Modifier.recomposeHighlighter(),
                provideText = { "${training.countOfLifting}" },
                fontWeight = FontWeight.Bold,
            )
        }
    }
}