package trainingbuilder.mapping

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toPersistentList
import trainingbuilder.state.Muscle

internal fun List<models.Muscle>.toState(): ImmutableList<Muscle> {
    return mapNotNull { it.toState() }
        .toPersistentList()
}

internal fun models.Muscle.toState(): Muscle? {
    return Muscle(
        name = name,
        id = id,
        isSelected = false,
        type = type.toState() ?: return null
    )
}

internal fun models.MuscleEnum.toState(): trainingbuilder.state.MuscleEnum? {
    return when (this) {
        models.MuscleEnum.PECTORALIS_MAJOR -> trainingbuilder.state.MuscleEnum.PECTORALIS_MAJOR
        models.MuscleEnum.PECTORALIS_MINOR -> trainingbuilder.state.MuscleEnum.PECTORALIS_MINOR
        models.MuscleEnum.TRAPEZIUS -> trainingbuilder.state.MuscleEnum.TRAPEZIUS
        models.MuscleEnum.LATISSIMUS_DORSI -> trainingbuilder.state.MuscleEnum.LATISSIMUS_DORSI
        models.MuscleEnum.RHOMBOIDS -> trainingbuilder.state.MuscleEnum.RHOMBOIDS
        models.MuscleEnum.RECTUS_ABDOMINIS -> trainingbuilder.state.MuscleEnum.RECTUS_ABDOMINIS
        models.MuscleEnum.OBLIQUES -> trainingbuilder.state.MuscleEnum.OBLIQUES
        models.MuscleEnum.CALF -> trainingbuilder.state.MuscleEnum.CALF
        models.MuscleEnum.GLUTEAL -> trainingbuilder.state.MuscleEnum.GLUTEAL
        models.MuscleEnum.HAMSTRINGS -> trainingbuilder.state.MuscleEnum.HAMSTRINGS
        models.MuscleEnum.QUADRICEPS -> trainingbuilder.state.MuscleEnum.QUADRICEPS
        models.MuscleEnum.ANTERIOR_DELTOID -> trainingbuilder.state.MuscleEnum.ANTERIOR_DELTOID
        models.MuscleEnum.LATERAL_DELTOID -> trainingbuilder.state.MuscleEnum.LATERAL_DELTOID
        models.MuscleEnum.POSTERIOR_DELTOID -> trainingbuilder.state.MuscleEnum.POSTERIOR_DELTOID
        models.MuscleEnum.BICEPS -> trainingbuilder.state.MuscleEnum.BICEPS
        models.MuscleEnum.TRICEPS -> trainingbuilder.state.MuscleEnum.TRICEPS
        models.MuscleEnum.FOREARM -> trainingbuilder.state.MuscleEnum.FOREARM
        models.MuscleEnum.UNKNOWN -> null
    }
}