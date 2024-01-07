package exercise_example_muscle

import AlienWorkoutDatabase
import NativeContext
import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import database
import exercise_example_muscle.mapping.mapToDao
import exercise_example_muscle.models.ExerciseExampleDao
import exercise_example_muscle.models.MuscleDao
import exercise_example_muscle.models.MuscleTypeDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.transform

public class ExerciseExamplesSource(nativeContext: NativeContext) {

    private val database: AlienWorkoutDatabase = nativeContext.database()
    private val exerciseExampleApi by lazy { database.exerciseExampleQueries }
    private val muscleApi by lazy { database.muscleQueries }

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

    public fun getMuscleTypes(): Flow<List<MuscleTypeDao>> {
        return muscleApi
            .getMuscleTypes()
            .asFlow()
            .mapToList(Dispatchers.Default)
            .transform { emit(it.mapToDao()) }
    }

    public fun getMusclesByIds(ids: List<String>): Flow<List<MuscleDao>> {
        return muscleApi
            .getMusclesById(ids)
            .asFlow()
            .mapToList(Dispatchers.Default)
            .map { it.map { item -> item.mapToDao() } }
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
                imageUrl = exerciseExample.imageUrl
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
            return@transactionWithResult exerciseExample.id
        }
        return result
    }

    public fun setMuscleTypesWithMuscles(muscleTypes: List<MuscleTypeDao>) {
        exerciseExampleApi.transaction {
            muscleTypes.forEach { muscleType ->
                muscleApi.setMuscleType(
                    id = muscleType.id,
                    name = muscleType.name,
                    createdAt = muscleType.createdAt,
                    updatedAt = muscleType.updatedAt,
                    type = muscleType.type
                )

                muscleType.muscles.forEach { muscle ->
                    muscleApi.setMuscle(
                        id = muscle.id,
                        name = muscle.name,
                        createdAt = muscle.createdAt,
                        updatedAt = muscle.updatedAt,
                        muscleTypeId = muscle.muscleTypeId,
                        type = muscle.type,
                        status = muscle.status
                    )
                }
            }
        }
    }

    public fun setMuscle(muscle: MuscleDao) {
        muscleApi.setMuscle(
            id = muscle.id,
            name = muscle.name,
            createdAt = muscle.createdAt,
            updatedAt = muscle.updatedAt,
            muscleTypeId = muscle.muscleTypeId,
            type = muscle.type,
            status = muscle.status
        )
    }

    public fun clearTables() {
        exerciseExampleApi.deleteTableExerciseExample()
        muscleApi.deleteTableMuscle()
        muscleApi.deleteTableMuscleType()
        exerciseExampleApi.deleteTableExerciseExampleBundle()
    }
}