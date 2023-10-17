package mappers

import models.Exercise
import models.ExerciseDao
import models.ExerciseDto
import models.Training
import models.TrainingDao
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
        id = this.id,
        duration = this.duration,
        date = this.date,
        tonnage = this.tonnage,
        countOfLifting = this.countOfLifting,
        intensity = this.intensity,
        exercises = exercises
    )
}

internal fun List<TrainingDto>.dtoToDomain(): List<Training> = map { it.dtoToDomain() }
internal fun List<TrainingDao>.daoToDomain(): List<Training> = map { it.toDomain() }

internal fun TrainingDto.dtoToDomain(): Training {
    val exercises = exercises.map { ex ->
        val iterations = ex.iterations.map { it.toDomain() }
        ex.toDomain(iterations)
    }
    return toDomain(exercises)
}


internal fun TrainingDao.toDomain(): Training {
    val exercises = exercises.map { ex ->
        val iterations = ex.iterations.map { it.toDomain() }
        ex.toDomain(iterations)
    }
    return toDomain(exercises)
}

internal fun TrainingDto.toDomain(exercises: List<Exercise>): Training {
    return Training(
        id = this.id,
        duration = this.duration,
        date = this.date,
        tonnage = this.tonnage,
        countOfLifting = this.countOfLifting,
        intensity = this.intensity,
        exercises = exercises
    )
}


internal fun TrainingDao.toDomain(exercises: List<Exercise>): Training {
    return Training(
        id = this.id,
        duration = this.duration,
        date = this.date,
        tonnage = this.tonnage,
        countOfLifting = this.countOfLifting,
        intensity = this.intensity,
        exercises = exercises
    )
}

internal fun List<TrainingDto>.dtoToDao(): List<TrainingDao> = map { it.dtoToDao() }

internal fun TrainingDto.dtoToDao(): TrainingDao {
    val exercises = exercises.map { ex ->
        val iterations = ex.iterations.map { it.toDao() }
        ex.toDao(iterations)
    }
    return toDao(exercises)
}

internal fun TrainingDto.toDao(exercises: List<ExerciseDao>): TrainingDao {
    return TrainingDao(
        id = this.id,
        duration = this.duration,
        date = this.date,
        tonnage = this.tonnage,
        countOfLifting = this.countOfLifting,
        intensity = this.intensity,
        exercises = exercises
    )
}