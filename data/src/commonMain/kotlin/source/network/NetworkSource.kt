package source.network

import dto.backend.AuthDTO
import dto.backend.ExerciseDateDTO
import dto.backend.TokenDTO
import dto.backend.TrainingDTO
import dto.openai.OpenAIResponse
import io.ktor.client.call.body
import io.ktor.client.request.delete
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.contentType
import io.ktor.http.path

class NetworkSource(
    private val clientBackend: ClientBackend
) {
    suspend fun setTraining(training: TrainingDTO): String {
        return clientBackend.setup().post {
            url {
                path("/training")
                setBody(training)
            }
        }.body()
    }

    suspend fun getTrainings(): List<TrainingDTO> {
        return clientBackend.setup().get {
            url {
                path("/trainings")
            }
            contentType()
        }.body<List<TrainingDTO>>()
    }

    suspend fun getExercises(query: String): List<ExerciseDateDTO> {
        return clientBackend.setup().get {
            url {
                path("/exercises")
                parameters.append("name", query)
            }
        }.body()
    }

    suspend fun getTraining(trainingId: String): TrainingDTO {
        return clientBackend.setup().get {
            url {
                path("/training/$trainingId")
            }
        }.body()
    }

    suspend fun deleteTraining(trainingId: String) {
        clientBackend.setup().delete {
            url {
                path("/training")
                parameters.append("id", trainingId)
            }
        }
    }

    suspend fun login(email: String, password: String): TokenDTO {
        return clientBackend.setup().post {
            url {
                path("/login")
                setBody(AuthDTO(email, password))
            }
        }.body()
    }

    suspend fun registration(email: String, password: String): TokenDTO {
        return clientBackend.setup().post {
            url {
                path("/register")
                setBody(AuthDTO(email, password))
            }
        }.body()
    }

    fun generateViaOpenAI(prompt: String): OpenAIResponse? {
//        val result = clientOpenAI.post {
//            url {
//                path("/v1/engines/davinci/completions")
//                setBody(
//                    mapOf(
//                        "prompt" to prompt,
//                        "max_tokens" to 50 // Adjust as needed
//                    )
//                )
//            }
//        }
//        emit(result.body<OpenAIResponse>())
        return null
    }
}