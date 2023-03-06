package data.repository

import com.benasher44.uuid.uuid4
import data.dto.ShortTrainingDto
import data.dto.TrainingDto
import data.mapping.toShortTraining
import data.source.AuthProtocol
import data.source.TrainingProtocol
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlin.coroutines.CoroutineContext

internal class TrainingRepositoryImpl(
    private val authSource: AuthProtocol,
    private val trainingSource: TrainingProtocol,
//    private val dispatcher: CoroutineContext
) : TrainingRepository {

    override suspend fun getShortTrainings(): Flow<List<ShortTrainingDto>> = trainingSource
        .getShortTrainings(userId = authSource.userDto?.uid)
        //.flowOn(dispatcher)

    override suspend fun getTrainings(): Flow<List<TrainingDto>> = trainingSource
        .getTrainings(userId = authSource.userDto?.uid)
        //.flowOn(dispatcher)

    override suspend fun setTraining(trainingDto: TrainingDto): Flow<TrainingDto> {
        val id = trainingDto.id ?: uuid4().toString()

        return trainingSource
            .setTraining(
                userId = authSource.userDto?.uid,
                trainingId = id,
                trainingDto = trainingDto
            ).combine(
                trainingSource.setShortTraining(
                    authSource.userDto?.uid,
                    trainingId = id,
                    training = trainingDto.toShortTraining()
                )
            ) { _, _ -> }
            .map { trainingDto.copy(id = id) }
         //   .flowOn(dispatcher)
    }

    override suspend fun removeTraining(trainingId: String): Flow<Unit> = trainingSource
        .removeTraining(
            userId = authSource.userDto?.uid,
            trainingId = trainingId,
        ).combine(
            trainingSource.removeShortTraining(
                userId = authSource.userDto?.uid,
                trainingId = trainingId
            )
        ) { _, _ -> }
        //.flowOn(dispatcher)
}