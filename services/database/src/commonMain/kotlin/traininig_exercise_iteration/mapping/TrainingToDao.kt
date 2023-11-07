package traininig_exercise_iteration.mapping

import data.Training
import traininig_exercise_iteration.models.ExerciseDao
import traininig_exercise_iteration.models.TrainingDao

internal fun Training.toDao(exercises: List<ExerciseDao>): TrainingDao {
    return TrainingDao(
        id = id,
        duration = duration ?: 0,
        volume = volume ?: 0.0,
        repetitions = repetitions?.toInt() ?: 0,
        intensity = intensity ?: 0.0,
        exercises = exercises,
        createdAt = createdAt ?: "",
        updatedAt = updatedAt ?: ""
    )
}