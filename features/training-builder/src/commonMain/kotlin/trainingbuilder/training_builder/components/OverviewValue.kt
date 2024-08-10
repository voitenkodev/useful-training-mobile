package trainingbuilder.training_builder.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import atom.Design
import molecule.Icon
import molecule.TextBody3
import molecule.TextH4

@Composable
internal fun OverviewValue(
    modifier: Modifier = Modifier,
    title: String,
    description: String,
    icon: ImageVector,
    color: Color
) {

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingS),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Icon(
            modifier = Modifier
                .size(Design.dp.componentS)
                .padding(Design.dp.paddingS),
            color = color,
            imageVector = icon
        )

        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.Center
        ) {

            TextH4(
                provideText = { title },
                color = Design.colors.yellow
            )

            TextBody3(
                provideText = { description },
                color = Design.colors.content
            )
        }
    }
}