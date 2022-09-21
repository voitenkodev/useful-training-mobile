package state

import com.benasher44.uuid.uuid4
import dev.icerock.moko.parcelize.Parcelable
import dev.icerock.moko.parcelize.Parcelize
import kotlinx.datetime.DayOfWeek
import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class TrainingState(
    val id: String,
    val exercises: List<Exercise>,
    val duration: String,
    val date: String,
    val userWeight: Double,
) : Parcelable {

    val weekDay: DayOfWeek
        get() = DayOfWeek.FRIDAY
//        get() = LocalDateTime.parse(date).dayOfWeek
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
                exercises = listOf(Exercise.EMPTY),
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
val MOCK_1 = TrainingState(
    id = "SOME_ID_1",
    exercises = listOf(
        TrainingState.Exercise(
            id = "idEx1",
            name = "Жим Лежа",
            iterations = listOf(
                TrainingState.Exercise.Iteration(
                    weight = "105",
                    repeat = "5"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "105",
                    repeat = "5"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "105",
                    repeat = "5"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "105",
                    repeat = "5"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "105",
                    repeat = "5"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "105",
                    repeat = "5"
                ),
            )
        ),
        TrainingState.Exercise(
            id = "idEx2",
            name = "Жим 45 в смитте",
            iterations = listOf(
                TrainingState.Exercise.Iteration(
                    weight = "60",
                    repeat = "10"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "60",
                    repeat = "10"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "60",
                    repeat = "10"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "60",
                    repeat = "10"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "60",
                    repeat = "10"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "60",
                    repeat = "10"
                ),
            )
        ),
        TrainingState.Exercise(
            id = "idEx3",
            name = "Бабочка с паузой",
            iterations = listOf(
                TrainingState.Exercise.Iteration(
                    weight = "50",
                    repeat = "15"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "50",
                    repeat = "15"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "50",
                    repeat = "15"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "50",
                    repeat = "15"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "50",
                    repeat = "15"
                ),
            )
        ),
        TrainingState.Exercise(
            id = "idEx4",
            name = "Бабочка силовая",
            iterations = listOf(
                TrainingState.Exercise.Iteration(
                    weight = "70",
                    repeat = "15"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "70",
                    repeat = "15"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "70",
                    repeat = "15"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "70",
                    repeat = "15"
                ),
            )
        ),
        TrainingState.Exercise(
            id = "idEx5",
            name = "Скручивание",
            iterations = listOf(
                TrainingState.Exercise.Iteration(
                    weight = "40",
                    repeat = "25"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "40",
                    repeat = "25"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "40",
                    repeat = "25"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "40",
                    repeat = "25"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "40",
                    repeat = "25"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "40",
                    repeat = "25"
                ),
            )
        ),
        TrainingState.Exercise(
            id = "idEx6",
            name = "Тяга кора сбоку",
            iterations = listOf(
                TrainingState.Exercise.Iteration(
                    weight = "25",
                    repeat = "20"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "25",
                    repeat = "20"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "25",
                    repeat = "20"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "25",
                    repeat = "20"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "25",
                    repeat = "20"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "25",
                    repeat = "20"
                ),
            )
        )
    ),
    duration = "",
    date = "2000-10-31T01:30:00.000-05:00",
    userWeight = 0.0
)

val MOCK_2 = TrainingState(
    id = "SOME_ID_2",
    exercises = listOf(
        TrainingState.Exercise(
            id = "idEx0",
            name = "Жим Узким",
            iterations = listOf(
                TrainingState.Exercise.Iteration(
                    weight = "75",
                    repeat = "10"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "75",
                    repeat = "10"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "75",
                    repeat = "10"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "75",
                    repeat = "10"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "75",
                    repeat = "10"
                ),
            )
        ),
        TrainingState.Exercise(
            id = "idEx1",
            name = "Подъем на бицепс широким хватом",
            iterations = listOf(
                TrainingState.Exercise.Iteration(
                    weight = "40",
                    repeat = "10"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "40",
                    repeat = "10"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "40",
                    repeat = "10"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "45",
                    repeat = "10"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "45",
                    repeat = "10"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "45",
                    repeat = "10"
                ),
            )
        ),
        TrainingState.Exercise(
            id = "idEx2",
            name = "Подъем на бицепс на скамье Скотта узким",
            iterations = listOf(
                TrainingState.Exercise.Iteration(
                    weight = "40",
                    repeat = "10"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "40",
                    repeat = "10"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "40",
                    repeat = "10"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "40",
                    repeat = "10"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "40",
                    repeat = "10"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "40",
                    repeat = "10"
                ),
            )
        ),
        TrainingState.Exercise(
            id = "idEx3",
            name = "Молотки гантелями",
            iterations = listOf(
                TrainingState.Exercise.Iteration(
                    weight = "18",
                    repeat = "20"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "18",
                    repeat = "20"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "18",
                    repeat = "20"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "18",
                    repeat = "20"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "18",
                    repeat = "20"
                ),
            )
        ),
        TrainingState.Exercise(
            id = "idEx4",
            name = "Подьем штанги на предплечья",
            iterations = listOf(
                TrainingState.Exercise.Iteration(
                    weight = "20",
                    repeat = "15"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "15",
                    repeat = "18"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "20",
                    repeat = "10"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "20",
                    repeat = "10"
                ),
            )
        ),
        TrainingState.Exercise(
            id = "idEx5",
            name = "Тяга вертикального блока на трицепс",
            iterations = listOf(
                TrainingState.Exercise.Iteration(
                    weight = "55",
                    repeat = "15"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "55",
                    repeat = "15"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "55",
                    repeat = "15"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "55",
                    repeat = "15"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "55",
                    repeat = "15"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "55",
                    repeat = "15"
                ),
            )
        ),

        ),
    duration = "",
    date = "2000-10-31T01:30:00.000-05:00",
    userWeight = 0.0
)

val MOCK_3 = TrainingState(
    id = "SOME_ID_3",
    exercises = listOf(
        TrainingState.Exercise(
            id = "idEx0",
            name = "Становая тяга на прямых",
            iterations = listOf(
                TrainingState.Exercise.Iteration(
                    weight = "100",
                    repeat = "10"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "100",
                    repeat = "10"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "100",
                    repeat = "10"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "100",
                    repeat = "10"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "100",
                    repeat = "10"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "100",
                    repeat = "10"
                ),
            )
        ),
        TrainingState.Exercise(
            id = "idEx1",
            name = "Тяга вертикального блока на спину широким",
            iterations = listOf(
                TrainingState.Exercise.Iteration(
                    weight = "55",
                    repeat = "10"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "55",
                    repeat = "10"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "55",
                    repeat = "10"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "55",
                    repeat = "10"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "55",
                    repeat = "10"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "55",
                    repeat = "10"
                ),
            )
        ),
        TrainingState.Exercise(
            id = "idEx2",
            name = "Тяга горизонтального блока на спину узким",
            iterations = listOf(
                TrainingState.Exercise.Iteration(
                    weight = "60",
                    repeat = "10"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "60",
                    repeat = "10"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "60",
                    repeat = "10"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "60",
                    repeat = "10"
                ),
            )
        ),
        TrainingState.Exercise(
            id = "idEx3",
            name = "Тяга горизонтального блока на спину широким",
            iterations = listOf(
                TrainingState.Exercise.Iteration(
                    weight = "55",
                    repeat = "20"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "18",
                    repeat = "20"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "18",
                    repeat = "20"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "18",
                    repeat = "20"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "18",
                    repeat = "20"
                ),
            )
        ),
        TrainingState.Exercise(
            id = "idEx4",
            name = "Шраги штангой",
            iterations = listOf(
                TrainingState.Exercise.Iteration(
                    weight = "45",
                    repeat = "15"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "45",
                    repeat = "15"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "45",
                    repeat = "15"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "45",
                    repeat = "15"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "45",
                    repeat = "15"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "45",
                    repeat = "15"
                ),
            )
        ),
        TrainingState.Exercise(
            id = "idEx5",
            name = "Скручивание",
            iterations = listOf(
                TrainingState.Exercise.Iteration(
                    weight = "39.9",
                    repeat = "25"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "39.9",
                    repeat = "25"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "39.9",
                    repeat = "25"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "39.9",
                    repeat = "25"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "39.9",
                    repeat = "25"
                ),
                TrainingState.Exercise.Iteration(
                    weight = "39.9",
                    repeat = "25"
                ),
            )
        ),

        ),
    duration = "",
    date = "2000-10-31T01:30:00.000-05:00",
    userWeight = 0.0
)