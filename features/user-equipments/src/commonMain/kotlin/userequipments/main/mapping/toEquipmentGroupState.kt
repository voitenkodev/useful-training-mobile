package userequipments.main.mapping

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toPersistentList
import userequipments.main.models.EquipmentGroup

internal fun List<models.EquipmentGroup>.toState(): ImmutableList<EquipmentGroup> {
    return map { it.toState() }
        .toPersistentList()
}

internal fun models.EquipmentGroup.toState(): EquipmentGroup {

    return EquipmentGroup(
        name = name,
        id = id,
        equipments = equipments.toState()
    )
}