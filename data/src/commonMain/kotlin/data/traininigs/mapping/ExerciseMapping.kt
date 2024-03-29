package data.traininigs.mapping

import data.exerciseexamples.mapping.daoToDomain
import data.exerciseexamples.mapping.domainToDto
import data.exerciseexamples.mapping.dtoToDao
import models.Exercise
import models.Iteration
import network.models.ExerciseDto
import network.models.IterationDto
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
        exerciseExampleId = exerciseExample?.id,
        exerciseExample = exerciseExample?.domainToDto()
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