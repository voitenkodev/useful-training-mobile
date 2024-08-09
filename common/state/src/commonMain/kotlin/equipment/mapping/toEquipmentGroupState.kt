package equipment.mapping

import equipment.EquipmentGroup
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toPersistentList
import models.Equipment

public fun List<models.EquipmentGroup>.toState(
    eachEquipment: (Equipment) -> equipment.Equipment? = {
        it.toState()
    },
    eachEquipmentGroup: (models.EquipmentGroup) -> EquipmentGroup = {
        it.toState(eachEquipment = eachEquipment)
    },
): ImmutableList<EquipmentGroup> {
    return map(eachEquipmentGroup)
        .toPersistentList()
}

public fun models.EquipmentGroup.toState(
    eachEquipment: (Equipment) -> equipment.Equipment? = {
        it.toState()
    },
): EquipmentGroup {
    return EquipmentGroup(
        name = name,
        id = id,
        equipments = equipments.toState(eachEquipment)
    )
}