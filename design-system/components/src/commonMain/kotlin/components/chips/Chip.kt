package components.chips

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import atom.Design
import molecule.IconImage
import molecule.PaddingS
import molecule.TextBody2

public sealed class ChipState(public open val enabled: Boolean) {
    public data class Default(
        override val enabled: Boolean = true
    ) : ChipState(enabled)

    public data class Colored(
        val contentColor: Color,
        val backgroundColor: Color,
        val borderColor: Color,
        override val enabled: Boolean = true
    ) : ChipState(enabled)
}

@Composable
public fun Chip(
    modifier: Modifier = Modifier,
    chipState: ChipState = ChipState.Default(true),
    text: String,
    iconStart: ImageVector? = null,
    iconEnd: ImageVector? = null,
    onClick: () -> Unit = {}
) {

    val contentColor =
        if (chipState is ChipState.Colored) chipState.contentColor
        else Design.colors.content

    val interactionSource = remember { MutableInteractionSource() }

    val internalModifier = when (chipState) {
        is ChipState.Default -> modifier
            .border(
                color = Design.colors.caption,
                width = 1.dp,
                shape = Design.shape.circleShape
            ).background(
                color = Design.colors.white5,
                shape = Design.shape.circleShape
            ).clip(
                shape = Design.shape.circleShape
            )

        is ChipState.Colored -> modifier
            .border(
                color = chipState.borderColor,
                width = 1.dp,
                shape = Design.shape.circleShape
            ).background(
                color = chipState.backgroundColor,
                shape = Design.shape.circleShape
            ).clip(
                shape = Design.shape.circleShape
            )
    }

    Row(
        modifier = Modifier
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                enabled = chipState.enabled,
                onClick = onClick
            ).then(internalModifier)
            .padding(
                horizontal = Design.dp.paddingM,
                vertical = Design.dp.paddingS
            ),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {

        if (iconStart != null) {
            IconImage(
                modifier = Modifier.size(18.dp),
                imageVector = iconStart
            )

            PaddingS()
        }

        TextBody2(
            modifier = Modifier.align(Alignment.CenterVertically),
            textAlign = TextAlign.Center,
            maxLines = 1,
            provideText = { text },
            color = contentColor
        )

        if (iconEnd != null) {
            PaddingS()

            IconImage(
                modifier = Modifier.size(18.dp),
                imageVector = iconEnd
            )
        }
    }
}