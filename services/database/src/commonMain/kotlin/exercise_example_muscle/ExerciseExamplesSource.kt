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
import exercise_example_muscle.models.MuscleExerciseBundleDao
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
                                .getMusclesById(muscleExerciseBundle.muscleId)
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
                            .getMusclesById(muscleExerciseBundle.muscleId)
                            .executeAsOne()
                        muscleExerciseBundle.toDao(muscle.toDao())
                    }
                exerciseExample.toDao(muscleBundles)
            }
    }

    public fun setExerciseExamples(exerciseExamples: List<ExerciseExampleDao>) {
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
                updatedAt = exerciseExample.updatedAt
            )

            exerciseExample.muscleExerciseBundles.forEach { muscleExerciseBundle ->
                setMuscleExerciseBundle(
                    muscleExerciseBundle = muscleExerciseBundle
                )
                setMuscle(
                    muscle = muscleExerciseBundle.muscle
                )
            }
        }
        return exerciseExample.id
    }

    public fun getMuscles(): Flow<List<MuscleDao>> {
        return api
            .getMuscles()
            .asFlow()
            .mapToList(Dispatchers.Default)
            .map { list -> list.map { item -> item.toDao() } }
    }

    public fun deleteExerciseExample(exerciseExampleId: String) {
        api.deleteExerciseExampleById(
            id = exerciseExampleId
        )
    }

    public fun deleteMuscle(muscleId: String) {
        api.deleteMuscleById(
            id = muscleId
        )
    }

    public fun setMuscles(muscles: List<MuscleDao>) {
        api.transaction {
            muscles.forEach { setMuscle(it) }
        }
    }

    public fun clearTables() {
        api.deleteTableExerciseExample()
        api.deleteTableMuscle()
        api.deleteTableMuscleExerciseBundle()
    }

    private fun setMuscle(muscle: MuscleDao) {
        api.setMuscle(
            id = muscle.id,
            name = muscle.name,
            createdAt = muscle.createdAt,
            updatedAt = muscle.updatedAt
        )
    }

    private fun setMuscleExerciseBundle(muscleExerciseBundle: MuscleExerciseBundleDao) {
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