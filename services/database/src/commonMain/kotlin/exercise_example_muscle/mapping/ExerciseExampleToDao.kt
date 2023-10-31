package exercise_example_muscle.mapping

import data.ExerciseExample
import exercise_example_muscle.models.ExerciseExampleDao
import exercise_example_muscle.models.MuscleExerciseBundleDao

internal fun ExerciseExample.toDao(muscleExerciseBundles: List<MuscleExerciseBundleDao>): ExerciseExampleDao {
    return ExerciseExampleDao(
        id = id,
        name = name ?: "",
        createdAt = createdAt ?: "",
        updatedAt = updatedAt ?: "",
        muscleExerciseBundles = muscleExerciseBundles
    )
}