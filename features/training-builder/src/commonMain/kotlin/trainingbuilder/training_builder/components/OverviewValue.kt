package trainingbuilder.training_builder.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import atom.Design
import molecule.Icon
import molecule.TextBody4
import molecule.TextH5

@Composable
internal fun OverviewValue(
    modifier: Modifier = Modifier,
    title: String,
    icon: ImageVector,
    color: Color,
    value: @Composable () -> Unit
) {

    Row(
        modifier = modifier.height(Design.dp.componentXS),
        horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingM),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Icon(
            modifier = Modifier.padding(vertical = Design.dp.paddingXS),
            color = color,
            imageVector = icon
        )

        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.Center
        ) {

            TextBody4(
                modifier = Modifier.padding(horizontal = Design.dp.paddingM),
                provideText = { title },
            )

            TextH5(
                provideText = { title },
                color = Design.colors.yellow,
                maxLines = 1
            )

            value.invoke()
        }
    }
}