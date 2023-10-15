package source.network

import dto.backend.AuthDTO
import dto.backend.ExerciseDateDTO
import dto.backend.TokenDTO
import dto.backend.TrainingDTO
import io.ktor.client.call.body
import io.ktor.client.request.request
import io.ktor.client.request.setBody
import io.ktor.http.HttpMethod
import io.ktor.http.contentType
import io.ktor.http.path

class NetworkSource(private val clientBackend: ClientBackend) {

    suspend fun setTraining(body: TrainingDTO): String {
        return callRequest(
            method = HttpMethod.Post,
            path = "/training",
            body = body
        )
    }

    suspend fun getTrainings(): List<TrainingDTO> {
        return callRequest(
            method = HttpMethod.Get,
            path = "/trainings"
        )
    }

    suspend fun getExercises(query: String): List<ExerciseDateDTO> {
        return callRequest(
            method = HttpMethod.Get,
            path = "/exercises",
            queryParams = mapOf("name" to query)
        )
    }

    suspend fun getTraining(trainingId: String): TrainingDTO {
        return callRequest(
            method = HttpMethod.Get,
            path = "/training/$trainingId"
        )
    }

    suspend fun deleteTraining(trainingId: String) {
        callRequest<Unit>(
            method = HttpMethod.Delete,
            path = "/training",
            queryParams = mapOf("id" to trainingId)
        )
    }

    suspend fun login(body: AuthDTO): TokenDTO {
        return callRequest(
            method = HttpMethod.Post,
            path = "/login",
            body = body
        )
    }

    suspend fun registration(body: AuthDTO): TokenDTO {
        return callRequest(
            method = HttpMethod.Post,
            path = "/register",
            body = body
        )
    }

    private suspend inline fun <reified T> callRequest(
        method: HttpMethod,
        path: String,
        body: Any? = null,
        queryParams: Map<String, String>? = null
    ): T {
        val response = clientBackend.setup().request {
            url {
                this.path(path)
                queryParams?.forEach { (key, value) ->
                    parameters.append(key, value)
                }
                if (body != null) {
                    setBody(body)
                }
            }
            contentType()
            this.method = method
        }

        return response.body<T>()
    }
}