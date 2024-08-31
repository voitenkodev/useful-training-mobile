package muscles.mapping

import IncludedStatusEnum
import models.Muscle
import models.MuscleLoadEnum
import models.MuscleStatusEnum
import muscles.Coverage
import muscles.MuscleEnum

public fun Muscle.toState(
    isSelected: Boolean,
    coverage: Coverage? = null
): muscles.Muscle? {

    return muscles.Muscle(
        name = name,
        id = id,
        isSelected = isSelected,
        load = load.toState(),
        status = status.toState(),
        type = type.toState() ?: return null,
        coverage = coverage
    )
}

private fun MuscleStatusEnum.toState(): IncludedStatusEnum? {
    return when (this) {
        MuscleStatusEnum.EXCLUDED -> IncludedStatusEnum.EXCLUDED
        MuscleStatusEnum.UNKNOWN -> null
        else -> IncludedStatusEnum.INCLUDED
    }
}

public fun MuscleLoadEnum.toState(): muscles.MuscleLoadEnum? {
    return when (this) {
        MuscleLoadEnum.HIGH -> muscles.MuscleLoadEnum.HIGH
        MuscleLoadEnum.MEDIUM -> muscles.MuscleLoadEnum.MEDIUM
        MuscleLoadEnum.LOW -> muscles.MuscleLoadEnum.LOW
        else -> null
    }
}

public fun models.MuscleEnum.toState(): MuscleEnum? {
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
        models.MuscleEnum.ADDUCTORS -> MuscleEnum.ADDUCTORS
        models.MuscleEnum.ABDUCTORS -> MuscleEnum.ABDUCTORS
        models.MuscleEnum.UNKNOWN -> null
    }
}