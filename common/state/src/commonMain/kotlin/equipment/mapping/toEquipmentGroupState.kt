package equipment.mapping

import IncludedStatusEnum
import equipment.EquipmentGroup
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toPersistentList

public fun List<models.EquipmentGroup>.toState(
    defaultStatus: IncludedStatusEnum? = null
): ImmutableList<EquipmentGroup> {
    return map { it.toState(defaultStatus) }
        .toPersistentList()
}

public fun models.EquipmentGroup.toState(
    defaultStatus: IncludedStatusEnum?
): EquipmentGroup {
    return EquipmentGroup(
        name = name,
        id = id,
        equipments = equipments.toState(defaultStatus)
    )
}