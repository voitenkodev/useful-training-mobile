package searchexercise.main.popups.components

import androidx.compose.runtime.Composable
import equipment.EquipmentGroup
import equipment.component.EquipmentGroup
import kotlinx.collections.immutable.ImmutableList

@Composable
internal fun EquipmentGroups(
    items: ImmutableList<EquipmentGroup>,
    selectEquipment: (id: String) -> Unit
) {
    items.forEach { item ->
        EquipmentGroup(
            item = item,
            selectEquipment = selectEquipment
        )
    }
}