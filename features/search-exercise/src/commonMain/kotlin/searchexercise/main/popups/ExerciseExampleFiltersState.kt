package searchexercise.main.popups

import androidx.compose.runtime.Immutable
import equipment.Equipment
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import muscles.MuscleGroup
import searchexercise.main.models.FilterPack

@Immutable
internal data class ExerciseExampleFiltersState(
    val equipments: ImmutableList<Equipment> = persistentListOf(),
    val muscles: ImmutableList<MuscleGroup> = persistentListOf(),
    val filterPack: FilterPack = FilterPack()
)