package exerciseexamples.repository.mapping

import models.ExerciseExample
import models.ExerciseExampleDto

internal fun List<ExerciseExampleDto>.dtoToDomain(): List<ExerciseExample> {
    return mapNotNull { it.dtoToDomain() }
}

internal fun ExerciseExampleDto.dtoToDomain(): ExerciseExample? {
    return ExerciseExample(
        id = id ?: return null,
        name = name ?: return null,
        muscleExerciseBundles = muscleExerciseBundles.dtoToDomain()
    )
}

internal fun ExerciseExample.domainToDto(): ExerciseExampleDto {
    return ExerciseExampleDto(
        id = id,
        name = name,
        muscleExerciseBundles = muscleExerciseBundles.domainToDto()
    )
}