package repository

import dto.backend.ExerciseDateDTO
import dto.backend.TrainingDTO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.onStart
import source.database.DataBaseSource
import source.network.NetworkSource

class TrainingRepositoryImpl(
    private val remote: NetworkSource,
    private val local: DataBaseSource
) : TrainingRepository {

    override suspend fun getTrainings(): Flow<List<TrainingDTO>> = local
        .getTrainings()
        .onStart {
            val trainings = remote.getTrainings().first()
            trainings.map { training -> local.setTraining(training) }
        }

    override suspend fun getTraining(trainingId: String): Flow<TrainingDTO> = local
        .getTraining(trainingId)
        .onStart {
            val training = remote.getTraining(trainingId).first()
            local.setTraining(training)
        }

    // TODO ADD LOCAL CALL
    override suspend fun getExercises(query: String): Flow<List<ExerciseDateDTO>> = remote
        .getExercises(query)

    override suspend fun setTraining(training: TrainingDTO): Flow<String> = remote
        .setTraining(training = training)

    override suspend fun deleteTraining(trainingId: String): Flow<Unit> = local
        .deleteTraining(trainingId)
        .onStart {
            remote.deleteTraining(trainingId).first()
        }

    override suspend fun setExerciseNameOptions(names: List<String>) = local
        .setExerciseNames(names)

    override suspend fun getExerciseNameOptions() = local
        .getExerciseNames()

    override suspend fun removeExerciseNameOption(value: String) = local
        .removeExerciseName(value)
}