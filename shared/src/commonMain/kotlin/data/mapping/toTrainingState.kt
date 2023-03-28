package data.mapping

import data.dto.TrainingDTO
import presentation.training.Exercise
import presentation.training.Iteration
import presentation.training.Training

internal fun List<TrainingDTO?>.toTrainingStateList() = this.mapNotNull { it?.toTrainingState() }

internal fun TrainingDTO.toTrainingState() = Training(
    id = id.toString(),
    exercises = exercises.map {
        Exercise(
            id = it.id ?: "",
            name = it.name ?: "",
            iterations = it.iterations.map {
                Iteration(
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