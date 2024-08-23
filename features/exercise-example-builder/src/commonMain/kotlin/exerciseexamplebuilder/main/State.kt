package exerciseexamplebuilder.main

import androidx.compose.runtime.Immutable
import equipment.EquipmentGroup
import exercise.ResourceTypeEnum
import exerciseexamplebuilder.main.models.FilterPack
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toPersistentList
import muscles.MuscleGroup

@Immutable
internal data class State(
    val name: String = "",
    val description: String = "",
    val imageUrl: String = "",

    val muscleGroups: ImmutableList<MuscleGroup> = persistentListOf(),
    val sliderRange: ClosedRange<Int> = 0..100,
    val minimalRange: Int = 3,

    val filterPack: FilterPack = FilterPack(),

    val tutorialResourceTypes: ImmutableList<ResourceTypeEnum> = ResourceTypeEnum.entries.toPersistentList(),

    val equipmentGroups: ImmutableList<EquipmentGroup> = persistentListOf(),

    val error: String? = null,
    val loading: Boolean = false
)
