package userequipments.main.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import atom.Design
import components.chips.Chip
import components.chips.ChipState
import molecule.PaddingM
import molecule.PaddingS
import molecule.TextH4
import resources.Icons
import userequipments.main.models.Equipment
import userequipments.main.models.EquipmentGroup
import userequipments.main.models.StatusEnum

@Composable
internal fun EquipmentGroup(
    item: EquipmentGroup,
    selectEquipment: (id: String) -> Unit
) {

    PaddingS()

    Column(
        modifier = Modifier.fillMaxWidth().padding(Design.dp.paddingM),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        TextH4(
            modifier = Modifier.fillMaxWidth(),
            provideText = { item.name },
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )

        PaddingM()

        Box(modifier = Modifier.fillMaxWidth()) {

//            AsyncImage(
//                modifier = Modifier
//                    .height(Design.dp.componentXL)
//                    .aspectRatio(1f)
//                    .align(Alignment.CenterEnd),
//                url = item.bodyImageVector,
//                contentDescription = null
//            )

            Column(verticalArrangement = Arrangement.spacedBy(Design.dp.paddingS)) {
                item.equipments.forEach { equipment ->
                    EquipmentChip(
                        equipment = equipment,
                        selectEquipment = selectEquipment
                    )
                }
            }
        }
    }
}

@Composable
private fun EquipmentChip(
    equipment: Equipment,
    selectEquipment: (id: String) -> Unit
) {

    val contentColor = remember(equipment.status) {
        when (equipment.status) {
            StatusEnum.EXCLUDED -> Design.palette.caption
            StatusEnum.INCLUDED -> Design.palette.content
        }
    }

    val chipState = ChipState.Colored(
        backgroundColor = Color.Transparent,
        borderColor = Design.palette.white10,
        contentColor = contentColor
    )

    val iconStart = remember(equipment.status) {
        when (equipment.status) {
            StatusEnum.EXCLUDED -> Icons.redCircle
            StatusEnum.INCLUDED -> Icons.greenCircle
        }
    }

    Chip(
        chipState = chipState,
        onClick = { selectEquipment.invoke(equipment.id) },
        text = equipment.name,
        loading = equipment.loading,
        iconStart = iconStart
    )
}