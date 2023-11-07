package traininig_exercise_iteration

import NativeContext
import AlienWorkoutDatabase
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

    private val database: AlienWorkoutDatabase = nativeContext.database()
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
        trainings.map { setTraining(it) }
    }

    public fun setTraining(training: TrainingDao): String {
        api.transaction {
            api.deleteTrainingById(training.id)

            api.setTraining(
                id = training.id,
                duration = training.duration,
                createdAt = training.createdAt,
                volume = training.volume,
                repetitions = training.repetitions.toLong(),
                intensity = training.intensity,
                updatedAt = training.updatedAt
            )

            for (exercise in training.exercises) {

                api.setExercise(
                    id = exercise.id,
                    trainingId = training.id,
                    name = exercise.name,
                    volume = exercise.volume,
                    repetitions = exercise.repetitions.toLong(),
                    intensity = exercise.intensity,
                    updatedAt = training.updatedAt,
                    createdAt = training.createdAt,
                )

                for (iteration in exercise.iterations) {

                    api.setIteration(
                        id = iteration.id,
                        exerciseId = exercise.id,
                        weight = iteration.weight,
                        repetitions = iteration.repetitions.toLong(),
                        updatedAt = training.updatedAt,
                        createdAt = training.createdAt,
                    )
                }
            }
        }
        return training.id
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