package searchexercise.main

import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import searchexercise.main.models.ExerciseExample
import searchexercise.main.models.FilterEquipment
import searchexercise.main.models.FilterMuscleGroup
import searchexercise.main.models.FilterPack

@Immutable
internal data class State(
    val exerciseExamples: ImmutableList<ExerciseExample> = persistentListOf(),

    // Filters
    val filtersPopupIsVisible: Boolean = false,
    val query: String = "",
    val equipments: ImmutableList<FilterEquipment> = persistentListOf(),
    val muscles: ImmutableList<FilterMuscleGroup> = persistentListOf(),
    val filterPack: FilterPack = FilterPack(),

    val error: String? = null,
    val loading: Boolean = false
)
