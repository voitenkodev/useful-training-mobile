package exerciseexamples.edit.mapping

import exerciseexamples.edit.state.Muscle
import exerciseexamples.edit.state.MuscleEnum
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.toPersistentList

internal fun List<models.Muscle>.toState(): PersistentList<Muscle> {
    return mapNotNull { it.toState() }
        .toPersistentList()
}

internal fun models.Muscle.toState(): Muscle? {
    return Muscle(
        name = name,
        id = id,
        isSelected = false,
        type = type.toState() ?: return null,
        percentage = 0
    )
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