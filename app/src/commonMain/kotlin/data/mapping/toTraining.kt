package data.mapping

fun presentation.training.Training.toTraining() = data.dto.Training(
    id = id,
    exercises = exercises.map {
        data.dto.Training.Exercise(
            id = it.id,
            name = it.name,
            iterations = it.iterations.map {
                data.dto.Training.Exercise.Iteration(
                    weight = it.weight.toDoubleOrNull(),
                    repeat = it.repeat.toIntOrNull()
                )
            },
            tonnage = it.tonnage,
            countOfLifting = it.countOfLifting,
            intensity = it.intensity
        )
    },
    duration = duration,
    date = startDateTime,
    tonnage = tonnage,
    countOfLifting = countOfLifting,
    intensity = intensity,
)