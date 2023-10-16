import io.ktor.client.call.body
import io.ktor.client.request.request
import io.ktor.client.request.setBody
import io.ktor.http.HttpMethod
import io.ktor.http.contentType
import io.ktor.http.path
import models.AuthDto
import models.ExerciseDateDto
import models.TokenDto
import models.TrainingDto

class NetworkSource(private val clientBackend: ClientBackend) {

    suspend fun setTraining(body: TrainingDto): String {
        return callRequest(
            method = HttpMethod.Post,
            path = "/training",
            body = body
        )
    }

    suspend fun getTrainings(): List<TrainingDto> {
        return callRequest(
            method = HttpMethod.Get,
            path = "/trainings"
        )
    }

    suspend fun getExercises(query: String): List<ExerciseDateDto> {
        return callRequest(
            method = HttpMethod.Get,
            path = "/exercises",
            queryParams = mapOf("name" to query)
        )
    }

    suspend fun getTraining(trainingId: String): TrainingDto {
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

    suspend fun login(body: AuthDto): TokenDto {
        return callRequest(
            method = HttpMethod.Post,
            path = "/login",
            body = body
        )
    }

    suspend fun registration(body: AuthDto): TokenDto {
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