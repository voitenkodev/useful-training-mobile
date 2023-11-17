package trainingbuilder.mapping

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toPersistentList
import trainingbuilder.factory.muscleImage
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
        type = typeState,
        imageVector = muscleImage(typeState, muscleState)
    )
}