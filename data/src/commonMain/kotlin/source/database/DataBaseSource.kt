package source.database

import NativeContext
import UsefulTrainingDatabase
import data.Exercise
import data.Iteration
import database
import dto.backend.ExerciseDTO
import dto.backend.IterationDTO
import dto.backend.TrainingDTO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import source.database.mappers.toDto

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

            trainingEntity.toDto(exercises = exercises)
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

        return flowOf(result.toDto(exercises = exercises))
    }

    fun setTrainings(trainings: List<TrainingDTO>) = trainingsBd.transaction {
        trainings.map { setTraining(it) }
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
        trainingsBd.deleteTrainingById(id = trainingId)
    }

    private fun getExercisesBy(action: () -> List<Exercise>): List<ExerciseDTO> {
        return action().map { exerciseEntity ->

            val iterations = getIterationsBy {
                trainingsBd
                    .getIterationsByExercisesId(exerciseEntity.id)
                    .executeAsList()
            }

            exerciseEntity.toDto(iterations = iterations)
        }
    }

    private fun getIterationsBy(action: () -> List<Iteration>): List<IterationDTO> {
        return action().map { iterationEntity -> iterationEntity.toDto() }
    }
}