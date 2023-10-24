package traininig_exercise_iteration.mapping

import data.Training
import traininig_exercise_iteration.models.ExerciseDao
import traininig_exercise_iteration.models.TrainingDao

internal fun Training.toDao(exercises: List<ExerciseDao>): TrainingDao {
    return TrainingDao(
        id = id,
        duration = duration,
        date = date,
        tonnage = tonnage,
        countOfLifting = countOfLifting?.toInt(),
        intensity = intensity,
        exercises = exercises
    )
}