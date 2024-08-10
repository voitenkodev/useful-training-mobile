package authentication.register.components

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
import molecule.TextH4

@Composable
public fun ExperienceCard(
    modifier: Modifier = Modifier,
    title: String,
    description: String,
    isSelected: Boolean = false,
    startIcon: Pair<ImageVector, Color>,
    onClick: (() -> Unit)? = null
) {

    val initialModifier = modifier
        .border(
            color = if (isSelected) Design.colors.toxic else Design.palette.white10,
            width = 1.dp,
            shape = Design.shape.default
        )

    val interactionSource = remember { MutableInteractionSource() }

    val actionModifierProvider = remember(onClick, isSelected) {
        if (onClick != null) initialModifier.clickable(
            onClick = onClick,
            interactionSource = interactionSource,
            indication = null
        )
        else initialModifier
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
                .size(Design.dp.componentS)
                .padding(Design.dp.paddingXS),
            color = when (isSelected) {
                true -> Design.colors.toxic
                false -> Design.colors.caption
            },
            imageVector = startIcon.first
        )

        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.Center
        ) {

            TextH4(
                provideText = { title }
            )

            PaddingXS()

            TextBody4(
                provideText = { description },
                color = Design.colors.caption
            )
        }
    }
}