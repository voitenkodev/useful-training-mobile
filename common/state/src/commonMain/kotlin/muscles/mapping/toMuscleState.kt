package muscles.mapping

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toPersistentList
import models.Muscle
import models.MuscleStatusEnum
import muscles.MuscleEnum

public fun List<Muscle>.toState(): ImmutableList<muscles.Muscle> {
    return mapNotNull { it.toState() }
        .sortedBy { it.status }
        .toPersistentList()
}

public fun Muscle.toState(): muscles.Muscle? {
    return muscles.Muscle(
        name = name,
        id = id,
        isSelected = false,
        status = status.toState() ?: return null,
        type = type.toState() ?: return null
    )
}

private fun MuscleStatusEnum.toState(): muscles.MuscleStatusEnum? {
    return when (this) {
        MuscleStatusEnum.HIGH -> muscles.MuscleStatusEnum.HIGH
        MuscleStatusEnum.MEDIUM -> muscles.MuscleStatusEnum.MEDIUM
        MuscleStatusEnum.LOW -> muscles.MuscleStatusEnum.LOW
        MuscleStatusEnum.EXCLUDED -> muscles.MuscleStatusEnum.EXCLUDED
        else -> null
    }
}

private fun models.MuscleEnum.toState(): MuscleEnum? {
    return when (this) {
        models.MuscleEnum.PECTORALIS_MAJOR -> MuscleEnum.PECTORALIS_MAJOR
        models.MuscleEnum.PECTORALIS_MINOR -> MuscleEnum.PECTORALIS_MINOR
        models.MuscleEnum.TRAPEZIUS -> MuscleEnum.TRAPEZIUS
        models.MuscleEnum.LATISSIMUS_DORSI -> MuscleEnum.LATISSIMUS_DORSI
        models.MuscleEnum.RHOMBOIDS -> MuscleEnum.RHOMBOIDS
        models.MuscleEnum.RECTUS_ABDOMINIS -> MuscleEnum.RECTUS_ABDOMINIS
        models.MuscleEnum.OBLIQUES -> MuscleEnum.OBLIQUES
        models.MuscleEnum.TERES_MAJOR -> MuscleEnum.TERES_MAJOR
        models.MuscleEnum.CALF -> MuscleEnum.CALF
        models.MuscleEnum.GLUTEAL -> MuscleEnum.GLUTEAL
        models.MuscleEnum.HAMSTRINGS -> MuscleEnum.HAMSTRINGS
        models.MuscleEnum.QUADRICEPS -> MuscleEnum.QUADRICEPS
        models.MuscleEnum.ANTERIOR_DELTOID -> MuscleEnum.ANTERIOR_DELTOID
        models.MuscleEnum.LATERAL_DELTOID -> MuscleEnum.LATERAL_DELTOID
        models.MuscleEnum.POSTERIOR_DELTOID -> MuscleEnum.POSTERIOR_DELTOID
        models.MuscleEnum.BICEPS -> MuscleEnum.BICEPS
        models.MuscleEnum.TRICEPS -> MuscleEnum.TRICEPS
        models.MuscleEnum.FOREARM -> MuscleEnum.FOREARM
        models.MuscleEnum.UNKNOWN -> null
    }
}