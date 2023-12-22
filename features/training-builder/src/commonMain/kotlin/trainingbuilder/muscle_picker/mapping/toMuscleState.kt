package trainingbuilder.muscle_picker.mapping

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toPersistentList
import models.PriorityEnum
import trainingbuilder.muscle_picker.models.Muscle
import trainingbuilder.muscle_picker.models.MuscleEnum

internal fun List<models.Muscle>.toState(): ImmutableList<Muscle> {
    return mapNotNull { it.toState() }
        .toPersistentList()
}

internal fun models.Muscle.toState(): Muscle? {
    return Muscle(
        name = name,
        id = id,
        isSelected = false,
        priority = priority.toState(),
        type = type.toState() ?: return null
    )
}

private fun PriorityEnum.toState(): trainingbuilder.muscle_picker.models.PriorityEnum {
    return when (this) {
        PriorityEnum.High -> trainingbuilder.muscle_picker.models.PriorityEnum.High()
        PriorityEnum.Medium -> trainingbuilder.muscle_picker.models.PriorityEnum.Medium()
        PriorityEnum.Low -> trainingbuilder.muscle_picker.models.PriorityEnum.Low()
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