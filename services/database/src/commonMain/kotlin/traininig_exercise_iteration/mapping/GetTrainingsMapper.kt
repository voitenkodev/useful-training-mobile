package traininig_exercise_iteration.mapping

import data.GetTrainings
import exercise_examples.models.ExerciseExampleDao
import traininig_exercise_iteration.models.ExerciseDao
import traininig_exercise_iteration.models.IterationDao
import traininig_exercise_iteration.models.TrainingDao

internal fun List<GetTrainings>.mapToDao(): List<TrainingDao> {

    if (isEmpty()) return emptyList()

    return groupBy { it.id }.mapNotNull mapTraining@{ r ->

        val root = r.value.firstOrNull() ?: return emptyList()

        val exercises = r.value.groupBy { it.exerciseId }.mapNotNull mapExercise@{ ex ->

            val iterationsDao = ex.value.groupBy { it.iterationId }.mapNotNull mapIteration@{
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

            val training = ex.value.firstOrNull() ?: return@mapExercise null

            val exerciseExampleDao = let {
                val id = training.exerciseExampleId ?: return@let null
                val name = training.exerciseExampleName ?: return@let null
                val description = training.exerciseExampleDescription ?: return@let null
                val imageUrl = training.exerciseExampleImageUrl ?: return@let null
                val createdAt = training.exerciseExampleCreatedAt ?: return@let null
                val updatedAt = training.exerciseExampleUpdatedAt ?: return@let null
                val experience = training.exerciseExampleExperience ?: return@let null
                val forceType = training.exerciseExampleForceType ?: return@let null
                val weightType = training.exerciseExampleWeightType ?: return@let null
                val category = training.exerciseExampleCategory ?: return@let null

                ExerciseExampleDao(
                    id = id,
                    name = name,
                    description = description,
                    imageUrl = imageUrl,
                    createdAt = createdAt,
                    updatedAt = updatedAt,
                    experience = experience,
                    forceType = forceType,
                    weightType = weightType,
                    category = category,
                    equipments = emptyList(), // todo do not need it
                    exerciseExampleBundles = emptyList() // todo do not need it
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
                exerciseExampleId = training.exerciseExampleId
            )
        }

        TrainingDao(
            id = root.id,
            createdAt = root.createdAt ?: return@mapTraining null,
            updatedAt = root.updatedAt ?: return@mapTraining null,
            volume = root.volume,
            duration = root.duration,
            intensity = root.intensity,
            repetitions = root.repetitions?.toInt() ?: return@mapTraining null,
            exercises = exercises
        )
    }
}