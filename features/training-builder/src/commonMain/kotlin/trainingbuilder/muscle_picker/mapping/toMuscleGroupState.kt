package trainingbuilder.muscle_picker.mapping

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toPersistentList
import trainingbuilder.muscle_picker.factories.muscleImage
import trainingbuilder.muscle_picker.models.MuscleGroup
import trainingbuilder.muscle_picker.models.MuscleGroupEnum
import trainingbuilder.muscle_picker.models.StatusEnum

internal fun List<models.MuscleGroup>.toState(includedMuscleStatuses: ImmutableList<StatusEnum>): ImmutableList<MuscleGroup> {
    return mapNotNull { it.toState(includedMuscleStatuses) }
        .toPersistentList()
}

internal fun models.MuscleGroup.toState(includedMuscleStatuses: ImmutableList<StatusEnum>): MuscleGroup? {

    val typeState = type.toState() ?: return null
    val muscleState = muscles.toState()

    return MuscleGroup(
        name = name,
        id = id,
        muscles = muscleState,
        isSelected = false,
        type = typeState,
        bodyImageVector = muscleImage(typeState, muscleState, includedMuscleStatuses)
    )
}

private fun models.MuscleGroupEnum.toState(): MuscleGroupEnum? {
    return when (this) {
        models.MuscleGroupEnum.CHEST_MUSCLES -> MuscleGroupEnum.CHEST_MUSCLES
        models.MuscleGroupEnum.BACK_MUSCLES -> MuscleGroupEnum.BACK_MUSCLES
        models.MuscleGroupEnum.ABDOMINAL_MUSCLES -> MuscleGroupEnum.ABDOMINAL_MUSCLES
        models.MuscleGroupEnum.LEGS -> MuscleGroupEnum.LEGS
        models.MuscleGroupEnum.ARMS_AND_FOREARMS -> MuscleGroupEnum.ARMS_AND_FOREARMS
        models.MuscleGroupEnum.SHOULDER_MUSCLES -> MuscleGroupEnum.SHOULDER_MUSCLES
        models.MuscleGroupEnum.UNKNOWN -> null
    }
}