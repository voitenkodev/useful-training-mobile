package userequipments.main.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import atom.Design
import molecule.IconImage
import molecule.PaddingM
import molecule.PaddingS
import molecule.TextBody2
import molecule.TextH4
import molecule.secondaryDefaultBackground
import resources.Icons
import shimmerLoadingAnimation
import userequipments.main.models.EquipmentGroup
import userequipments.main.models.StatusEnum

@Composable
internal fun EquipmentGroup(
    item: EquipmentGroup,
    selectEquipment: (id: String) -> Unit
) {

    val multiplier = remember(item.equipments.size) { if (item.equipments.size > 8) 2 else 1 }

    val interactionSource = remember { MutableInteractionSource() }

    PaddingS()

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        PaddingM()

        TextH4(
            modifier = Modifier.fillMaxWidth().padding(horizontal = Design.dp.paddingM),
            provideText = { item.name },
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )

        LazyHorizontalGrid(
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp * multiplier),
            rows = GridCells.Fixed(multiplier),
            contentPadding = PaddingValues(Design.dp.paddingM),
            horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingS),
            verticalArrangement = Arrangement.spacedBy(Design.dp.paddingS)
        ) {
            items(item.equipments, key = { it.id }) { equipment ->

                Column(
                    modifier = Modifier
                        .width(Design.dp.componentXL)
                        .secondaryDefaultBackground()
                        .padding(bottom = Design.dp.paddingS)
                        .shimmerLoadingAnimation(equipment.loading)
                        .clickable(
                            interactionSource = interactionSource,
                            indication = null,
                            enabled = equipment.loading.not(),
                            onClick = { selectEquipment.invoke(equipment.id) }
                        ),
                    verticalArrangement = Arrangement.spacedBy(Design.dp.paddingS),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(modifier = Modifier.weight(1f)) {

                        IconImage(
                            modifier = Modifier.fillMaxSize().padding(Design.dp.paddingM),
                            imageVector = equipment.image
                        )

                        val iconStart = remember(equipment.status) {
                            when (equipment.status) {
                                StatusEnum.EXCLUDED -> Icons.redCircle
                                StatusEnum.INCLUDED -> Icons.greenCircle
                            }
                        }

                        IconImage(
                            modifier = Modifier
                                .align(Alignment.TopEnd)
                                .padding(Design.dp.paddingM)
                                .size(18.dp),
                            imageVector = iconStart
                        )
                    }

                    TextBody2(
                        modifier = Modifier.padding(horizontal = Design.dp.paddingS),
                        textAlign = TextAlign.Center,
                        provideText = { equipment.name },
                    )
                }
            }
        }
    }
}