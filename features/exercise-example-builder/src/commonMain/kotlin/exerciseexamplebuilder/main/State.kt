package exerciseexamplebuilder.main

import androidx.compose.runtime.Immutable
import equipment.EquipmentGroup
import exercise.ResourceTypeEnum
import exerciseexamplebuilder.main.models.Filter
import exerciseexamplebuilder.main.models.FilterPack
import exerciseexamplebuilder.main.models.ResourceTypeFilter
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

    val tutorialTitle: String = "",
    val tutorialValue: String = "",
    val tutorialResourceTypes: ImmutableList<ResourceTypeFilter> = ResourceTypeEnum.entries
        .map { ResourceTypeFilter(it, false) }
        .toPersistentList(),
    val tutorialLanguages: ImmutableList<Filter> = persistentListOf(
        Filter("en", false),
        Filter("ua", false),
        Filter("ru", false),
    ),

    val equipmentGroups: ImmutableList<EquipmentGroup> = persistentListOf(),

    val error: String? = null,
    val loading: Boolean = false
)