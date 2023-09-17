package source.database.mappers

import data.Training
import dto.backend.ExerciseDTO
import dto.backend.TrainingDTO

internal fun Training.toDto(exercises: List<ExerciseDTO>, ): TrainingDTO {
    return TrainingDTO(
        id = this.id,
        duration = this.duration,
        date = this.date,
        tonnage = this.tonnage,
        countOfLifting = this.countOfLifting?.toInt(),
        intensity = this.intensity,
        exercises = exercises
    )
}