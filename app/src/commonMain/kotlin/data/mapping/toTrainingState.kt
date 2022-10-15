package data.mapping

import presentation.training.Training

fun List<data.dto.Training?>.toTrainingStateList() = this.mapNotNull { it?.toTrainingState() }

fun data.dto.Training.toTrainingState() = presentation.training.Training(
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