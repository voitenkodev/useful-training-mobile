package traininig_exercise_iteration.models

import exercise_example_muscle.models.ExerciseExampleDao

public data class ExerciseDao(
    val id: String,
    val repetitions: Int,
    val createdAt: String,
    val intensity: Double,
    val iterations: List<IterationDao> = emptyList(),
    val name: String,
    val volume: Double,
    val trainingId: String,
    val exerciseExampleId: String?,
    val exerciseExample: ExerciseExampleDao?,
    val updatedAt: String
)