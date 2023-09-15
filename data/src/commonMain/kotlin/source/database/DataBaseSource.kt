package source.database

import NativeContext
import UsefulTrainingDatabase
import data.Exercise
import data.Iteration
import database
import dto.backend.ExerciseDTO
import dto.backend.ExerciseDateDTO
import dto.backend.IterationDTO
import dto.backend.TrainingDTO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map

class DataBaseSource(nativeContext: NativeContext) {

    private val database: UsefulTrainingDatabase = nativeContext.database()
    private val userExerciseNamesBd by lazy { database.user_exercise_namesQueries }
    private val trainingsBd by lazy { database.trainingsQueries }

    fun setExerciseNames(names: List<String>): Flow<Unit> {
        val request = userExerciseNamesBd.transactionWithResult {
            names.forEach {
                userExerciseNamesBd.insert(it)
            }
        }
        return flowOf(request)
    }

    suspend fun getExerciseNames(): Flow<List<String>> {
        return flow {
            emit(userExerciseNamesBd.selectAll().executeAsList())
        }
    }

    suspend fun removeExerciseName(value: String): Flow<String> {
        return flow {
            emit(userExerciseNamesBd.delete(value_ = value))
        }.map { value }
    }

    suspend fun getTrainings(): Flow<List<TrainingDTO>> {
        return flow {

            val result = trainingsBd
                .getTrainings()
                .executeAsList()

            val dto = result.map { trainingEntity ->
                TrainingDTO(
                    id = trainingEntity.id,
                    duration = trainingEntity.duration,
                    date = trainingEntity.date,
                    tonnage = trainingEntity.tonnage,
                    countOfLifting = trainingEntity.countOfLifting?.toInt(),
                    intensity = trainingEntity.intensity,
                    exercises = getExercisesBy {
                        trainingsBd
                            .getExercisesByTrainingId(trainingEntity.id)
                            .executeAsList()
                    }
                )
            }

            emit(dto)
        }
    }

    suspend fun getTraining(trainingId: String): Flow<TrainingDTO> {
        return flow {

            val result = trainingsBd
                .getTrainingById(trainingId)
                .executeAsOne()

            val dto = TrainingDTO(
                id = result.id,
                duration = result.duration,
                date = result.date,
                tonnage = result.tonnage,
                countOfLifting = result.countOfLifting?.toInt(),
                intensity = result.intensity,
                exercises = getExercisesBy {
                    trainingsBd
                        .getExercisesByTrainingId(result.id)
                        .executeAsList()
                }
            )

            emit(dto)
        }
    }

    suspend fun setTraining(training: TrainingDTO): Flow<String?> {
        return flow {

            val trainingId = training.id ?: return@flow emit(null)

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

                trainingsBd.deleteIterationsByExerciseId(exercise.id)

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

            emit(trainingId)
        }
    }

    suspend fun deleteTraining(trainingId: String): Flow<Unit> {
        return flow {
            trainingsBd.deleteTrainingById(id = trainingId)
            emit(Unit)
        }
    }

    suspend fun getExercises(query: String): Flow<List<ExerciseDateDTO>> {
        return flow {
            // TODO REALIZE
        }
    }

    private fun getExercisesBy(
        action: () -> List<Exercise>,
    ): List<ExerciseDTO> {
        return action().map { exerciseEntity ->
            ExerciseDTO(
                id = exerciseEntity.id,
                name = exerciseEntity.name,
                tonnage = exerciseEntity.tonnage,
                countOfLifting = exerciseEntity.countOfLifting?.toInt(),
                intensity = exerciseEntity.intensity,
                iterations = getIterationsBy {
                    trainingsBd
                        .getIterationsByExercisesId(exerciseEntity.id)
                        .executeAsList()
                }
            )
        }
    }

    private fun getIterationsBy(
        action: () -> List<Iteration>
    ): List<IterationDTO> {
        return action().map { iterationEntity ->
            IterationDTO(
                id = iterationEntity.id,
                weight = iterationEntity.weight,
                repeat = iterationEntity.repeat?.toInt()
            )
        }
    }
}