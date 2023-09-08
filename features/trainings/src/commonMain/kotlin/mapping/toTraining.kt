package mapping

import dto.ExerciseDTO
import dto.IterationDTO
import dto.TrainingDTO
import training.Training

internal fun Training.toBody() = TrainingDTO(
    id = id,
    exercises = exercises.map {
        ExerciseDTO(
            id = null,
            name = it.name,
            iterations = it.iterations.map {
                IterationDTO(
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