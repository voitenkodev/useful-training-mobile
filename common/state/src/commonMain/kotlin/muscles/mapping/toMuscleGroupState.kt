package muscles.mapping

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toPersistentList
import muscles.MuscleGroup
import muscles.MuscleGroupEnum
import muscles.MuscleLoadEnum
import muscles.factories.muscleImage

public fun List<models.MuscleGroup>.toState(
    muscleLoad: ImmutableList<MuscleLoadEnum>? = null,
    defaultMuscleGroupSelection: Boolean = false,
    defaultMuscleSelection: Boolean = false
): ImmutableList<MuscleGroup> {
    return mapNotNull {
        it.toState(
            muscleLoad,
            defaultMuscleGroupSelection,
            defaultMuscleSelection
        )
    }.toPersistentList()
}

public fun models.MuscleGroup.toState(
    load: ImmutableList<MuscleLoadEnum>?,
    defaultMuscleGroupSelection: Boolean,
    defaultMuscleSelection: Boolean
): MuscleGroup? {

    val typeState = type.toState() ?: return null
    val muscleState = muscles.toState(defaultMuscleSelection)

    return MuscleGroup(
        name = name,
        id = id,
        muscles = muscleState,
        isSelected = defaultMuscleGroupSelection,
        type = typeState,
        bodyImageVector = muscleImage(typeState, muscleState, load)
    )
}

public fun models.MuscleGroupEnum.toState(): MuscleGroupEnum? {
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