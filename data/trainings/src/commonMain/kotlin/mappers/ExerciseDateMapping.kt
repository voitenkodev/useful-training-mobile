package mappers

import models.ExerciseDate
import models.ExerciseDateDto

internal fun ExerciseDateDto.toDomain(): ExerciseDate {
    return ExerciseDate(
        trainingId = trainingId,
        exercise = exercise.toDomain(exercise.iterations.map { it.toDomain() }),
        date = date
    )
}