package usermuscles.main.mapping

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toPersistentList
import usermuscles.main.factories.muscleImage
import usermuscles.main.models.MuscleType
import usermuscles.main.models.MuscleTypeEnum

internal fun List<models.MuscleType>.toState(): ImmutableList<MuscleType> {
    return mapNotNull { it.toState() }
        .toPersistentList()
}

internal fun models.MuscleType.toState(): MuscleType? {

    val typeState = type.toState() ?: return null
    val muscleState = muscles.toState()

    return MuscleType(
        name = name,
        id = id,
        muscles = muscleState,
        type = typeState,
        bodyImageVector = muscleImage(typeState, muscleState)
    )
}

private fun models.MuscleTypeEnum.toState(): MuscleTypeEnum? {
    return when (this) {
        models.MuscleTypeEnum.CHEST_MUSCLES -> MuscleTypeEnum.CHEST_MUSCLES
        models.MuscleTypeEnum.BACK_MUSCLES -> MuscleTypeEnum.BACK_MUSCLES
        models.MuscleTypeEnum.ABDOMINAL_MUSCLES -> MuscleTypeEnum.ABDOMINAL_MUSCLES
        models.MuscleTypeEnum.LEGS -> MuscleTypeEnum.LEGS
        models.MuscleTypeEnum.ARMS_AND_FOREARMS -> MuscleTypeEnum.ARMS_AND_FOREARMS
        models.MuscleTypeEnum.SHOULDER_MUSCLES -> MuscleTypeEnum.SHOULDER_MUSCLES
        models.MuscleTypeEnum.UNKNOWN -> null
    }
}