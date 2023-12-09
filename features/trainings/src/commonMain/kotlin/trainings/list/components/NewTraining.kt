package trainings.list.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import atom.Design
import molecule.ButtonPrimary
import molecule.PaddingL
import molecule.PaddingXS
import molecule.TextBody1
import molecule.TextH3

@Composable
internal fun NewTraining(addTraining: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(Design.dp.paddingM)
            .border(
                width = 1.dp,
                shape = Design.shape.default,
                color = Design.colors.caption
            ).padding(Design.dp.paddingL),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        TextH3(
            provideText = { "Time to workout" },
            color = Design.colors.content
        )

        PaddingXS()

        TextBody1(
            provideText = { "Press to start workout" },
            color = Design.colors.content
        )

        PaddingL()

        ButtonPrimary(
            modifier = Modifier.padding(horizontal = Design.dp.paddingXL),
            text = "Start",
            textColor = Design.colors.primary,
            backgroundColor = Design.colors.toxic,
            onClick = addTraining
        )
    }
}