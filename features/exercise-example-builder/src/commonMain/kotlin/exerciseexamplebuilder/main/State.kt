package exerciseexamplebuilder.main

import androidx.compose.runtime.Immutable
import exerciseexamplebuilder.main.models.EquipmentGroup
import exerciseexamplebuilder.main.models.FilterPack
import exerciseexamplebuilder.main.models.MuscleGroup
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

@Immutable
internal data class State(
    val name: String = "",
    val description: String = "",
    val imageUrl: String = "",

    val muscleGroups: ImmutableList<MuscleGroup> = persistentListOf(),
    val sliderRange: ClosedRange<Int> = 0..100,
    val minimalRange: Int = 3,

    val filterPack: FilterPack = FilterPack(),

    val equipmentGroups: ImmutableList<EquipmentGroup> = persistentListOf(),

    val error: String? = null,
    val loading: Boolean = false
)
