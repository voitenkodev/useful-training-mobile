package userequipments.main.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import atom.Design
import equipment.EquipmentGroup
import equipment.IncludedStatusEnum
import molecule.IconImage
import molecule.PaddingM
import molecule.PaddingS
import molecule.TextBody2
import molecule.TextH4
import resources.Icons
import shimmerLoadingAnimation

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
            modifier = Modifier.fillMaxWidth().height(200.dp * multiplier),
            rows = GridCells.Fixed(multiplier),
            contentPadding = PaddingValues(Design.dp.paddingM),
            horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingS),
            verticalArrangement = Arrangement.spacedBy(Design.dp.paddingS)
        ) {
            items(item.equipments, key = { it.id }) { equipment ->

                Column(
                    modifier = Modifier
                        .width(160.dp)
                        .border(
                            color = Design.colors.white10,
                            width = 1.dp,
                            shape = Design.shape.default
                        )
                        .clip(shape = Design.shape.default)
                        .shimmerLoadingAnimation(equipment.loading)
                        .padding(bottom = Design.dp.paddingM)
                        .clickable(
                            interactionSource = interactionSource,
                            indication = null,
                            enabled = equipment.loading.not(),
                            onClick = { selectEquipment.invoke(equipment.id) }
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
                                ),
                            imageVector = equipment.image,
                            contentScale = ContentScale.Fit,
                            contentDescription = null
                        )

                        val iconStart = remember(equipment.status) {
                            when (equipment.status) {
                                IncludedStatusEnum.EXCLUDED -> Icons.redCircle
                                IncludedStatusEnum.INCLUDED -> Icons.greenCircle
                            }
                        }

                        IconImage(
                            modifier = Modifier
                                .align(Alignment.TopEnd)
                                .padding(Design.dp.paddingS)
                                .size(18.dp),
                            imageVector = iconStart
                        )
                    }

                    TextBody2(
                        modifier = Modifier.padding(horizontal = Design.dp.paddingM),
                        textAlign = TextAlign.Center,
                        provideText = { equipment.name },
                    )
                }
            }
        }
    }
}