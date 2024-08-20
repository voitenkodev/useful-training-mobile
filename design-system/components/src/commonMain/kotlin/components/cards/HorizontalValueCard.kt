package components.cards

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import atom.Design
import molecule.Icon
import molecule.PaddingXS
import molecule.TextBody4
import molecule.TextH5
import molecule.coloredDefaultBackgroundNoBorder

@Composable
public fun HorizontalValueCard(
    modifier: Modifier = Modifier,
    title: String,
    description: String,
    isSelected: Boolean = false,
    startIcon: Pair<ImageVector, Color>,
    endIcon: Pair<ImageVector, Color>? = null,
    onClick: (() -> Unit)? = null
) {


    val interactionSource = remember { MutableInteractionSource() }

    val actionModifierProvider = remember(onClick, isSelected) {
        if (onClick != null) modifier.clickable(
            onClick = onClick,
            interactionSource = interactionSource,
            indication = null
        )
        else modifier
    }

    Row(
        modifier = actionModifierProvider.padding(
            vertical = Design.dp.paddingM,
            horizontal = Design.dp.paddingM
        ),
        horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingM),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Icon(
            modifier = Modifier
                .size(Design.dp.componentXS)
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

            TextH5(
                provideText = { title }
            )

            PaddingXS()

            TextBody4(
                provideText = { description },
                color = Design.colors.label
            )
        }

        if (endIcon != null) {
            Icon(
                modifier = Modifier
                    .size(Design.dp.componentXS)
                    .padding(Design.dp.paddingS),
                color = endIcon.second,
                imageVector = endIcon.first
            )
        }
    }
}