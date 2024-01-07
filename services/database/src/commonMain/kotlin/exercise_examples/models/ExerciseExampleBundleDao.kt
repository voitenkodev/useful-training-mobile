package exercise_examples.models

import muscles.models.MuscleDao

public data class ExerciseExampleBundleDao(
    val id: String,
    val createdAt: String,
    val exerciseExampleId: String,
    val muscle: MuscleDao,
    val muscleId: String,
    val updatedAt: String,
    val percentage: Int
)