package exerciseexample.main.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import atom.Design
import molecule.PaddingS
import molecule.Shadow
import molecule.TextLabel

@Composable
internal fun HeapMap(fullFrontImage: ImageVector, fullBackImage: ImageVector) {

    Column {

        TextLabel(
            modifier = Modifier.padding(horizontal = Design.dp.paddingM),
            provideText = { "Heap Map" }
        )

        PaddingS()

        Column(modifier = Modifier.background(Design.colors.black10)) {

            Shadow()

            Row(
                modifier = Modifier.padding(horizontal = Design.dp.paddingXL, vertical = Design.dp.paddingM),
                horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingM)
            ) {

                Image(
                    modifier = Modifier.weight(1f).aspectRatio(0.8f),
                    contentDescription = null,
                    imageVector = fullFrontImage
                )

                Image(
                    modifier = Modifier.weight(1f).aspectRatio(0.8f),
                    contentDescription = null,
                    imageVector = fullBackImage
                )
            }

            Shadow()
        }
    }
}