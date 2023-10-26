package components.chips

import Design
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import molecular.ButtonIconSecondary
import molecular.PaddingXS
import molecular.TextBody2
import molecular.accentCircleBackground
import molecular.transparentCircleBackground
import molecular.white5CircleBackground
import molecular.white5CircleBackgroundNoBorder

public sealed class ChipState(public open val enabled: Boolean) {
    public data class HalfTransparent(override val enabled: Boolean = true) : ChipState(enabled)
    public data class Default(override val enabled: Boolean = true) : ChipState(enabled)
    public data class Selected(override val enabled: Boolean = true) : ChipState(enabled)
    public data class Highlighted(override val enabled: Boolean = true) : ChipState(enabled)
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

        is ChipState.Highlighted -> Modifier
            .accentCircleBackground()

        is ChipState.Selected -> Modifier
            .transparentCircleBackground()

        is ChipState.HalfTransparent -> Modifier
            .white5CircleBackgroundNoBorder()
            .alpha(0.5f)
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
                horizontal = Design.dp.paddingM,
                vertical = Design.dp.paddingS
            ),
        horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingS),
        verticalAlignment = Alignment.CenterVertically
    ) {

        if (icon != null) {
            ButtonIconSecondary(
                modifier = Modifier.size(18.dp),
                imageVector = icon
            )
        } else {
            PaddingXS()
        }

        TextBody2(
            provideText = { text }
        )

        PaddingXS()
    }
}