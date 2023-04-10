package data.mapping

import data.dto.ExerciseDTO
import data.dto.IterationDTO
import data.dto.TrainingDTO
import presentation.training.Training

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