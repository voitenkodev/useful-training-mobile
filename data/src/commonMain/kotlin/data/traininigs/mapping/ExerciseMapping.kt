package data.traininigs.mapping

import data.exerciseexamples.repository.mapping.daoToDomain
import data.exerciseexamples.repository.mapping.dtoToDao
import models.Exercise
import models.ExerciseDto
import models.Iteration
import models.IterationDto
import traininig_exercise_iteration.models.ExerciseDao
import traininig_exercise_iteration.models.IterationDao

internal fun ExerciseDao.toDomain(iterations: List<Iteration>): Exercise {
    return Exercise(
        id = id,
        name = name,
        volume = volume,
        repetitions = repetitions,
        intensity = intensity,
        iterations = iterations,
        exerciseExample = exerciseExample?.daoToDomain()
    )
}

internal fun Exercise.dtoToDto(iterations: List<IterationDto>): ExerciseDto {
    return ExerciseDto(
        id = id,
        name = name,
        volume = volume,
        repetitions = repetitions,
        intensity = intensity,
        iterations = iterations,
        exerciseExampleId = exerciseExample?.id
    )
}

internal fun ExerciseDto.dtoToDao(iterations: List<IterationDao>): ExerciseDao? {
    return ExerciseDao(
        id = id ?: return null,
        name = name ?: return null,
        volume = volume ?: return null,
        repetitions = repetitions ?: return null,
        intensity = intensity ?: return null,
        iterations = iterations,
        updatedAt = updatedAt ?: return null,
        createdAt = createdAt ?: return null,
        trainingId = trainingId ?: return null,
        exerciseExampleId = exerciseExampleId,
        exerciseExample = exerciseExample?.dtoToDao()
    )
}