package equipment.component

import IncludedStatusEnum
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import atom.Design
import equipment.Equipment
import molecule.TextBody2
import shimmerLoadingAnimation

@Composable
public fun EquipmentChip(
    modifier: Modifier = Modifier,
    item: Equipment,
    selectEquipment: (id: String) -> Unit
) {

    val interactionSource = remember { MutableInteractionSource() }

    val contentColor = remember(item.isSelected) {
        when {
            item.status == IncludedStatusEnum.EXCLUDED -> Design.palette.content.copy(alpha = 0.3f)
            item.isSelected.not() -> Design.palette.content
            item.isSelected -> Design.palette.content
            else -> Design.palette.content
        }
    }

    val alpha = remember(item.isSelected) {
        when (item.isSelected) {
            true -> 1f
            false -> 1f
        }
    }

    val backgroundColor = when {
        item.status == IncludedStatusEnum.EXCLUDED -> Design.palette.secondary
        item.isSelected -> Design.palette.green
        item.isSelected.not() -> Design.palette.tertiary
        else -> Design.palette.tertiary
    }

    Column(
        modifier = modifier
            .height(Design.dp.componentXL)
            .background(
                color = backgroundColor,
                shape = Design.shape.default
            )
            .clip(shape = Design.shape.default)
            .shimmerLoadingAnimation(item.loading)
            .padding(bottom = Design.dp.paddingS)
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                enabled = item.loading.not(),
                onClick = { selectEquipment.invoke(item.id) }
            ),
        verticalArrangement = Arrangement.spacedBy(Design.dp.paddingS),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(
                    start = Design.dp.paddingM,
                    end = Design.dp.paddingM,
                    top = Design.dp.paddingM
                ).alpha(alpha = alpha),
            imageVector = item.image,
            contentScale = ContentScale.Fit,
            contentDescription = null
        )

        TextBody2(
            modifier = Modifier.padding(horizontal = Design.dp.paddingM),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Medium,
            color = contentColor,
            provideText = { item.name },
        )
    }
}