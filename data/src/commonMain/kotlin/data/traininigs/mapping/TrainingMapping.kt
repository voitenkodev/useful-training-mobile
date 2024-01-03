package data.traininigs.mapping

import models.Exercise
import models.Training
import network.models.ExerciseDto
import network.models.TrainingDto
import traininig_exercise_iteration.models.ExerciseDao
import traininig_exercise_iteration.models.TrainingDao

internal fun Training.domainToDto(): TrainingDto {
    val exercises = exercises.map { ex ->
        val iterations = ex.iterations.map { it.dtoToDto() }
        ex.dtoToDto(iterations)
    }
    return domainToDto(exercises)
}

internal fun Training.domainToDto(exercises: List<ExerciseDto>): TrainingDto {
    return TrainingDto(
        id = id,
        duration = duration,
        volume = volume,
        repetitions = repetitions,
        intensity = intensity,
        exercises = exercises
    )
}

internal fun List<TrainingDao>.daoToDomain(): List<Training> {
    return mapNotNull { it.daoToDomain() }
}

internal fun TrainingDao.daoToDomain(): Training {
    val exercises = exercises.map { ex ->
        val iterations = ex.iterations.map { it.toDomain() }
        ex.toDomain(iterations)
    }
    return toDomain(exercises)
}

internal fun TrainingDao.toDomain(exercises: List<Exercise>): Training {
    return Training(
        id = id,
        duration = duration,
        createdAt = createdAt,
        volume = volume,
        repetitions = repetitions,
        intensity = intensity,
        exercises = exercises
    )
}

internal fun List<TrainingDto>.dtoToDao(): List<TrainingDao> {
    return mapNotNull { it.dtoToDao() }
}

internal fun TrainingDto.dtoToDao(): TrainingDao? {
    val exercises = exercises.mapNotNull { ex ->
        val iterations = ex.iterations.mapNotNull { it.dtoToDao() }
        ex.dtoToDao(iterations)
    }
    return dtoToDao(exercises)
}

internal fun TrainingDto.dtoToDao(exercises: List<ExerciseDao>): TrainingDao? {
    return TrainingDao(
        id = id ?: return null,
        duration = duration ?: return null,
        createdAt = createdAt ?: return null,
        volume = volume ?: return null,
        repetitions = repetitions ?: return null,
        intensity = intensity ?: return null,
        exercises = exercises,
        updatedAt = updatedAt ?: return null
    )
}