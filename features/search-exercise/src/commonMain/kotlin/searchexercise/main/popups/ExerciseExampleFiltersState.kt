package searchexercise.main.popups

import androidx.compose.runtime.Immutable
import equipment.EquipmentGroup
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import muscles.MuscleGroup
import searchexercise.main.models.FilterPack

@Immutable
internal data class ExerciseExampleFiltersState(
    val equipmentGroups: ImmutableList<EquipmentGroup> = persistentListOf(),
    val muscles: ImmutableList<MuscleGroup> = persistentListOf(),
    val filterPack: FilterPack = FilterPack()
)