package data.mapping

import data.dto.TrainingBody
import presentation.training.Training

internal fun List<TrainingBody?>.toTrainingStateList() = this.mapNotNull { it?.toTrainingState() }

internal fun TrainingBody.toTrainingState() = Training(
    id = id.toString(),
    exercises = exercises.map {
        Training.Exercise(
            id = it.id ?: "",
            name = it.name ?: "",
            iterations = it.iterations.map {
                Training.Exercise.Iteration(
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

private fun Double.toDoubleOrIntString(): String {
    return if (this.compareTo(this.toInt()) == 0) this.toInt().toString()
    else this.toString()
}