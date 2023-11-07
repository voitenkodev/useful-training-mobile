import io.ktor.client.call.body
import io.ktor.client.request.request
import io.ktor.client.request.setBody
import io.ktor.http.HttpMethod
import io.ktor.http.contentType
import io.ktor.http.path
import models.AuthDto
import models.ExerciseExampleDto
import models.MuscleDto
import models.RegisterDto
import models.TokenDto
import models.TrainingDto
import models.UserDto

public class NetworkSource(private val clientBackend: ClientBackend) {

    public suspend fun login(body: AuthDto): TokenDto {
        return callRequest(
            method = HttpMethod.Post,
            path = "/auth/login",
            body = body
        )
    }

    public suspend fun register(body: RegisterDto): TokenDto {
        return callRequest(
            method = HttpMethod.Post,
            path = "/auth/register",
            body = body
        )
    }

    public suspend fun getTrainings(startDate: String, endDate: String): List<TrainingDto> {
        return callRequest(
            method = HttpMethod.Get,
            path = "/trainings",
            queryParams = mapOf(
                "start" to startDate,
                "end" to endDate
            )
        )
    }

    public suspend fun setTraining(body: TrainingDto): TrainingDto {
        return callRequest(
            method = HttpMethod.Post,
            path = "/trainings",
            body = body
        )
    }

    public suspend fun getTraining(trainingId: String): TrainingDto {
        return callRequest(
            method = HttpMethod.Get,
            path = "/trainings/$trainingId"
        )
    }

    public suspend fun getExerciseExamples(): List<ExerciseExampleDto> {
        return callRequest(
            method = HttpMethod.Get,
            path = "/exercise-examples"
        )
    }

    public suspend fun setExerciseExample(body: ExerciseExampleDto): ExerciseExampleDto {
        return callRequest(
            method = HttpMethod.Post,
            path = "/exercise-examples",
            body = body
        )
    }

    public suspend fun getExerciseExample(exerciseExampleId: String): ExerciseExampleDto {
        return callRequest(
            method = HttpMethod.Get,
            path = "/exercise-examples/$exerciseExampleId"
        )
    }

    public suspend fun getMuscles(): List<MuscleDto> {
        return callRequest(
            method = HttpMethod.Get,
            path = "/muscles"
        )
    }

    public suspend fun getUser(): UserDto {
        return callRequest(
            method = HttpMethod.Get,
            path = "/users/profile"
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