package data.source

import data.dto.TrainingBody
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.path
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

internal class TrainingSource(private val client: HttpClient) : TrainingProtocol {

    override suspend fun setTraining(userId: String?, training: TrainingBody): Flow<TrainingBody> = flow {
        val result = client.post {
            url {
                path("/training")
                setBody(training)
                header("Authorization", "Bearer $userId")
            }
        }
        emit(training)
    }

    override suspend fun getTrainings(userId: String?): Flow<List<TrainingBody>> = flow {
        val result = client.get {
            url {
                path("/trainings")
                header("Authorization", "Bearer $userId")
            }
        }
        emit(result.body())
    }

    override suspend fun getTraining(userId: String?, trainingId: String): Flow<TrainingBody> = flow {
        val result = client.get {
            url {
                path("/training/$trainingId")
                header("Authorization", "Bearer $userId")
            }
        }
        emit(result.body())
    }

    override suspend fun deleteTraining(userId: String?, trainingId: String): Flow<Unit> {
        TODO("Not yet implemented")
    }
}