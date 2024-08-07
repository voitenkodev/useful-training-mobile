package components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import atom.Design
import molecule.Icon
import molecule.TextBody2
import molecule.TextH3

@Composable
public fun EmptyData(
    modifier: Modifier = Modifier,
    icon: ImageVector? = null,
    title: String,
    description: String,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = Design.dp.paddingXL),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(Design.dp.paddingS, Alignment.CenterVertically)
    ) {

        if (icon != null) {
            Icon(
                modifier = Modifier
                    .padding(vertical = Design.dp.paddingS)
                    .size(Design.dp.componentXXL),
                imageVector = icon,
                color = Design.colors.white30
            )
        }

        TextH3(
            textAlign = TextAlign.Center,
            provideText = { title },
            color = Design.colors.white30
        )

        TextBody2(
            textAlign = TextAlign.Center,
            provideText = { description },
            color = Design.colors.white30
        )
    }
}