package mapping

import dto.Training
import state.TrainingState

fun List<Training?>.toTrainingStateList() = this.mapNotNull { it?.toTrainingState() }

fun Training.toTrainingState() = TrainingState(
    id = id.toString(),
    exercises = exercises.map {
        TrainingState.Exercise(
            id = it.id ?: "",
            name = it.name ?: "",
            iterations = it.iterations.map {
                TrainingState.Exercise.Iteration(
                    weight = it.weight?.toDoubleOrIntString() ?: "",
                    repeat = it.repeat?.toString() ?: ""
                )
            },
        )
    },
    duration = duration ?: "",
    startDateTime = date ?: "",
)

fun Double.toDoubleOrIntString(): String {
    return if (this.compareTo(this.toInt()) == 0) this.toInt().toString()
    else this.toString()
}
