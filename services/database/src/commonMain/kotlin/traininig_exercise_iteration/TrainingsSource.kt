package traininig_exercise_iteration

import AlienWorkoutDatabase
import NativeContext
import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import database
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.transform
import kotlinx.coroutines.flow.transformLatest
import traininig_exercise_iteration.mapping.mapToDao
import traininig_exercise_iteration.models.TrainingDao

public class TrainingsSource(nativeContext: NativeContext) {

    private val database: AlienWorkoutDatabase = nativeContext.database()
    private val api by lazy { database.training_exercise_iterationQueries }

    public fun getTrainings(startDate: String, endDate: String): Flow<List<TrainingDao>> {
        return api
            .getTrainings(endDate, startDate)
            .asFlow()
            .mapToList(Dispatchers.Default)
            .transform { emit(it.mapToDao()) }
    }

    public fun getTraining(trainingId: String): Flow<TrainingDao?> {
        return api
            .getTrainingById(trainingId)
            .asFlow()
            .mapToList(Dispatchers.Default)
            .transformLatest { emit(it.mapToDao()) }
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
                    exerciseExampleId = exercise.exerciseExampleId
                )

                for (iteration in exercise.iterations) {

                    api.setIteration(
                        id = iteration.id,
                        exerciseId = exercise.id,
                        weight = iteration.weight,
                        repetitions = iteration.repetitions.toLong(),
                        updatedAt = training.updatedAt,
                        createdAt = training.createdAt
                    )
                }
            }
        }
        return training.id
    }

    public fun clearTables() {
        api.deleteTableTraining()
    }

    public fun deleteTraining(trainingId: String) {
        api.deleteTrainingById(id = trainingId)
    }
}