package equipment.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import atom.Design
import equipment.Equipment
import molecule.IconImage
import molecule.TextBody2
import resources.Icons
import shimmerLoadingAnimation

@Composable
public fun EquipmentChip(
    item: Equipment,
    selectEquipment: (id: String) -> Unit
) {

    val interactionSource = remember { MutableInteractionSource() }

    val contentColor = remember(item.isSelected) {
        when (item.isSelected) {
            false -> Design.palette.content.copy(alpha = 0.3f)
            true -> Design.palette.content
        }
    }

    val alpha = remember(item.isSelected) {
        when (item.isSelected) {
            true -> 1f
            false -> 0.3f
        }
    }

    val iconStart = remember(item.isSelected) {
        when (item.isSelected) {
            true -> Icons.checkOn
            false -> Icons.checkOff
        }
    }

    val borderIcon = when (item.isSelected) {
        true -> Design.colors.green.copy(alpha = 0.4f)
        false -> Design.colors.white10
    }

    Column(
        modifier = Modifier
            .width(140.dp)
            .border(
                color = borderIcon,
                width = 1.dp,
                shape = Design.shape.default
            )
            .clip(shape = Design.shape.default)
            .shimmerLoadingAnimation(item.loading)
            .padding(bottom = Design.dp.paddingM)
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                enabled = item.loading.not(),
                onClick = { selectEquipment.invoke(item.id) }
            ),
        verticalArrangement = Arrangement.spacedBy(Design.dp.paddingS),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(modifier = Modifier.fillMaxWidth().weight(1f)) {

            Image(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        start = Design.dp.paddingL,
                        end = Design.dp.paddingL,
                        top = Design.dp.paddingM
                    ).alpha(alpha = alpha),
                imageVector = item.image,
                contentScale = ContentScale.Fit,
                contentDescription = null
            )

            IconImage(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(Design.dp.paddingS)
                    .size(18.dp),
                imageVector = iconStart
            )
        }

        TextBody2(
            modifier = Modifier.padding(horizontal = Design.dp.paddingM),
            textAlign = TextAlign.Center,
            color = contentColor,
            provideText = { item.name },
        )
    }
}