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
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import atom.Design
import molecule.ButtonIconTransparent
import molecule.Icon
import molecule.PaddingS
import molecule.TextBody3
import molecule.TextH4

@Immutable
public data class WeightCardIcon(
    val icon: ImageVector,
    val action: () -> Unit
)

@Composable
public fun WeightCard(
    modifier: Modifier = Modifier,
    title: String,
    description: String,
    startIcon: Pair<ImageVector, Color>,
    endIcon: WeightCardIcon? = null,
    onClick: (() -> Unit)? = null
) {

    val initialModifier = modifier.border(
        width = 1.dp,
        shape = Design.shape.default,
        color = Design.colors.white10
    )

    val interactionSource = remember { MutableInteractionSource() }

    val actionModifierProvider = remember(onClick) {
        if (onClick != null) initialModifier.clickable(
            onClick = onClick,
            interactionSource = interactionSource,
            indication = null
        )
        else initialModifier
    }

    Row(
        modifier = actionModifierProvider.padding(
            vertical = Design.dp.paddingS,
            horizontal = Design.dp.paddingM
        ),
        horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingM),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Icon(
            modifier = Modifier
                .size(Design.dp.componentM)
                .border(
                    color = startIcon.second,
                    width = 1.dp,
                    shape = Design.shape.default
                ).padding(Design.dp.paddingM),
            color = startIcon.second,
            imageVector = startIcon.first
        )

        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.Center
        ) {

            PaddingS()

            TextH4(
                provideText = { title }
            )

            PaddingS()

            TextBody3(
                provideText = { description },
                color = Design.colors.white50
            )

            PaddingS()
        }

        if (endIcon != null) {
            ButtonIconTransparent(
                imageVector = endIcon.icon,
                onClick = endIcon.action
            )
        }
    }
}