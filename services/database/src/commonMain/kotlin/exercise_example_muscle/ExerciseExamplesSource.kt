package exercise_example_muscle

import AlienWorkoutDatabase
import NativeContext
import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import app.cash.sqldelight.coroutines.mapToOne
import database
import exercise_example_muscle.mapping.toDao
import exercise_example_muscle.models.ExerciseExampleDao
import exercise_example_muscle.models.MuscleDao
import exercise_example_muscle.models.MuscleTypeDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

public class ExerciseExamplesSource(nativeContext: NativeContext) {

    private val database: AlienWorkoutDatabase = nativeContext.database()
    private val api by lazy { database.exercise_example_muscleQueries }

    public fun getExerciseExamples(): Flow<List<ExerciseExampleDao>> {
        return api
            .getExerciseExamples()
            .asFlow()
            .mapToList(Dispatchers.Default)
            .map { exerciseExamples ->
                exerciseExamples.map { exerciseExample ->
                    val muscleBundles = api
                        .getMuscleExerciseBundlesByExerciseExampleId(exerciseExample.id)
                        .executeAsList()
                        .map { muscleExerciseBundle ->
                            val muscle = api
                                .getMuscleById(muscleExerciseBundle.muscleId)
                                .executeAsOne()
                            muscleExerciseBundle.toDao(muscle.toDao())
                        }
                    exerciseExample.toDao(muscleBundles)
                }
            }
    }

    public fun getExerciseExampleById(id: String): Flow<ExerciseExampleDao> {
        return api
            .getExerciseExamplesById(id)
            .asFlow()
            .mapToOne(Dispatchers.Default)
            .map { exerciseExample ->
                val muscleBundles = api
                    .getMuscleExerciseBundlesByExerciseExampleId(exerciseExample.id)
                    .executeAsList()
                    .map { muscleExerciseBundle ->
                        val muscle = api
                            .getMuscleById(muscleExerciseBundle.muscleId)
                            .executeAsOne()
                        muscleExerciseBundle.toDao(muscle.toDao())
                    }
                exerciseExample.toDao(muscleBundles)
            }
    }

    public fun setExerciseExamples(exerciseExamples: List<ExerciseExampleDao>) {
        deleteExerciseExamples()

        exerciseExamples.onEach { exerciseExample ->
            setExerciseExample(exerciseExample)
        }
    }

    public fun setExerciseExample(exerciseExample: ExerciseExampleDao): String {
        api.transaction {
            api.setExerciseExample(
                id = exerciseExample.id,
                name = exerciseExample.name,
                createdAt = exerciseExample.createdAt,
                updatedAt = exerciseExample.updatedAt,
                imageUrl = exerciseExample.imageUrl
            )

            exerciseExample.muscleExerciseBundles.forEach { muscleExerciseBundle ->
                api.setMuscleExerciseBundle(
                    id = muscleExerciseBundle.id,
                    percentage = muscleExerciseBundle.percentage.toLong(),
                    createdAt = muscleExerciseBundle.createdAt,
                    updatedAt = muscleExerciseBundle.updatedAt,
                    muscleId = muscleExerciseBundle.muscleId,
                    exerciseExampleId = muscleExerciseBundle.exerciseExampleId
                )
            }
        }
        return exerciseExample.id
    }

    public fun getMuscleTypes(): Flow<List<MuscleTypeDao>> {
        return api
            .getMuscleTypes()
            .asFlow()
            .mapToList(Dispatchers.Default)
            .map { list ->
                list.map { muscleType ->
                    val muscles = api
                        .getMusclesByMuscleType(muscleType.id)
                        .executeAsList()
                        .map { it.toDao() }
                    muscleType.toDao(muscles)
                }
            }
    }

    public fun getMusclesByIds(ids: List<String>): Flow<List<MuscleDao>> {
        return api
            .getMusclesById(ids)
            .asFlow()
            .mapToList(Dispatchers.Default)
            .map { it.map { item -> item.toDao() } }
    }

    public fun deleteExerciseExample(exerciseExampleId: String) {
        api.deleteExerciseExampleById(
            id = exerciseExampleId
        )
    }

    private fun deleteExerciseExamples() {
        api.deleteTableExerciseExample()
        api.deleteTableMuscleExerciseBundle()
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
                        muscleTypeId = muscleType.id,
                        type = muscle.type
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