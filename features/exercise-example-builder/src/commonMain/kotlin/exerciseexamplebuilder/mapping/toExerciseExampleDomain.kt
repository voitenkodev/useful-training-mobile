package exerciseexamplebuilder.mapping

import exerciseexamplebuilder.state.ExerciseExample
import exerciseexamplebuilder.state.MuscleType
import models.MuscleExerciseBundle

internal fun ExerciseExample.toDomain(muscleTypes: List<MuscleType>): models.ExerciseExample {
    return models.ExerciseExample(
        id = id,
        name = name,
        imageUrl = null,
        muscleExerciseBundles = muscleTypes
            .flatMap { it.muscles }
            .filter { it.isSelected && it.percentage > 0 }
            .map {
                MuscleExerciseBundle(
                    percentage = it.percentage,
                    id = null,
                    muscle = it.toDomain()
                )
            }
    )
}