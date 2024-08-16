package user.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import atom.Design
import molecule.PaddingS
import molecule.TextBody2
import molecule.TextH3

@Composable
public fun ExperienceCard(
    modifier: Modifier = Modifier,
    title: String,
    description: String,
    isSelected: Boolean = false,
    onClick: (() -> Unit)? = null
) {

    val initialModifier = modifier
        .background(
            color = if (isSelected) {
                Design.colors.green
            } else {
                Design.palette.secondary
            },
            shape = Design.shape.large
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
            vertical = Design.dp.paddingL,
            horizontal = Design.dp.paddingL
        ),
        horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingL),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.Center
        ) {

            TextH3(
                provideText = { title }
            )

            PaddingS()

            TextBody2(
                provideText = { description },
                color = when (isSelected) {
                    true -> Design.colors.content
                    false -> Design.colors.label
                }
            )
        }
    }
}