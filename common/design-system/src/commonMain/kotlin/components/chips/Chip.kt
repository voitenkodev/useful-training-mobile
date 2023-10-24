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
import molecular.secondaryCircleBackground
import molecular.transparentCircleBackground

public enum class ChipStatus {
    DEFAULT,
    SELECTED,
    DISABLED,
    HIGHLIGHTED
}

@Composable
public fun Chip(
    chipStatus: ChipStatus = ChipStatus.DEFAULT,
    text: String,
    icon: ImageVector? = null,
    onClick: () -> Unit,
) {

    val interactionSource = remember { MutableInteractionSource() }

    val modifier = when (chipStatus) {
        ChipStatus.DEFAULT -> Modifier
            .secondaryCircleBackground()

        ChipStatus.SELECTED -> Modifier
            .transparentCircleBackground()

        ChipStatus.DISABLED -> Modifier
            .secondaryCircleBackground()
            .alpha(0.5f)

        ChipStatus.HIGHLIGHTED -> Modifier
            .accentCircleBackground()
    }

    Row(
        modifier = Modifier
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                enabled = chipStatus != ChipStatus.DISABLED,
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