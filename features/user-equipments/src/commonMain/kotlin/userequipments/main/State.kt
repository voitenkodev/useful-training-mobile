package userequipments.main

import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import userequipments.main.models.EquipmentGroup

@Immutable
internal data class State(
    val equipmentGroups: ImmutableList<EquipmentGroup> = persistentListOf(),
    val error: String? = null,
    val loading: Boolean = false
)