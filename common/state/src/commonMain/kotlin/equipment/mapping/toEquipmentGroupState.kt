package equipment.mapping

import equipment.EquipmentGroup
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toPersistentList

public fun List<models.EquipmentGroup>.toState(): ImmutableList<EquipmentGroup> {
    return map { it.toState() }
        .toPersistentList()
}

public fun models.EquipmentGroup.toState(): EquipmentGroup {
    return EquipmentGroup(
        name = name,
        id = id,
        equipments = equipments.toState()
    )
}