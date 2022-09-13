package training

import com.benasher44.uuid.uuid4
import dev.icerock.moko.parcelize.Parcelable
import dev.icerock.moko.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class TrainingState(
    val id: String,
    val exercises: List<Exercise>,
    val duration: String,
    val date: String,
    val userWeight: Double
) : Parcelable {

    val tonnage: Double
        get() = exercises.sumOf { it.tonnage }
    val countOfLifting: Int
        get() = exercises.sumOf { it.countOfLifting }
    val intensity: Double
        get() = tonnage / countOfLifting

    @Serializable
    @Parcelize
    data class Exercise(
        val id: String,
        val name: String,
        val iterations: List<Iteration>,
    ) : Parcelable {

        val tonnage
            get() = iterations
                .sumOf { (it.repeat.toIntOrNull() ?: 0) * (it.weight.toDoubleOrNull() ?: 0.0) }

        val countOfLifting: Int
            get() = iterations
                .mapNotNull { it.repeat.toIntOrNull() }
                .sum()

        val intensity
            get() = tonnage / countOfLifting

        @Serializable
        @Parcelize
        data class Iteration(
            val weight: String,
            val repeat: String
        ) : Parcelable {
            companion object {
                val EMPTY
                    get() = Iteration(weight = "", repeat = "")
            }
        }

        companion object {
            val EMPTY
                get() = Exercise(id = uuid4().toString(), name = "", iterations = listOf(Iteration.EMPTY))
        }
    }

    companion object {
        fun empty(userWeight: Double): TrainingState {
            return TrainingState(
                id = uuid4().toString(),
                exercises = emptyList(),
                duration = "",
                date = "",
                userWeight = userWeight
            )
        }
    }
}

fun List<TrainingState.Exercise.Iteration>.addEmptyIteration(): List<TrainingState.Exercise.Iteration> {
    val lastIsNotEmpty = this.lastOrNull()?.weight != "" || this.lastOrNull()?.repeat != ""
    return if (lastIsNotEmpty) this + TrainingState.Exercise.Iteration.EMPTY
    else this
}

fun List<TrainingState.Exercise.Iteration>.changeIterationByIndex(
    weight: String? = null,
    repeat: String? = null,
    index: Int
): List<TrainingState.Exercise.Iteration> {
    return this.mapIndexedNotNull { i, old ->
        val newWeight = if (i == index && weight != null) weight else old.weight
        val newRepeat = if (i == index && repeat != null) repeat else old.repeat
        val result = TrainingState.Exercise.Iteration(weight = newWeight, repeat = newRepeat)
        if (result != TrainingState.Exercise.Iteration.EMPTY) result else null
    }
}

fun TrainingState.removeExercise(exercise: TrainingState.Exercise): TrainingState {
    val newList = this.exercises.mapNotNull { old -> if (old.id == exercise.id) null else old }
    return this.copy(exercises = newList)
}

fun TrainingState.updateExercise(exercise: TrainingState.Exercise): TrainingState {
    val newList = this.exercises.map { old -> if (old.id == exercise.id) exercise else old }
    return this.copy(exercises = newList)
}

fun TrainingState.addExercise(): TrainingState {
    val newExercises = this.exercises + TrainingState.Exercise.EMPTY
    return this.copy(exercises = newExercises)
}

// TODO MOCK
val MOCK = TrainingState(
    id = "SOME_ID",
    exercises = listOf(
        TrainingState.Exercise(
            id = "idEx1",
            name = "Bench Press",
            iterations = listOf(
                TrainingState.Exercise.Iteration(
                    weight = "100.54",
                    repeat = "822"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "110",
                    repeat = "6"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "115",
                    repeat = "6"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "120",
                    repeat = "5"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "150",
                    repeat = "2"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "115",
                    repeat = "6"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "120",
                    repeat = "5"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "150",
                    repeat = "2"
                )
            )
        ),
        TrainingState.Exercise(
            id = "idEx2",
            name = "My New Exercise",
            iterations = listOf(
                TrainingState.Exercise.Iteration(
                    weight = "80",
                    repeat = "15"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "80",
                    repeat = "15"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "85",
                    repeat = "15"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "85",
                    repeat = "15"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "85",
                    repeat = "13"
                )
            )
        ),
        TrainingState.Exercise(
            id = "idEx3",
            name = "Bench Press",
            iterations = listOf(
                TrainingState.Exercise.Iteration(
                    weight = "100.5",
                    repeat = "8"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "110",
                    repeat = "6"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "115",
                    repeat = "6"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "120",
                    repeat = "5"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "150",
                    repeat = "2"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "115",
                    repeat = "6"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "120",
                    repeat = "5"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "150",
                    repeat = "2"
                )
            )
        ),
        TrainingState.Exercise(
            id = "idEx4",
            name = "Bench Press",
            iterations = listOf(
                TrainingState.Exercise.Iteration(
                    weight = "100.5",
                    repeat = "8"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "110",
                    repeat = "6"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "115",
                    repeat = "6"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "120",
                    repeat = "5"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "150",
                    repeat = "2"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "115",
                    repeat = "6"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "120",
                    repeat = "5"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "150",
                    repeat = "2"
                )
            )
        ),
        TrainingState.Exercise(
            id = "idEx5",
            name = "Super Hard Press",
            iterations = listOf(
                TrainingState.Exercise.Iteration(
                    weight = "100.5",
                    repeat = "8"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "110",
                    repeat = "6"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "115",
                    repeat = "6"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "120",
                    repeat = "5"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "150",
                    repeat = "2"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "115",
                    repeat = "6"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "120",
                    repeat = "5"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "115",
                    repeat = "6"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "120",
                    repeat = "5"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "115",
                    repeat = "6"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "120",
                    repeat = "5"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "150",
                    repeat = "2"
                )
            )
        ),
        TrainingState.Exercise(
            id = "idEx6",
            name = "Another Exercise",
            iterations = listOf(
                TrainingState.Exercise.Iteration(
                    weight = "100.5",
                    repeat = "8"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "110",
                    repeat = "6"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "115",
                    repeat = "6"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "120",
                    repeat = "5"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "150",
                    repeat = "2"
                ),
            )
        ),
        TrainingState.Exercise(
            id = "idEx7",
            name = "Some Other",
            iterations = listOf(
                TrainingState.Exercise.Iteration(
                    weight = "100.5",
                    repeat = "8"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "110",
                    repeat = "6"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "115",
                    repeat = "6"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "120",
                    repeat = "5"
                )
            )
        ),
    ),
    duration = "",
    date = "",
    userWeight = 0.0
)