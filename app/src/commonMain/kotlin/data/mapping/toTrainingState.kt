package data.mapping

import data.dto.Training
import presentation.state.TrainingState

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
            tonnage = it.tonnage ?: 0.0,
            countOfLifting = it.countOfLifting ?: 0,
            intensity = it.intensity ?: 0.0
        )
    },
    duration = duration ?: "",
    startDateTime = date ?: "",
    tonnage = tonnage,
    countOfLifting = countOfLifting,
    intensity = intensity
)

fun Double.toDoubleOrIntString(): String {
    return if (this.compareTo(this.toInt()) == 0) this.toInt().toString()
    else this.toString()
}