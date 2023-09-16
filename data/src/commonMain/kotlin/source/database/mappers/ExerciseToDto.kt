package source.database.mappers

import data.Exercise
import dto.backend.ExerciseDTO
import dto.backend.IterationDTO

fun Exercise.toDto(
    iterations: List<IterationDTO>
): ExerciseDTO {
    return ExerciseDTO(
        id = this.id,
        name = this.name,
        tonnage = this.tonnage,
        countOfLifting = this.countOfLifting?.toInt(),
        intensity = this.intensity,
        iterations = iterations
    )
}