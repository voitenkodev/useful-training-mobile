package data.source.network

import data.dto.TrainingBody
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.path
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

internal interface TrainingProtocol {

    suspend fun setTraining(training: TrainingBody): Flow<String>

    suspend fun getTrainings(): Flow<List<TrainingBody>>

    suspend fun getTraining(trainingId: String): Flow<TrainingBody>

    suspend fun deleteTraining(trainingId: String): Flow<Unit>
}

internal class TrainingSource(private val client: HttpClient) : TrainingProtocol {

    override suspend fun setTraining(training: TrainingBody): Flow<String> = flow {
        val result = client.post {
            url {
                path("/training")
                setBody(training)
            }
        }
        emit(result.body())
    }

    override suspend fun getTrainings(): Flow<List<TrainingBody>> = flow {
        val result = client.get {
            url {
                path("/trainings")
            }
        }
        emit(result.body())
    }

    override suspend fun getTraining(trainingId: String): Flow<TrainingBody> = flow {
        val result = client.get {
            url {
                path("/training/$trainingId")
            }
        }
        emit(result.body())
    }

    override suspend fun deleteTraining(trainingId: String): Flow<Unit> {
        TODO("Not yet implemented")
    }
}