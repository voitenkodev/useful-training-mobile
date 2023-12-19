package exerciseexample.main.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import atom.Design
import kg
import molecule.IconSecondary
import molecule.PaddingS
import molecule.TextBody3
import molecule.TextH3
import molecule.TextLabel
import molecule.secondaryDefaultBackground
import resources.Icons

@Composable
internal fun Achievements() {

    Column(
        modifier = Modifier.padding(horizontal = Design.dp.paddingM),
        verticalArrangement = Arrangement.spacedBy(Design.dp.paddingS)
    ) {

        TextLabel(provideText = { "Achievements" })

        Row(
            horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingM)
        ) {
            Item(
                text = "Volume",
                value = 3546.0.kg(false),
                icon = Icons.weight
            )

            Item(
                text = "P.M",
                value = 1500.0.kg(false),
                icon = Icons.handWeight
            )

            Item(
                text = "Count",
                value = 50.toString(),
                icon = Icons.time
            )
        }
    }
}

@Composable
private fun RowScope.Item(
    text: String,
    value: String,
    icon: ImageVector
) {
    Column(
        modifier = Modifier
            .weight(1f)
            .aspectRatio(0.8f)
            .border(
                color = Design.colors.orange,
                width = 1.dp,
                shape = Design.shape.default
            ).secondaryDefaultBackground()
            .padding(Design.dp.paddingM),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        IconSecondary(
            modifier = Modifier.weight(1f).aspectRatio(1f).padding(Design.dp.paddingXS),
            color = Design.colors.content,
            imageVector = icon
        )

        PaddingS()

        TextH3(
            textAlign = TextAlign.Center,
            provideText = { value },
            maxLines = 1,
            color = Design.colors.orange
        )

        TextBody3(
            textAlign = TextAlign.Center,
            maxLines = 1,
            provideText = { text },
            color = Design.colors.content
        )
    }
}