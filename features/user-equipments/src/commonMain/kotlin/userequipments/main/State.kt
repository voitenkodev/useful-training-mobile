package userequipments.main

import androidx.compose.runtime.Immutable
import equipment.EquipmentGroup
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

@Immutable
internal data class State(
    val equipmentGroups: ImmutableList<EquipmentGroup> = persistentListOf(),
    val error: String? = null,
    val loading: Boolean = false
)