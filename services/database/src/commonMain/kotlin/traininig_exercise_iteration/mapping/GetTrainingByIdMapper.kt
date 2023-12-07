package traininig_exercise_iteration.mapping

import data.GetTrainingById
import exercise_example_muscle.models.ExerciseExampleDao
import traininig_exercise_iteration.models.ExerciseDao
import traininig_exercise_iteration.models.IterationDao
import traininig_exercise_iteration.models.TrainingDao

internal fun List<GetTrainingById>.mapToDao(): TrainingDao? {
    if (isEmpty()) return null

    val root = firstOrNull() ?: return null

    val exercises = groupBy { it.exerciseId }
        .mapNotNull mapExercise@{ ex ->

            val iterationsDao = ex.value
                .groupBy { it.iterationId }
                .mapNotNull mapIteration@{
                    val exercise = it.value.firstOrNull() ?: return@mapIteration null

                    IterationDao(
                        id = exercise.iterationId ?: return@mapIteration null,
                        repetitions = exercise.iterationRepetitions?.toInt() ?: return@mapIteration null,
                        weight = exercise.iterationWeight ?: return@mapIteration null,
                        createdAt = exercise.iterationCreatedAt ?: return@mapIteration null,
                        updatedAt = exercise.iterationUpdateAt ?: return@mapIteration null,
                        exerciseId = exercise.exerciseId ?: return@mapIteration null
                    )
                }

            val training = ex.value.firstOrNull() ?: return null

            val exerciseExampleDao = let {
                val id = training.exerciseExampleId ?: return@let null
                val name = training.exerciseExampleName ?: return@let null
                val imageUrl = training.exerciseExampleImageUrl ?: return@let null
                val createdAt = training.exerciseExampleCreatedAt ?: return@let null
                val updatedAt = training.exerciseExampleUpdatedAt ?: return@let null

                ExerciseExampleDao(
                    id = id,
                    name = name,
                    imageUrl = imageUrl,
                    createdAt = createdAt,
                    updatedAt = updatedAt,
                    muscleExerciseBundles = emptyList() // todo
                )
            }

            ExerciseDao(
                id = training.exerciseId ?: return@mapExercise null,
                repetitions = training.exerciseRepetitions?.toInt() ?: return@mapExercise null,
                volume = training.exerciseVolume ?: return@mapExercise null,
                intensity = training.exerciseIntensity ?: return@mapExercise null,
                name = training.exerciseName ?: return@mapExercise null,
                iterations = iterationsDao,
                createdAt = training.exerciseCreatedAt ?: return@mapExercise null,
                updatedAt = training.exerciseUpdateAt ?: return@mapExercise null,
                trainingId = training.id,
                exerciseExample = exerciseExampleDao,
                exerciseExampleId = training.exerciseExampleId,
            )
        }


    return TrainingDao(
        id = root.id,
        createdAt = root.createdAt ?: return null,
        updatedAt = root.updatedAt ?: return null,
        volume = root.volume ?: return null,
        duration = root.duration ?: return null,
        intensity = root.intensity ?: return null,
        repetitions = root.repetitions?.toInt() ?: return null,
        exercises = exercises
    )
}