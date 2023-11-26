package exerciseexamplebuilder.mapping

import exerciseexamplebuilder.state.ExerciseExample
import exerciseexamplebuilder.state.MuscleType
import models.MuscleExerciseBundle

internal fun ExerciseExample.toDomain(muscleTypes: List<MuscleType>): models.ExerciseExample {
    return models.ExerciseExample(
        id = id,
        name = name,
        muscleExerciseBundles = muscleTypes
            .flatMap { it.muscles }
            .filter { it.isSelected && it.percentage > 0 }
            .map {
                MuscleExerciseBundle(
                    muscleId = it.id,
                    percentage = it.percentage,
                    id = null,
                    muscle = null
                )
            }
    )
}