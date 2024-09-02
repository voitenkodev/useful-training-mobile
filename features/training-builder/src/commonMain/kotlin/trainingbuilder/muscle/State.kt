package trainingbuilder.muscle

import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import muscles.MuscleEnum
import muscles.MuscleGroup
import muscles.MuscleLoadEnum

@Immutable
internal data class State(
    val muscleGroups: ImmutableList<MuscleGroup> = persistentListOf(),
    val upperBodyList: ImmutableList<MuscleEnum> = persistentListOf(
        MuscleEnum.TRAPEZIUS,
        MuscleEnum.LATISSIMUS_DORSI,
        MuscleEnum.TERES_MAJOR,
        MuscleEnum.PECTORALIS_MAJOR_STERNOCOSTAL,
        MuscleEnum.PECTORALIS_MAJOR_CLAVICULAR,
        MuscleEnum.PECTORALIS_MAJOR_ABDOMINAL,
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
    val includedMuscleStatuses: ImmutableList<MuscleLoadEnum> = persistentListOf(
        MuscleLoadEnum.MEDIUM,
        MuscleLoadEnum.LOW,
        MuscleLoadEnum.HIGH
    ),
    val error: String? = null,
    val loading: Boolean = false
)