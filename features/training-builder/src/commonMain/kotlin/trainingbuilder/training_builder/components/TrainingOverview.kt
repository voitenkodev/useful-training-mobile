package trainingbuilder.training_builder.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import atom.Design
import components.cards.VerticalValueCard
import components.indication.HeapIndicator
import kg
import molecule.TextH4
import molecule.secondaryDefaultBackground
import resources.Icons

@Composable
internal fun TrainingOverview(
    volume: Double,
    fullFrontImage: ImageVector,
    fullBackImage: ImageVector
) {
    Row(
        modifier = Modifier.fillMaxWidth().height(IntrinsicSize.Min),
        horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingM)
    ) {

        Column(
            modifier = Modifier
                .weight(2f)
                .secondaryDefaultBackground()
                .padding(Design.dp.paddingM),
            verticalArrangement = Arrangement.spacedBy(Design.dp.paddingS)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingM),
                verticalAlignment = Alignment.CenterVertically
            ) {
                TextH4(provideText = { "HEAP MAP" })

                HeapIndicator(modifier = Modifier.weight(1f).padding(bottom = 4.dp))
            }

            Row(horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingS)) {

                Image(
                    modifier = Modifier.weight(1f).fillMaxHeight(),
                    contentDescription = null,
                    imageVector = fullFrontImage
                )

                Image(
                    modifier = Modifier.weight(1f).fillMaxHeight(),
                    contentDescription = null,
                    imageVector = fullBackImage
                )
            }
        }

        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(Design.dp.paddingM),
        ) {

            VerticalValueCard(
                icon = Icons.time,
                title = "10M",
                description = "Duration"
            )

            VerticalValueCard(
                icon = Icons.weight,
                title = volume.kg(false),
                description = "Volume"
            )
        }
    }
}