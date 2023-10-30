package exercise_example_muscle

import NativeContext
import UsefulTrainingDatabase
import data.MuscleExerciseBundle
import database
import exercise_example_muscle.models.ExerciseExampleDao
import exercise_example_muscle.models.MuscleDao
import kotlinx.coroutines.flow.Flow

public class ExerciseExamplesSource(nativeContext: NativeContext) {

    private val database: UsefulTrainingDatabase = nativeContext.database()
    private val api by lazy { database.exercise_example_muscleQueries }

    public fun getExerciseExamples(): Flow<List<ExerciseExampleDao>> {
        return TODO()
    }

    public fun getMuscles(): Flow<List<MuscleDao>> {
        return TODO()
    }

    public fun getExerciseExampleWithMusclesById(exerciseExampleId: String): Flow<List<Pair<ExerciseExampleDao, List<MuscleDao>>>> {
        return TODO()
    }

    public fun getMuscleWithExerciseExamplesById(muscleId: String): Flow<List<Pair<MuscleDao, List<ExerciseExampleDao>>>> {
        return TODO()
    }

    public fun setExerciseExampleWithMuscles(
        exerciseExample: ExerciseExampleDao,
        muscles: List<MuscleDao>
    ) {

    }

    public fun setMuscleWithExerciseExamples(
        muscle: MuscleDao,
        exerciseExamples: List<ExerciseExampleDao>
    ) {

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

    private fun setMuscle(muscle: MuscleDao) {
        api.setMuscle(
            id = muscle.id,
            name = muscle.name,
            createdAt = muscle.createdAt,
            updatedAt = muscle.updatedAt
        )
    }

    private fun setExerciseExample(exerciseExample: ExerciseExampleDao) {
        api.setExerciseExample(
            id = exerciseExample.id,
            name = exerciseExample.name,
            createdAt = exerciseExample.createdAt,
            updatedAt = exerciseExample.updatedAt
        )
    }

    private fun setMuscleExerciseBundle(
        muscleExerciseBundle: MuscleExerciseBundle,
        muscleId: String,
        exerciseExampleId: String
    ) {
        api.setMuscleExerciseBundle(
            id = muscleExerciseBundle.id,
            value_ = muscleExerciseBundle.value_,
            createdAt = muscleExerciseBundle.createdAt,
            updatedAt = muscleExerciseBundle.updatedAt,
            muscleId = muscleId,
            exerciseExampleId = exerciseExampleId
        )
    }
}