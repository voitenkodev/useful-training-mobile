package trainingbuilder.training_builder.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import atom.Design
import components.indication.HeapIndicator
import molecule.PaddingS

@Composable
internal fun HeapMap(
    modifier: Modifier = Modifier,
    fullFrontImage: ImageVector,
    fullBackImage: ImageVector,
) {
    Column(modifier = modifier) {

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

        PaddingS()

        HeapIndicator(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = Design.dp.paddingS)
        )
    }
}