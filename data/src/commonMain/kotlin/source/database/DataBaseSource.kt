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
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class DataBaseSource(nativeContext: NativeContext) {

    private val database: UsefulTrainingDatabase = nativeContext.database()
    private val userExerciseNamesBd by lazy { database.user_exercise_namesQueries }
    private val trainingsBd by lazy { database.trainingsQueries }

    fun setExerciseNames(names: List<String>): Flow<Unit> {
        val request = names.forEach { userExerciseNamesBd.insert(it) }
        return flowOf(request)
    }

    fun getExerciseNames(): Flow<List<String>> {
        return flowOf(userExerciseNamesBd.selectAll().executeAsList())
    }

    fun removeExerciseName(value: String): Flow<String> {
        return flowOf(userExerciseNamesBd.delete(value_ = value))
            .map { value }
    }

    fun getTrainings(): Flow<List<TrainingDTO>> {

        val result = trainingsBd
            .getTrainings()
            .executeAsList()

        val dto = result.map { trainingEntity ->

            val exercises = getExercisesBy {
                trainingsBd
                    .getExercisesByTrainingId(trainingEntity.id)
                    .executeAsList()
            }

            TrainingDTO(
                id = trainingEntity.id,
                duration = trainingEntity.duration,
                date = trainingEntity.date,
                tonnage = trainingEntity.tonnage,
                countOfLifting = trainingEntity.countOfLifting?.toInt(),
                intensity = trainingEntity.intensity,
                exercises = exercises
            )
        }

        return flowOf(dto)
    }

    fun getTraining(trainingId: String): Flow<TrainingDTO> {

        val result = trainingsBd
            .getTrainingById(trainingId)
            .executeAsOne()

        val exercises = getExercisesBy {
            trainingsBd
                .getExercisesByTrainingId(result.id)
                .executeAsList()
        }

        val dto = TrainingDTO(
            id = result.id,
            duration = result.duration,
            date = result.date,
            tonnage = result.tonnage,
            countOfLifting = result.countOfLifting?.toInt(),
            intensity = result.intensity,
            exercises = exercises
        )

        return flowOf(dto)
    }

    suspend fun setTrainings(trainings: List<TrainingDTO>) = withContext(Dispatchers.Default) {
        trainingsBd.transaction {
            trainings.map { setTraining(it) }
        }
    }

    fun setTraining(training: TrainingDTO): String? {

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

    fun deleteTraining(trainingId: String) {
        trainingsBd
            .deleteTrainingById(id = trainingId)
    }

    suspend fun getExercises(query: String): Flow<List<ExerciseDateDTO>> {
        return flow {
            // TODO REALIZE
        }
    }

    private fun getExercisesBy(action: () -> List<Exercise>): List<ExerciseDTO> {
        return action().map { exerciseEntity ->

            val iterations = getIterationsBy {
                trainingsBd
                    .getIterationsByExercisesId(exerciseEntity.id)
                    .executeAsList()
            }

            ExerciseDTO(
                id = exerciseEntity.id,
                name = exerciseEntity.name,
                tonnage = exerciseEntity.tonnage,
                countOfLifting = exerciseEntity.countOfLifting?.toInt(),
                intensity = exerciseEntity.intensity,
                iterations = iterations
            )
        }
    }

    private fun getIterationsBy(action: () -> List<Iteration>): List<IterationDTO> {

        return action()
            .map { iterationEntity ->
                IterationDTO(
                    id = iterationEntity.id,
                    weight = iterationEntity.weight,
                    repeat = iterationEntity.repeat?.toInt()
                )
            }
    }
}