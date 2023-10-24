package traininig_exercise_iteration

import NativeContext
import UsefulTrainingDatabase
import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import data.Exercise
import data.Iteration
import database
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import traininig_exercise_iteration.mapping.toDao
import traininig_exercise_iteration.models.ExerciseDao
import traininig_exercise_iteration.models.IterationDao
import traininig_exercise_iteration.models.TrainingDao

public class TrainingsSource(nativeContext: NativeContext) {

    private val database: UsefulTrainingDatabase = nativeContext.database()
    private val api by lazy { database.training_exercise_iterationQueries }

    public fun getTrainings(): Flow<List<TrainingDao>> {

        val result = api
            .getTrainings()
            .asFlow()
            .mapToList(Dispatchers.Default)
            .map { trainings ->
                trainings.map { trainingEntity ->

                    val exercises = getExercisesBy {
                        api
                            .getExercisesByTrainingId(trainingEntity.id)
                            .executeAsList()
                    }

                    trainingEntity.toDao(exercises = exercises)
                }
            }

        return result
    }

    public fun getTraining(trainingId: String): Flow<TrainingDao> {

        val result = api
            .getTrainingById(trainingId)
            .executeAsOne()

        val dao = getExercisesBy {
            api
                .getExercisesByTrainingId(result.id)
                .executeAsList()
        }

        return flowOf(result.toDao(dao))
    }

    public fun setTrainings(trainings: List<TrainingDao>) {
        api.transaction {
            trainings.map { setTraining(it) }
        }
    }

    public fun setTraining(training: TrainingDao): String? {

        val trainingId = training.id ?: return null

        api.setTraining(
            id = trainingId,
            duration = training.duration,
            date = training.date,
            tonnage = training.tonnage,
            countOfLifting = training.countOfLifting?.toLong(),
            intensity = training.intensity
        )

        api.deleteExercisesByTrainingId(training.id)

        for (exercise in training.exercises) {

            val exerciseId = exercise.id ?: continue

            api.setExercise(
                id = exerciseId,
                trainingId = training.id,
                name = exercise.name,
                tonnage = exercise.tonnage,
                countOfLifting = exercise.countOfLifting?.toLong(),
                intensity = exercise.intensity
            )

            for (iteration in exercise.iterations) {

                val iterationId = iteration.id ?: continue

                api.setIteration(
                    id = iterationId,
                    exerciseId = exerciseId,
                    weight = iteration.weight,
                    repeat = iteration.repeat?.toLong()
                )
            }
        }

        return trainingId
    }

    public fun dropTable() {
        api.dropTable()
    }

    public fun deleteTraining(trainingId: String) {
        api.deleteTrainingById(id = trainingId)
    }

    private fun getExercisesBy(action: () -> List<Exercise>): List<ExerciseDao> {
        return action().map { exerciseEntity ->
            val iterations = getIterationsBy {
                api
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