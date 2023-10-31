package exercise_example_muscle.mapping

import data.MuscleExerciseBundle
import exercise_example_muscle.models.MuscleDao
import exercise_example_muscle.models.MuscleExerciseBundleDao

internal fun MuscleExerciseBundle.toDao(muscle: MuscleDao): MuscleExerciseBundleDao {
    return MuscleExerciseBundleDao(
        id = id,
        exerciseExampleId = exerciseExampleId,
        muscle = muscle,
        percentage = percentage?.toInt() ?: 0,
        createdAt = createdAt ?: "",
        updatedAt = updatedAt ?: "",
        muscleId = muscleId
    )
}