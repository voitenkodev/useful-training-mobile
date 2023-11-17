package trainingbuilder.mapping

import models.MuscleEnum
import trainingbuilder.state.MuscleEnumState

internal fun MuscleEnum.toState(): MuscleEnumState? {
    return when (this) {
        MuscleEnum.PECTORALIS_MAJOR -> MuscleEnumState.PECTORALIS_MAJOR
        MuscleEnum.PECTORALIS_MINOR -> MuscleEnumState.PECTORALIS_MINOR
        MuscleEnum.TRAPEZIUS -> MuscleEnumState.TRAPEZIUS
        MuscleEnum.LATISSIMUS_DORSI -> MuscleEnumState.LATISSIMUS_DORSI
        MuscleEnum.RHOMBOIDS -> MuscleEnumState.RHOMBOIDS
        MuscleEnum.RECTUS_ABDOMINIS -> MuscleEnumState.RECTUS_ABDOMINIS
        MuscleEnum.OBLIQUES -> MuscleEnumState.OBLIQUES
        MuscleEnum.CALF -> MuscleEnumState.CALF
        MuscleEnum.GLUTEAL -> MuscleEnumState.GLUTEAL
        MuscleEnum.HAMSTRINGS -> MuscleEnumState.HAMSTRINGS
        MuscleEnum.QUADRICEPS -> MuscleEnumState.QUADRICEPS
        MuscleEnum.ANTERIOR_DELTOID -> MuscleEnumState.ANTERIOR_DELTOID
        MuscleEnum.LATERAL_DELTOID -> MuscleEnumState.LATERAL_DELTOID
        MuscleEnum.POSTERIOR_DELTOID -> MuscleEnumState.POSTERIOR_DELTOID
        MuscleEnum.BICEPS -> MuscleEnumState.BICEPS
        MuscleEnum.TRICEPS -> MuscleEnumState.TRICEPS
        MuscleEnum.FOREARM -> MuscleEnumState.FOREARM
        MuscleEnum.UNKNOWN -> null
    }
}