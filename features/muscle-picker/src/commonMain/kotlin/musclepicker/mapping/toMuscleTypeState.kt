package musclepicker.mapping

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toPersistentList
import musclepicker.state.MuscleType

internal fun List<models.MuscleType>.toState(): ImmutableList<MuscleType> {
    return map { it.toState() }
        .toPersistentList()
}

internal fun models.MuscleType.toState(): MuscleType {
    return MuscleType(
        name = name,
        id = id,
        muscles = muscles.map { it.toState() },
        isSelected = false
    )
}