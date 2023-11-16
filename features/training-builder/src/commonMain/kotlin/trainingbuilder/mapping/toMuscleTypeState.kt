package trainingbuilder.mapping

import atom.Design
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toPersistentList
import musclepickerpicker.bodyBack
import musclepickerpicker.bodyFront
import musclepickerpicker.bodySplit
import musclepickerpicker.legsSplit
import trainingbuilder.state.MuscleType

internal fun List<models.MuscleType>.toState(): ImmutableList<MuscleType> {
    return map { it.toState() }
        .toPersistentList()
}

internal fun models.MuscleType.toState(): MuscleType {
    return MuscleType(
        name = name,
        id = id,
        muscles = muscles.map { it.toState() },
        isSelected = false,
        imageVector = when (name) {
            "Chest Muscles" -> bodyFront(
                pectoralisMinor = Design.palette.orange,
                pectoralisMajor = Design.palette.orange
            )

            "Back Muscles" -> bodyBack(
                trapezius = Design.palette.orange,
                latissimus = Design.palette.orange,
                rhomboids = Design.palette.orange
            )

            "Abdominal Muscles" -> bodyFront(
                rectusAbdominis = Design.palette.orange,
                obliquesAbdominis = Design.palette.orange
            )

            "Legs" -> legsSplit(
                quadriceps = Design.palette.orange,
                hamstrings = Design.palette.orange,
                calf = Design.palette.orange,
                gluteal = Design.palette.orange
            )

            "Arms and Forearms" -> bodySplit(
                biceps = Design.palette.orange,
                triceps = Design.palette.orange,
                forearm = Design.palette.orange
            )

            "Shoulder Muscles" -> bodySplit(
                posteriorDeltoid = Design.palette.orange,
                anteriorDeltoid = Design.palette.orange,
                lateralDeltoid = Design.palette.orange
            )

            else -> bodySplit()
        }
    )
}