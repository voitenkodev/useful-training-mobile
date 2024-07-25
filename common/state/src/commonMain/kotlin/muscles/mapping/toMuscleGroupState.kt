package muscles.mapping

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toPersistentList
import muscles.MuscleGroup
import muscles.MuscleGroupEnum
import muscles.MuscleStatusEnum
import muscles.factories.muscleImage

public fun List<models.MuscleGroup>.toState(includedMuscleStatuses: ImmutableList<MuscleStatusEnum>): ImmutableList<MuscleGroup> {
    return mapNotNull { it.toState(includedMuscleStatuses) }
        .toPersistentList()
}

public fun models.MuscleGroup.toState(includedMuscleStatuses: ImmutableList<MuscleStatusEnum>): MuscleGroup? {

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