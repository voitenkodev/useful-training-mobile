package trainingbuilder.mapping

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toPersistentList
import trainingbuilder.state.MuscleType

internal fun List<models.MuscleType>.toState(): ImmutableList<MuscleType> {
    return mapNotNull { it.toState() }
        .toPersistentList()
}

internal fun models.MuscleType.toState(): MuscleType? {

    val typeState = type.toState() ?: return null
    val muscleState = muscles.mapNotNull { it.toState() }

    return MuscleType(
        name = name,
        id = id,
        muscles = muscleState,
        isSelected = false,
        type = typeState
    )
}

internal fun models.MuscleTypeEnum.toState(): trainingbuilder.state.MuscleTypeEnum? {
    return when (this) {
        models.MuscleTypeEnum.CHEST_MUSCLES -> trainingbuilder.state.MuscleTypeEnum.CHEST_MUSCLES
        models.MuscleTypeEnum.BACK_MUSCLES -> trainingbuilder.state.MuscleTypeEnum.BACK_MUSCLES
        models.MuscleTypeEnum.ABDOMINAL_MUSCLES -> trainingbuilder.state.MuscleTypeEnum.ABDOMINAL_MUSCLES
        models.MuscleTypeEnum.LEGS -> trainingbuilder.state.MuscleTypeEnum.LEGS
        models.MuscleTypeEnum.ARMS_AND_FOREARMS -> trainingbuilder.state.MuscleTypeEnum.ARMS_AND_FOREARMS
        models.MuscleTypeEnum.SHOULDER_MUSCLES -> trainingbuilder.state.MuscleTypeEnum.SHOULDER_MUSCLES
        models.MuscleTypeEnum.UNKNOWN -> null
    }
}