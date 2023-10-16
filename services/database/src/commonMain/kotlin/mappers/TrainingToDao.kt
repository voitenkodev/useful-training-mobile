package mappers

import data.Training
import models.ExerciseDao
import models.TrainingDao

internal fun Training.toDao(exercises: List<ExerciseDao>): TrainingDao {
    return TrainingDao(
        id = this.id,
        duration = this.duration,
        date = this.date,
        tonnage = this.tonnage,
        countOfLifting = this.countOfLifting?.toInt(),
        intensity = this.intensity,
        exercises = exercises
    )
}