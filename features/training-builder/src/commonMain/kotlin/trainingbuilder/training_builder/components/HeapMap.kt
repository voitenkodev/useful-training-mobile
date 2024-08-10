package trainingbuilder.training_builder.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import atom.Design
import components.indication.HeapIndicator
import molecule.TextH4

@Composable
internal fun HeapMap(
    modifier: Modifier = Modifier,
    fullFrontImage: ImageVector,
    fullBackImage: ImageVector,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(Design.dp.paddingS)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingM),
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextH4(
                provideText = { "Heap map" },
                color = Design.colors.yellow
            )

            HeapIndicator(modifier = Modifier.weight(1f))
        }

        Row(horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingS)) {

            Image(
                modifier = Modifier.weight(1f),
                contentDescription = null,
                imageVector = fullFrontImage
            )

            Image(
                modifier = Modifier.weight(1f),
                contentDescription = null,
                imageVector = fullBackImage
            )
        }
    }
}