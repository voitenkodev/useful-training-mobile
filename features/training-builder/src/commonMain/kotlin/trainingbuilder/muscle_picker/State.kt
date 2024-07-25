package trainingbuilder.muscle_picker

import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import muscles.MuscleEnum
import muscles.MuscleGroup
import muscles.MuscleStatusEnum

@Immutable
internal data class State(
    val muscleGroups: ImmutableList<MuscleGroup> = persistentListOf(),
    val upperBodyList: ImmutableList<MuscleEnum> = persistentListOf(
        MuscleEnum.TRAPEZIUS,
        MuscleEnum.LATISSIMUS_DORSI,
        MuscleEnum.TERES_MAJOR,
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
    val includedMuscleStatuses: ImmutableList<MuscleStatusEnum> = persistentListOf(
        MuscleStatusEnum.MEDIUM,
        MuscleStatusEnum.LOW,
        MuscleStatusEnum.HIGH
    ),
    val error: String? = null,
    val loading: Boolean = false
)