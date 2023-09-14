package repository

import dto.backend.ExerciseDateDTO
import dto.backend.TrainingDTO
import kotlinx.coroutines.flow.Flow
import source.database.DataBaseSource
import source.network.NetworkSource

class TrainingRepositoryImpl(
    private val remote: NetworkSource,
    private val local: DataBaseSource
) : TrainingRepository {

    override suspend fun getTrainings(): Flow<List<TrainingDTO>> = remote
        .getTrainings()

    override suspend fun getTraining(trainingId: String): Flow<TrainingDTO> = remote
        .getTraining(trainingId)

    override suspend fun getExercises(query: String): Flow<List<ExerciseDateDTO>> = remote
        .getExercises(query)

    override suspend fun setTraining(training: TrainingDTO): Flow<String> = remote
        .setTraining(training = training)

    override suspend fun removeTraining(trainingId: String): Flow<Unit> = remote
        .deleteTraining(trainingId = trainingId)

    override suspend fun setExerciseNameOptions(names: List<String>) = local
        .setExerciseNames(names)

    override suspend fun getExerciseNameOptions() = local
        .getExerciseNames()

    override suspend fun removeExerciseNameOption(value: String) = local
        .removeExerciseName(value)
}