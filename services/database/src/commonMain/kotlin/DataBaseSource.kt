import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import data.Exercise
import data.Iteration
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import mappers.toDao
import models.ExerciseDao
import models.IterationDao
import models.TrainingDao

public class DataBaseSource(nativeContext: NativeContext) {

    private val database: UsefulTrainingDatabase = nativeContext.database()
    private val userExerciseNamesBd by lazy { database.user_exercise_namesQueries }
    private val trainingsBd by lazy { database.trainingsQueries }

    public fun setExerciseNames(names: List<String>): Flow<Unit> {
        val request = names.forEach { userExerciseNamesBd.insert(it) }
        return flowOf(request)
    }

    public fun getExerciseNames(): Flow<List<String>> {
        return flowOf(userExerciseNamesBd.selectAll().executeAsList())
    }

    public fun removeExerciseName(value: String): Flow<String> {
        return flowOf(userExerciseNamesBd.delete(value_ = value))
            .map { value }
    }

    public fun getTrainings(): Flow<List<TrainingDao>> {

        val result = trainingsBd
            .getTrainings()
            .asFlow()
            .mapToList(Dispatchers.Default)
            .map { trainings ->
                trainings.map { trainingEntity ->

                    val exercises = getExercisesBy {
                        trainingsBd
                            .getExercisesByTrainingId(trainingEntity.id)
                            .executeAsList()
                    }

                    trainingEntity.toDao(exercises = exercises)
                }
            }

        return result
    }

    public fun getTraining(trainingId: String): Flow<TrainingDao> {

        val result = trainingsBd
            .getTrainingById(trainingId)
            .executeAsOne()

        val Dao = getExercisesBy {
            trainingsBd
                .getExercisesByTrainingId(result.id)
                .executeAsList()
        }

        return flowOf(result.toDao(Dao))
    }

    public fun setTrainings(trainings: List<TrainingDao>) {
        trainingsBd.transaction {
            trainings.map { setTraining(it) }
        }
    }

    public fun setTraining(training: TrainingDao): String? {

        val trainingId = training.id ?: return null

        trainingsBd.setTraining(
            id = trainingId,
            duration = training.duration,
            date = training.date,
            tonnage = training.tonnage,
            countOfLifting = training.countOfLifting?.toLong(),
            intensity = training.intensity
        )

        trainingsBd.deleteExercisesByTrainingId(training.id)

        for (exercise in training.exercises) {

            val exerciseId = exercise.id ?: continue

            trainingsBd.setExercise(
                id = exerciseId,
                trainingId = training.id,
                name = exercise.name,
                tonnage = exercise.tonnage,
                countOfLifting = exercise.countOfLifting?.toLong(),
                intensity = exercise.intensity
            )

            for (iteration in exercise.iterations) {

                val iterationId = iteration.id ?: continue

                trainingsBd.setIteration(
                    id = iterationId,
                    exerciseId = exerciseId,
                    weight = iteration.weight,
                    repeat = iteration.repeat?.toLong()
                )
            }
        }

        return trainingId
    }

    public fun deleteAll() {
        trainingsBd.deleteAll()
        userExerciseNamesBd.deleteAll()
    }

    public fun deleteTraining(trainingId: String) {
        trainingsBd.deleteTrainingById(id = trainingId)
    }

    private fun getExercisesBy(action: () -> List<Exercise>): List<ExerciseDao> {
        return action().map { exerciseEntity ->
            val iterations = getIterationsBy {
                trainingsBd
                    .getIterationsByExercisesId(exerciseEntity.id)
                    .executeAsList()
            }

            exerciseEntity.toDao(iterations = iterations)
        }
    }

    private fun getIterationsBy(action: () -> List<Iteration>): List<IterationDao> {
        return action().map { iterationEntity ->
            iterationEntity.toDao()
        }
    }
}