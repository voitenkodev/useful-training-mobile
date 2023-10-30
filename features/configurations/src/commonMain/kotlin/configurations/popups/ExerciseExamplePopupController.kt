package configurations.popups

import configurations.state.ExerciseExample
import configurations.state.Muscle
import configurations.state.MuscleExerciseBundle
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toImmutableList
import kotlinx.collections.immutable.toPersistentList

internal val SLIDER_RANGE = 0..100
internal const val MINIMAL_RANGE = 5

internal sealed class ExerciseExampleState(
    open val exerciseExample: ExerciseExample,
    open val allMuscles: ImmutableList<Muscle>,
) {
    data class CREATE(
        override val exerciseExample: ExerciseExample,
        override val allMuscles: ImmutableList<Muscle>
    ) : ExerciseExampleState(exerciseExample, allMuscles)

    data class UPDATE(
        override val exerciseExample: ExerciseExample,
        override val allMuscles: ImmutableList<Muscle>
    ) : ExerciseExampleState(exerciseExample, allMuscles)
}

internal fun ImmutableList<MuscleExerciseBundle>.addMuscle(
    muscle: Muscle,
    minimalRange: Int,
    maximalRange: Int,
): ImmutableList<MuscleExerciseBundle> {

    val newOne = MuscleExerciseBundle(
        muscle = muscle,
        value = if (this.isEmpty()) maximalRange else minimalRange
    )

    if (this.isEmpty()) return listOf(newOne).toPersistentList()

    val theMostBigItem = maxBy { it.value }

    return buildList {
        val list = this@addMuscle.map { item ->
            if (item == theMostBigItem) item.copy(value = item.value - minimalRange)
            else item
        }

        addAll(list)
        add(newOne)
    }.toPersistentList()
}

internal fun ImmutableList<MuscleExerciseBundle>.removeMuscleBundle(
    muscleExerciseBundle: MuscleExerciseBundle,
    maximalRange: Int,
): ImmutableList<MuscleExerciseBundle> {

    val newList = this
        .minus(muscleExerciseBundle)

    if (newList.isEmpty()) return persistentListOf()

    if (newList.size == 1) return newList
        .map { it.copy(value = maximalRange) }
        .toImmutableList()

    val theMostMinItem = newList.minBy { it.value }

    return buildList {
        val list = newList.map { item ->
            if (item == theMostMinItem) item.copy(value = item.value + muscleExerciseBundle.value)
            else item
        }

        addAll(list)
    }.toPersistentList()
}