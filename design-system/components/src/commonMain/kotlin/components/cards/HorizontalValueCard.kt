package components.cards

import androidx.compose.foundation.border
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
import androidx.compose.ui.unit.dp
import atom.Design
import molecule.ButtonIconTransparent
import molecule.Icon
import molecule.TextBody3
import molecule.TextH4
import molecule.coloredDefaultBackgroundNoBorder
import molecule.secondaryDefaultBackground

@Composable
public fun HorizontalValueCard(
    modifier: Modifier = Modifier,
    title: String,
    description: String,
    startIcon: Pair<ImageVector, Color>,
    actionEndIcon: Pair<ImageVector, () -> Unit>? = null
) {
    Row(
        modifier = modifier
            .secondaryDefaultBackground()
            .padding(Design.dp.paddingS),
        horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingS),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Icon(
            modifier = Modifier
                .size(Design.dp.componentS)
                .border(
                    color = startIcon.second,
                    width = 1.dp,
                    shape = Design.shape.default
                ).coloredDefaultBackgroundNoBorder(startIcon.second)
                .padding(Design.dp.paddingS),
            color = Design.colors.content,
            imageVector = startIcon.first
        )

        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.Center
        ) {

            TextH4(
                provideText = { title }
            )

            TextBody3(
                provideText = { description },
                color = Design.colors.caption
            )
        }

        if (actionEndIcon != null) {
            ButtonIconTransparent(
                imageVector = actionEndIcon.first,
                onClick = actionEndIcon.second,
                contentColor = Design.colors.caption
            )
        }
    }
}