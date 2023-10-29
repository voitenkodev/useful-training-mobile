package traininig_exercise_iteration

import NativeContext
import UsefulTrainingDatabase
import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import app.cash.sqldelight.coroutines.mapToOne
import data.Exercise
import data.Iteration
import database
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import traininig_exercise_iteration.mapping.toDao
import traininig_exercise_iteration.models.ExerciseDao
import traininig_exercise_iteration.models.IterationDao
import traininig_exercise_iteration.models.TrainingDao

public class TrainingsSource(nativeContext: NativeContext) {

    private val database: UsefulTrainingDatabase = nativeContext.database()
    private val api by lazy { database.training_exercise_iterationQueries }

    public fun getTrainings(): Flow<List<TrainingDao>> {
        return api
            .getTrainings()
            .asFlow()
            .mapToList(Dispatchers.Default)
            .map { trainings ->
                trainings.map { trainingEntity ->
                    val exercises = getExercisesBy {
                        api.getExercisesByTrainingId(trainingEntity.id).executeAsList()
                    }
                    trainingEntity.toDao(exercises = exercises)
                }
            }
    }

    public fun getTraining(trainingId: String): Flow<TrainingDao> {
        return api
            .getTrainingById(trainingId)
            .asFlow()
            .mapToOne(Dispatchers.Default)
            .map { result ->
                val exercises = getExercisesBy {
                    api.getExercisesByTrainingId(result.id).executeAsList()
                }
                result.toDao(exercises)
            }
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
            duration = training.duration?.toLong(),
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

    private fun getExercisesBy(query: () -> List<Exercise>): List<ExerciseDao> {
        return query().map { exerciseEntity ->
            val iterations = getIterationsBy {
                api.getIterationsByExercisesId(exerciseEntity.id).executeAsList()
            }
            exerciseEntity.toDao(iterations = iterations)
        }
    }

    private fun getIterationsBy(query: () -> List<Iteration>): List<IterationDao> {
        return query().map { iterationEntity ->
            iterationEntity.toDao()
        }
    }
}