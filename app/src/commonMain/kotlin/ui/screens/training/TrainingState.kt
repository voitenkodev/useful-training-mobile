package ui.screens.training

import kotlinx.serialization.Serializable

@Serializable
data class TrainingState(
    val id: String,
    val exercises: List<Exercise>,
    val duration: String,
    val date: String,

    val tonnage: Double,
    val countOfLifting: Int,
    val intensity: Double,
) {

    @Serializable
    data class Exercise(
        val id: String,
        val name: String,
        val iterations: List<Iteration>,
    ) {
        @Serializable
        data class Iteration(
            val weight: String,
            val repeat: String
        ) {
            companion object {
                fun empty() = Iteration(weight = "", repeat = "")
            }
        }

        companion object {
            fun empty(id: String) = Exercise(id = id, name = "", iterations = listOf(Iteration.empty()))
        }
    }

    companion object {
        fun empty(id: String) = TrainingState(
            id = id,
            exercises = emptyList(),
            duration = "",
            date = "",
            tonnage = 0.0,
            countOfLifting = 0,
            intensity = 0.0,
        )
    }
}

fun List<TrainingState.Exercise.Iteration>.addEmptyIteration(): List<TrainingState.Exercise.Iteration> {
    val lastIsNotEmpty = this.lastOrNull()?.weight != "" || this.lastOrNull()?.repeat != ""
    return if (lastIsNotEmpty) this + TrainingState.Exercise.Iteration.empty()
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
        if (result != TrainingState.Exercise.Iteration.empty()) result else null
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

fun TrainingState.addExercise(id: String): TrainingState {
    val newExercises = this.exercises + TrainingState.Exercise.empty(id)
    return this.copy(exercises = newExercises)
}
