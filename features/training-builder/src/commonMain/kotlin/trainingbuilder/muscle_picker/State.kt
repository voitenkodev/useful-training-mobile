package trainingbuilder.muscle_picker

import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import trainingbuilder.muscle_picker.models.MuscleEnum
import trainingbuilder.muscle_picker.models.MuscleGroup
import trainingbuilder.muscle_picker.models.StatusEnum

@Immutable
internal data class State(
    val muscleGroups: ImmutableList<MuscleGroup> = persistentListOf(),
    val upperBodyList: ImmutableList<MuscleEnum> = persistentListOf(
        MuscleEnum.TRAPEZIUS,
        MuscleEnum.LATISSIMUS_DORSI,
        MuscleEnum.PECTORALIS_MAJOR,
        MuscleEnum.PECTORALIS_MINOR,
        MuscleEnum.POSTERIOR_DELTOID,
        MuscleEnum.ANTERIOR_DELTOID,
        MuscleEnum.LATERAL_DELTOID,
        MuscleEnum.FOREARM,
        MuscleEnum.TRICEPS,
        MuscleEnum.BICEPS
    ),
    val lowerBodyList: ImmutableList<MuscleEnum> = persistentListOf(
        MuscleEnum.RHOMBOIDS,
        MuscleEnum.RECTUS_ABDOMINIS,
        MuscleEnum.OBLIQUES,
        MuscleEnum.QUADRICEPS,
        MuscleEnum.HAMSTRINGS,
        MuscleEnum.CALF,
        MuscleEnum.GLUTEAL
    ),
    val includedMuscleStatuses: ImmutableList<StatusEnum> = persistentListOf(StatusEnum.MEDIUM, StatusEnum.LOW, StatusEnum.HIGH),
    val error: String? = null,
    val loading: Boolean = false
)