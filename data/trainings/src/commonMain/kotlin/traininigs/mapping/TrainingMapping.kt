package traininigs.mapping

import models.Exercise
import models.ExerciseDto
import models.Training
import models.TrainingDto

internal fun Training.toDto(): TrainingDto {
    val exercises = exercises.map { ex ->
        val iterations = ex.iterations.map { it.toDto() }
        ex.toDto(iterations)
    }
    return toDto(exercises)
}

internal fun Training.toDto(exercises: List<ExerciseDto>): TrainingDto {
    return TrainingDto(
        id = id,
        duration = duration,
        tonnage = tonnage,
        countOfLifting = countOfLifting,
        intensity = intensity,
        exercises = exercises
    )
}

internal fun List<TrainingDto>.dtoToDomain(): List<Training> {
    return mapNotNull { it.dtoToDomain() }
}

internal fun List<TrainingDao>.daoToDomain(): List<Training> {
    return mapNotNull { it.toDomain() }
}


internal fun TrainingDto.dtoToDomain(): Training? {
    val exercises = exercises.mapNotNull { ex ->
        val iterations = ex.iterations.mapNotNull { it.toDomain() }
        ex.toDomain(iterations)
    }
    return toDomain(exercises)
}

internal fun TrainingDao.toDomain(): Training? {
    val exercises = exercises.mapNotNull { ex ->
        val iterations = ex.iterations.mapNotNull { it.toDomain() }
        ex.toDomain(iterations)
    }
    return toDomain(exercises)
}

internal fun TrainingDto.toDomain(exercises: List<Exercise>): Training? {
    return Training(
        id = id,
        duration = duration ?: return null,
        createdAt = createdAt,
        tonnage = tonnage ?: return null,
        countOfLifting = countOfLifting ?: return null,
        intensity = intensity ?: return null,
        exercises = exercises
    )
}

internal fun TrainingDao.toDomain(exercises: List<Exercise>): Training? {
    return Training(
        id = id,
        duration = duration ?: return null,
        createdAt = createdAt,
        tonnage = tonnage ?: return null,
        countOfLifting = countOfLifting ?: return null,
        intensity = intensity ?: return null,
        exercises = exercises
    )
}

internal fun List<TrainingDto>.dtoToDao(): List<TrainingDao> {
    return map { it.dtoToDao() }
}

internal fun TrainingDto.dtoToDao(): TrainingDao {
    val exercises = exercises.map { ex ->
        val iterations = ex.iterations.map { it.toDao() }
        ex.toDao(iterations)
    }
    return toDao(exercises)
}

internal fun TrainingDto.toDao(exercises: List<ExerciseDao>): TrainingDao {
    return TrainingDao(
        id = id,
        duration = duration,
        createdAt = createdAt,
        tonnage = tonnage,
        countOfLifting = countOfLifting,
        intensity = intensity,
        exercises = exercises
    )
}