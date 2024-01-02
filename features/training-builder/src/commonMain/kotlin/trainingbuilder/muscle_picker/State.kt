package trainingbuilder.muscle_picker

import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import trainingbuilder.muscle_picker.models.MuscleType
import trainingbuilder.muscle_picker.models.StatusEnum

@Immutable
internal data class State(
    val muscleTypes: ImmutableList<MuscleType> = persistentListOf(),
    val includedMuscleStatuses: ImmutableList<StatusEnum> = persistentListOf(StatusEnum.MEDIUM, StatusEnum.LOW, StatusEnum.HIGH),
    val error: String? = null,
    val loading: Boolean = false
)