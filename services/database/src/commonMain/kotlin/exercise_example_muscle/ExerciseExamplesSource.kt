package exercise_example_muscle

import NativeContext
import UsefulTrainingDatabase
import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import database
import exercise_example_muscle.models.ExerciseExampleDao
import exercise_example_muscle.models.MuscleDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

public class ExerciseExamplesSource(nativeContext: NativeContext) {

    private val database: UsefulTrainingDatabase = nativeContext.database()
    private val api by lazy { database.exercise_example_muscleQueries }

    public fun getExerciseExamples(): Flow<List<ExerciseExampleDao>> {
        return api
            .getExerciseExamples()
            .asFlow()
            .mapToList(Dispatchers.Default)
            .map { list ->
                list.map { model ->
                    ExerciseExampleDao(
                        id = model.id,
                        name = model.name
                    )
                }
            }
    }

    public fun getMuscles(): Flow<List<MuscleDao>> {
        return api
            .getMuscles()
            .asFlow()
            .mapToList(Dispatchers.Default)
            .map { list ->
                list.map { model ->
                    MuscleDao(
                        id = model.id,
                        name = model.name
                    )
                }
            }
    }


    public fun getExerciseExampleWithMusclesById(exerciseExampleId: Long): Flow<List<Pair<ExerciseExampleDao, List<MuscleDao>>>> {
        return api
            .getExerciseExampleWithMusclesById(exerciseExampleId)
            .asFlow()
            .mapToList(Dispatchers.Default)
            .map { list ->
                list.map { model ->
                    val exercise = ExerciseExampleDao(
                        id = model.exercise_id,
                        name = model.exercise_name
                    )
                    val muscle = MuscleDao(
                        id = model.muscle_id,
                        name = model.muscle_name
                    )
                    exercise to muscle
                }.groupBy(
                    keySelector = { it.first },
                    valueTransform = { it.second }
                ).toList()
            }
    }

    public fun getMuscleWithExerciseExamplesById(muscleId: Long): Flow<List<Pair<MuscleDao, List<ExerciseExampleDao>>>> {
        return api
            .getMuscleWithExerciseExamplesById(muscleId)
            .asFlow()
            .mapToList(Dispatchers.Default)
            .map { list ->
                list.map { model ->
                    val exercise = ExerciseExampleDao(
                        id = model.exercise_id,
                        name = model.exercise_name
                    )
                    val muscle = MuscleDao(
                        id = model.muscle_id,
                        name = model.muscle_name
                    )
                    muscle to exercise
                }.groupBy(
                    keySelector = { it.first },
                    valueTransform = { it.second }
                ).toList()
            }
    }

    public fun setExerciseExampleWithMuscles(
        exerciseExample: ExerciseExampleDao,
        muscles: List<MuscleDao>
    ) {
        api.transaction {
            setExerciseExample(exerciseExample)
            val exerciseExampleId = api.lastExerciseExampleId().executeAsOneOrNull()

            muscles.forEach { muscle ->
                setMuscle(muscle)
                val muscleId = api.lastMuscleId().executeAsOneOrNull()

                setExerciseExampleMuscleRef(
                    exerciseExampleId = exerciseExampleId ?: return@forEach,
                    muscleId = muscleId ?: return@forEach
                )
            }
        }
    }

    public fun setMuscleWithExerciseExamples(
        muscle: MuscleDao,
        exerciseExamples: List<ExerciseExampleDao>
    ) {
        api.transaction {
            setMuscle(muscle)
            val muscleId = api.lastMuscleId().executeAsOneOrNull()

            exerciseExamples.forEach { exerciseExample ->
                setExerciseExample(exerciseExample)
                val exerciseExampleId = api.lastExerciseExampleId().executeAsOneOrNull()

                setExerciseExampleMuscleRef(
                    exerciseExampleId = exerciseExampleId ?: return@forEach,
                    muscleId = muscleId ?: return@forEach
                )
            }
        }
    }

    private fun setMuscle(muscle: MuscleDao) {
        api.setMuscle(
            id = muscle.id,
            name = muscle.name
        )
    }

    private fun setExerciseExample(exerciseExample: ExerciseExampleDao) {
        api.setMuscle(
            id = exerciseExample.id,
            name = exerciseExample.name
        )
    }

    private fun setExerciseExampleMuscleRef(exerciseExampleId: Long, muscleId: Long) {
        api.setExerciseExampleMuscleRef(
            exerciseExampleId = exerciseExampleId,
            muscleId = muscleId
        )
    }
}