package network

import io.ktor.client.call.body
import io.ktor.client.request.request
import io.ktor.client.request.setBody
import io.ktor.http.HttpMethod
import io.ktor.http.contentType
import io.ktor.http.path
import network.models.AuthDto
import network.models.EquipmentGroupDto
import network.models.ExcludedEquipmentDto
import network.models.ExcludedMuscleDto
import network.models.ExerciseExampleAchievementsDto
import network.models.ExerciseExampleCriteriaBody
import network.models.ExerciseExampleDto
import network.models.ExerciseExampleFiltersBody
import network.models.ExerciseExampleFiltersDto
import network.models.MuscleDto
import network.models.MuscleGroupDto
import network.models.RegisterDto
import network.models.TokenDto
import network.models.TrainingDto
import network.models.UserDto
import network.models.WeightHistoryDto

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

    public suspend fun getExerciseExamples(
        page: Int,
        size: Int,
        query: String?,
        weightType: String?,
        forceType: String?,
        experience: String?,
        category: String?,
        muscleIds: List<String>,
        equipmentIds: List<String>
    ): List<ExerciseExampleDto> {
        return callRequest(
            method = HttpMethod.Post,
            path = "/exercise-examples/all",
            queryParams = buildMap {
                put("page", page.toString())
                put("size", size.toString())
            },
            body = ExerciseExampleFiltersBody(
                category = category,
                equipmentIds = equipmentIds,
                experience = experience,
                forceType = forceType,
                muscleIds = muscleIds,
                query = query,
                weightType = weightType
            )
        )
    }

    public suspend fun getRecommendedExerciseExamples(
        page: Int,
        size: Int,
        exerciseCount: Int?,
        targetMuscleId: String?,
        exerciseExampleIds: List<String>
    ): List<ExerciseExampleDto> {
        return callRequest(
            method = HttpMethod.Post,
            path = "/exercise-examples/recommended",
            queryParams = buildMap {
                put("page", page.toString())
                put("size", size.toString())
            },
            body = ExerciseExampleCriteriaBody(
                exerciseCount = exerciseCount,
                exerciseExampleIds = exerciseExampleIds,
                targetMuscleId = targetMuscleId
            )
        )
    }

    public suspend fun getExerciseExampleFilters(): ExerciseExampleFiltersDto {
        return callRequest(
            method = HttpMethod.Get,
            path = "/filters"
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

    public suspend fun getExerciseExampleAchievements(exerciseExampleId: String, size: Int): ExerciseExampleAchievementsDto {
        return callRequest(
            method = HttpMethod.Get,
            path = "/statistics/achievements/exercise-example",
            queryParams = mapOf(
                "id" to exerciseExampleId,
                "size" to size.toString()
            ),
        )
    }

    public suspend fun getUserMuscles(): List<MuscleGroupDto> {
        return callRequest(
            method = HttpMethod.Get,
            path = "/user-muscles"
        )
    }

    public suspend fun getPublicMuscles(): List<MuscleGroupDto> {
        return callRequest(
            method = HttpMethod.Get,
            path = "/public-muscles"
        )
    }

    public suspend fun getUserEquipments(): List<EquipmentGroupDto> {
        return callRequest(
            method = HttpMethod.Get,
            path = "/user-equipments"
        )
    }

    public suspend fun getPublicEquipments(): List<EquipmentGroupDto> {
        return callRequest(
            method = HttpMethod.Get,
            path = "/public-equipments"
        )
    }

    public suspend fun getUserMuscleById(id: String): MuscleDto {
        return callRequest(
            method = HttpMethod.Get,
            path = "/user-muscles/$id"
        )
    }

    public suspend fun getUser(): UserDto {
        return callRequest(
            method = HttpMethod.Get,
            path = "/users/profile"
        )
    }

    public suspend fun deleteExcludedMuscle(id: String): ExcludedMuscleDto {
        return callRequest(
            method = HttpMethod.Delete,
            path = "/excluded-muscles/$id"
        )
    }

    public suspend fun setExcludedMuscle(id: String): ExcludedMuscleDto {
        return callRequest(
            method = HttpMethod.Post,
            path = "/excluded-muscles/$id"
        )
    }

    public suspend fun deleteExcludedEquipment(id: String): ExcludedEquipmentDto {
        return callRequest(
            method = HttpMethod.Delete,
            path = "/excluded-equipments/$id"
        )
    }

    public suspend fun setExcludedEquipment(id: String): ExcludedEquipmentDto {
        return callRequest(
            method = HttpMethod.Post,
            path = "/excluded-equipments/$id"
        )
    }

    public suspend fun updateWeightHistory(value: Double): WeightHistoryDto {
        return callRequest(
            method = HttpMethod.Post,
            path = "/weight-history",
            body = WeightHistoryDto(weight = value)
        )
    }

    public suspend fun getWeightHistory(): List<WeightHistoryDto> {
        return callRequest(
            method = HttpMethod.Get,
            path = "/weight-history"
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