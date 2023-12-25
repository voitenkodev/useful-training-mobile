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
                    color = Design.colors.toxic,
                    width = 1.dp,
                    shape = Design.shape.default
                ),
                title = "Volume" to Design.colors.content,
                description = 3546.0.kg(false) to Design.colors.toxic,
                icon = Icons.weight
            )

            VerticalValueCard(
                modifier = Modifier.weight(1f).border(
                    color = Design.colors.toxic,
                    width = 1.dp,
                    shape = Design.shape.default
                ),
                title = "P/M" to Design.colors.caption,
                description = 1500.0.kg(false) to Design.colors.toxic,
                icon = Icons.handWeight
            )

            VerticalValueCard(
                modifier = Modifier.weight(1f).border(
                    color = Design.colors.toxic,
                    width = 1.dp,
                    shape = Design.shape.default
                ),
                title = "Count" to Design.colors.content,
                description = 50.toString() to Design.colors.toxic,
                icon = Icons.time
            )
        }
    }
}