package exerciseexamples.edit.mapping

import exerciseexamples.edit.state.Muscle
import exerciseexamples.edit.state.MuscleEnum
import models.StatusEnum

internal fun Muscle.toDomain(): models.Muscle {
    return models.Muscle(
        name = name,
        id = id,
        type = type.toDomain(),
        status = StatusEnum.UNKNOWN, // doesn't make sense for body
    )
}

private fun MuscleEnum?.toDomain(): models.MuscleEnum {
    return when (this) {
        MuscleEnum.PECTORALIS_MAJOR -> models.MuscleEnum.PECTORALIS_MAJOR
        MuscleEnum.PECTORALIS_MINOR -> models.MuscleEnum.PECTORALIS_MINOR
        MuscleEnum.TRAPEZIUS -> models.MuscleEnum.TRAPEZIUS
        MuscleEnum.LATISSIMUS_DORSI -> models.MuscleEnum.LATISSIMUS_DORSI
        MuscleEnum.RHOMBOIDS -> models.MuscleEnum.RHOMBOIDS
        MuscleEnum.RECTUS_ABDOMINIS -> models.MuscleEnum.RECTUS_ABDOMINIS
        MuscleEnum.OBLIQUES -> models.MuscleEnum.OBLIQUES
        MuscleEnum.CALF -> models.MuscleEnum.CALF
        MuscleEnum.GLUTEAL -> models.MuscleEnum.GLUTEAL
        MuscleEnum.HAMSTRINGS -> models.MuscleEnum.HAMSTRINGS
        MuscleEnum.QUADRICEPS -> models.MuscleEnum.QUADRICEPS
        MuscleEnum.ANTERIOR_DELTOID -> models.MuscleEnum.ANTERIOR_DELTOID
        MuscleEnum.LATERAL_DELTOID -> models.MuscleEnum.LATERAL_DELTOID
        MuscleEnum.POSTERIOR_DELTOID -> models.MuscleEnum.POSTERIOR_DELTOID
        MuscleEnum.BICEPS -> models.MuscleEnum.BICEPS
        MuscleEnum.TRICEPS -> models.MuscleEnum.TRICEPS
        MuscleEnum.FOREARM -> models.MuscleEnum.FOREARM
        null -> models.MuscleEnum.UNKNOWN
    }
}