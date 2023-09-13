package trainings.components

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
import controls.TextFieldH2
import controls.secondaryBackground
import recomposeHighlighter
import training.Training

@Composable
internal fun SummaryInfo(
    training: Training
) {

    Column {

        TextFieldH2(
            provideText = { "SUMMARY" }
        )

        Spacer(
            modifier = Modifier.size(Design.dp.paddingS)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .secondaryBackground()
                .padding(Design.dp.paddingM),
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
    }
}