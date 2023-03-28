package data.source.network

import data.dto.ExerciseDateDTO
import data.dto.TrainingDTO
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.delete
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.path
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

internal interface TrainingProtocol {

    suspend fun setTraining(training: TrainingDTO): Flow<String>

    suspend fun getTrainings(): Flow<List<TrainingDTO>>

    suspend fun getExercises(query: String): Flow<List<ExerciseDateDTO>>

    suspend fun getTraining(trainingId: String): Flow<TrainingDTO>

    suspend fun deleteTraining(trainingId: String): Flow<Unit>
}

internal class TrainingSource(private val client: HttpClient) : TrainingProtocol {

    override suspend fun setTraining(training: TrainingDTO): Flow<String> = flow {
        val result = client.post {
            url {
                path("/training")
                setBody(training)
            }
        }
        emit(result.body())
    }

    override suspend fun getTrainings(): Flow<List<TrainingDTO>> = flow {
        val result = client.get {
            url {
                path("/trainings")
            }
        }
        emit(result.body())
    }

    override suspend fun getExercises(query: String): Flow<List<ExerciseDateDTO>> = flow {
        val result = client.get {
            url {
                path("/exercises")
                parameters.append("name", query)
            }
        }
        emit(result.body())
    }

    override suspend fun getTraining(trainingId: String): Flow<TrainingDTO> = flow {
        val result = client.get {
            url {
                path("/training/$trainingId")
            }
        }
        emit(result.body())
    }

    override suspend fun deleteTraining(trainingId: String): Flow<Unit> = flow {
        client.delete {
            url {
                path("/training")
                parameters.append("id", trainingId)
            }
        }
        emit(Unit)
    }
}