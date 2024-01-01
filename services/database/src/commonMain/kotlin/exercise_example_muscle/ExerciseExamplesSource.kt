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
    private val api by lazy { database.exercise_example_muscleQueries }

    public fun getExerciseExamples(): Flow<List<ExerciseExampleDao>> {
        return api
            .getExerciseExamples()
            .asFlow()
            .mapToList(Dispatchers.Default)
            .transform { emit(it.mapToDao()) }
    }

    public fun getExerciseExampleById(id: String): Flow<ExerciseExampleDao?> {
        return api
            .getExerciseExamplesById(id)
            .asFlow()
            .mapToList(Dispatchers.Default)
            .transform { emit(it.mapToDao()) }
    }

    public fun setExerciseExamples(exerciseExamples: List<ExerciseExampleDao>) {
        api.deleteTableExerciseExample()
        api.deleteTableMuscleExerciseBundle()
        exerciseExamples.onEach { exerciseExample -> setExerciseExample(exerciseExample) }
    }

    public fun getMuscleTypes(): Flow<List<MuscleTypeDao>> {
        return api
            .getMuscleTypes()
            .asFlow()
            .mapToList(Dispatchers.Default)
            .transform { emit(it.mapToDao()) }
    }

    public fun getMusclesByIds(ids: List<String>): Flow<List<MuscleDao>> {
        return api
            .getMusclesById(ids)
            .asFlow()
            .mapToList(Dispatchers.Default)
            .map { it.map { item -> item.mapToDao() } }
    }

    public fun setExerciseExample(exerciseExample: ExerciseExampleDao): String {
        val result = api.transactionWithResult {
            api.setExerciseExample(
                id = exerciseExample.id,
                name = exerciseExample.name,
                description = exerciseExample.description,
                createdAt = exerciseExample.createdAt,
                updatedAt = exerciseExample.updatedAt,
                imageUrl = exerciseExample.imageUrl
            )

            exerciseExample.muscleExerciseBundles.forEach { muscleExerciseBundle ->

                val muscle = muscleExerciseBundle.muscle

                api.setMuscle(
                    id = muscle.id,
                    name = muscle.name,
                    createdAt = muscle.createdAt,
                    updatedAt = muscle.updatedAt,
                    muscleTypeId = muscle.muscleTypeId,
                    type = muscle.type,
                    status = muscle.status
                )

                api.setMuscleExerciseBundle(
                    id = muscleExerciseBundle.id,
                    percentage = muscleExerciseBundle.percentage.toLong(),
                    createdAt = muscleExerciseBundle.createdAt,
                    updatedAt = muscleExerciseBundle.updatedAt,
                    muscleId = muscleExerciseBundle.muscleId,
                    exerciseExampleId = muscleExerciseBundle.exerciseExampleId
                )
            }
            return@transactionWithResult exerciseExample.id
        }
        return result
    }

    public fun setMuscleTypesWithMuscles(muscles: List<MuscleTypeDao>) {
        api.transaction {
            api.deleteTableMuscleType()
            api.deleteTableMuscle()
            muscles.forEach { muscleType ->
                api.setMuscleType(
                    id = muscleType.id,
                    name = muscleType.name,
                    createdAt = muscleType.createdAt,
                    updatedAt = muscleType.updatedAt,
                    type = muscleType.type
                )
                muscleType.muscles.forEach { muscle ->
                    api.setMuscle(
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

    public fun clearTables() {
        api.deleteTableExerciseExample()
        api.deleteTableMuscle()
        api.deleteTableMuscleType()
        api.deleteTableMuscleExerciseBundle()
    }
}