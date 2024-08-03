package muscles.mapping

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toPersistentList
import models.Muscle
import muscles.MuscleGroup
import muscles.MuscleGroupEnum
import muscles.MuscleLoadEnum
import muscles.factories.muscleImage

public fun List<models.MuscleGroup>.toState(
    load: ImmutableList<MuscleLoadEnum>? = null,
    eachMuscle: (Muscle) -> muscles.Muscle? = {
        it.toState(isSelected = false)
    },
    eachMuscleGroup: (models.MuscleGroup) -> MuscleGroup? = {
        it.toState(isSelected = false, load = load, eachMuscle = eachMuscle)
    },
): ImmutableList<MuscleGroup> {
    return mapNotNull(eachMuscleGroup)
        .toPersistentList()
}

public fun models.MuscleGroup.toState(
    isSelected: Boolean = false,
    load: ImmutableList<MuscleLoadEnum>?,
    eachMuscle: (Muscle) -> muscles.Muscle? = { it.toState(false) },
): MuscleGroup? {

    val typeState = type
        .toState() ?: return null

    val muscleState = muscles
        .mapNotNull(eachMuscle)
        .toPersistentList()

    return MuscleGroup(
        name = name,
        id = id,
        muscles = muscleState,
        isSelected = isSelected,
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