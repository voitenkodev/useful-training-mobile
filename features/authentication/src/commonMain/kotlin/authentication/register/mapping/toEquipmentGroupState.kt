package authentication.register.mapping

import authentication.register.models.EquipmentGroup
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toPersistentList

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