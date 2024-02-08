package exercise_examples

import AlienWorkoutDatabase
import NativeContext
import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import database
import exercise_examples.mapping.mapToDao
import exercise_examples.models.ExerciseExampleDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.transform

public class ExerciseExamplesSource(nativeContext: NativeContext) {

    private val database: AlienWorkoutDatabase = nativeContext.database()
    private val exerciseExampleApi by lazy { database.exerciseExampleQueries }

    public fun getExerciseExamples(): Flow<List<ExerciseExampleDao>> {
        return exerciseExampleApi
            .getExerciseExamples()
            .asFlow()
            .mapToList(Dispatchers.Default)
            .transform { emit(it.mapToDao()) }
    }

    public fun getExerciseExampleById(id: String): Flow<ExerciseExampleDao?> {
        return exerciseExampleApi
            .getExerciseExamplesById(id)
            .asFlow()
            .mapToList(Dispatchers.Default)
            .transform { emit(it.mapToDao()) }
    }

    public fun setExerciseExamples(exerciseExamples: List<ExerciseExampleDao>) {
        exerciseExamples.onEach { exerciseExample ->
            setExerciseExample(exerciseExample)
        }
    }

    public fun setExerciseExample(exerciseExample: ExerciseExampleDao): String {
        val result = exerciseExampleApi.transactionWithResult {

            exerciseExampleApi.deleteExerciseExampleById(exerciseExample.id)

            exerciseExampleApi.setExerciseExample(
                id = exerciseExample.id,
                name = exerciseExample.name,
                description = exerciseExample.description,
                createdAt = exerciseExample.createdAt,
                updatedAt = exerciseExample.updatedAt,
                imageUrl = exerciseExample.imageUrl,
                forceType = exerciseExample.forceType,
                experience = exerciseExample.experience,
                weightType = exerciseExample.weightType,
                category = exerciseExample.category
            )

            exerciseExample.exerciseExampleBundles.forEach { bundle ->

                exerciseExampleApi.setExerciseExampleBundle(
                    id = bundle.id,
                    percentage = bundle.percentage.toLong(),
                    createdAt = bundle.createdAt,
                    updatedAt = bundle.updatedAt,
                    muscleId = bundle.muscleId,
                    exerciseExampleId = bundle.exerciseExampleId
                )
            }
            exerciseExample.equipments.forEach { equipmentRef ->

                exerciseExampleApi.setExerciseEquipment(
                    id = equipmentRef.id,
                    equipmentId = equipmentRef.equipmentId,
                    exerciseExampleId = equipmentRef.exerciseExampleId,
                    createdAt = equipmentRef.createdAt,
                    updatedAt = equipmentRef.updatedAt
                )
            }

            exerciseExample.tutorials.forEach { tutorial ->
                exerciseExampleApi.setExerciseTutorial(
                    id = tutorial.id,
                    exerciseExampleId = tutorial.exerciseExampleId,
                    title = tutorial.title,
                    resourceType = tutorial.resourceType,
                    resource = tutorial.resource,
                    language = tutorial.language,
                    value_ = tutorial.value,
                    createdAt = tutorial.createdAt,
                    updatedAt = tutorial.updatedAt
                )
            }

            return@transactionWithResult exerciseExample.id
        }
        return result
    }

    public fun clearTables() {
        exerciseExampleApi.deleteTableExerciseExample()
        exerciseExampleApi.deleteTableExerciseExampleBundle()
        exerciseExampleApi.deleteTableExerciseEquipment()
        exerciseExampleApi.deleteTableExerciseTutorial()
    }
}