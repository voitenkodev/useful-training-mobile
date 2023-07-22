package source.network

import NativeContext
import dto.AuthDTO
import dto.ExerciseDateDTO
import dto.TokenDTO
import dto.TrainingDTO
import io.ktor.client.call.body
import io.ktor.client.request.delete
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.path
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import source.datastore.PreferencesSource

class NetworkSource(
    nativeContext: NativeContext,
    preferencesSource: PreferencesSource
) {

    private val client = Client(nativeContext, preferencesSource).setup()

    suspend fun setTraining(training: TrainingDTO): Flow<String> = flow {
        val result = client.post {
            url {
                path("/training")
                setBody(training)
            }
        }
        emit(result.body())
    }

    suspend fun getTrainings(): Flow<List<TrainingDTO>> = flow {
        val result = client.get {
            url {
                path("/trainings")
            }
        }
        emit(result.body())
    }

    suspend fun getExercises(query: String): Flow<List<ExerciseDateDTO>> = flow {
        val result = client.get {
            url {
                path("/exercises")
                parameters.append("name", query)
            }
        }
        emit(result.body())
    }

    suspend fun getTraining(trainingId: String): Flow<TrainingDTO> = flow {
        val result = client.get {
            url {
                path("/training/$trainingId")
            }
        }
        emit(result.body())
    }

    suspend fun deleteTraining(trainingId: String): Flow<Unit> = flow {
        client.delete {
            url {
                path("/training")
                parameters.append("id", trainingId)
            }
        }
        emit(Unit)
    }

    fun login(email: String, password: String): Flow<TokenDTO> = flow {
        val result = client.post {
            url {
                path("/login")
                setBody(AuthDTO(email, password))
            }
        }
        emit(result.body())
    }

    fun registration(email: String, password: String): Flow<TokenDTO> = flow {
        val result = client.post {
            url {
                path("/register")
                setBody(AuthDTO(email, password))
            }
        }
        emit(result.body<TokenDTO>())
    }
}