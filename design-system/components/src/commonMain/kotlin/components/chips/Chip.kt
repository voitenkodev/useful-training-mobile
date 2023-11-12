package components.chips

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import atom.Design
import molecule.IconSecondary
import molecule.PaddingXS
import molecule.TextBody3
import molecule.coloredCircleBackgroundNoBorder
import molecule.transparentCircleBackground
import molecule.white5CircleBackground
import molecule.white5CircleBackgroundNoBorder

public sealed class ChipState(public open val enabled: Boolean) {
    public data class HalfTransparent(override val enabled: Boolean = true) : ChipState(enabled)
    public data class Default(override val enabled: Boolean = true) : ChipState(enabled)
    public data class Selected(override val enabled: Boolean = true) : ChipState(enabled)
    public data class Colored(val color: Color, override val enabled: Boolean = true) : ChipState(enabled)
}

@Composable
public fun Chip(
    chipState: ChipState = ChipState.Default(true),
    text: String,
    icon: ImageVector? = null,
    onClick: () -> Unit = {},
) {

    val interactionSource = remember { MutableInteractionSource() }

    val modifier = when (chipState) {

        is ChipState.Default -> Modifier
            .white5CircleBackground()

        is ChipState.Selected -> Modifier
            .transparentCircleBackground()

        is ChipState.HalfTransparent -> Modifier
            .white5CircleBackgroundNoBorder()
            .alpha(0.5f)

        is ChipState.Colored -> Modifier
            .coloredCircleBackgroundNoBorder(color = chipState.color)
    }

    Row(
        modifier = Modifier
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                enabled = chipState.enabled,
                onClick = onClick
            ).then(modifier)
            .padding(
                horizontal = Design.dp.paddingS,
                vertical = Design.dp.paddingS
            ),
        horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingS),
        verticalAlignment = Alignment.CenterVertically
    ) {

        if (icon != null) {
            IconSecondary(
                modifier = Modifier.size(18.dp),
                imageVector = icon
            )
        } else {
            PaddingXS()
        }

        TextBody3(
            provideText = { text }
        )

        PaddingXS()
    }
}