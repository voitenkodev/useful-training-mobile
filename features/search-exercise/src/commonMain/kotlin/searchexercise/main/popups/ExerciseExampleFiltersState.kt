package searchexercise.main.popups

import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import searchexercise.main.models.FilterEquipment
import searchexercise.main.models.FilterMuscleGroup
import searchexercise.main.models.FilterPack

@Immutable
internal data class ExerciseExampleFiltersState(
    val equipments: ImmutableList<FilterEquipment> = persistentListOf(),
    val muscles: ImmutableList<FilterMuscleGroup> = persistentListOf(),
    val filterPack: FilterPack = FilterPack()
)