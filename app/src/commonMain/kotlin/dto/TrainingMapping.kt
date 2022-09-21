package dto

import state.TrainingState

fun TrainingState.map() = Training(
    id = id,
    exercises = exercises.map {
        Training.Exercise(
            id = it.id,
            name = it.name,
            iterations = it.iterations
                .map {
                    Training.Exercise.Iteration(
                        weight = it.weight.toDoubleOrNull(),
                        repeat = it.repeat.toIntOrNull()
                    )
                }.filterNot { it.repeat == null || it.weight == null },
            tonnage = it.tonnage,
            countOfLifting = it.countOfLifting,
            intensity = it.intensity
        )
    },
    duration = duration,
    date = date,
    tonnage = tonnage,
    countOfLifting = countOfLifting,
    intensity = intensity,
)