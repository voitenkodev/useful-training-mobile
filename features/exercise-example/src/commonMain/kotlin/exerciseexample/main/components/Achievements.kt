package exerciseexample.main.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import atom.Design
import components.cards.VerticalValueCard
import kg
import molecule.TextLabel
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
            VerticalValueCard(
                modifier = Modifier.weight(1f).border(
                    color = Design.colors.orange,
                    width = 1.dp,
                    shape = Design.shape.default
                ),
                text = "Volume",
                value = 3546.0.kg(false),
                icon = Icons.weight
            )

            VerticalValueCard(
                modifier = Modifier.weight(1f).border(
                    color = Design.colors.orange,
                    width = 1.dp,
                    shape = Design.shape.default
                ),
                text = "P/M",
                value = 1500.0.kg(false),
                icon = Icons.handWeight
            )

            VerticalValueCard(
                modifier = Modifier.weight(1f).border(
                    color = Design.colors.orange,
                    width = 1.dp,
                    shape = Design.shape.default
                ),
                text = "Count",
                value = 50.toString(),
                icon = Icons.time
            )
        }
    }
}