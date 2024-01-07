package authentication.register.mapping

import authentication.register.factories.muscleImage
import authentication.register.models.MuscleGroup
import authentication.register.models.MuscleGroupEnum
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toPersistentList

internal fun List<models.MuscleGroup>.toState(): ImmutableList<MuscleGroup> {
    return mapNotNull { it.toState() }
        .toPersistentList()
}

internal fun models.MuscleGroup.toState(): MuscleGroup? {

    val typeState = type.toState() ?: return null
    val muscleState = muscles.toState()

    return MuscleGroup(
        name = name,
        id = id,
        muscles = muscleState,
        type = typeState,
        bodyImageVector = muscleImage(typeState, muscleState)
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