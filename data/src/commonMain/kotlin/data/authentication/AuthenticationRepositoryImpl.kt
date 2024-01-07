package data.authentication

import AuthenticationRepository
import PreferencesSource
import exercise_examples.ExerciseExamplesSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import network.NetworkSource
import network.models.AuthDto
import network.models.RegisterDto
import traininig_exercise_iteration.TrainingsSource
import user.UserSource

internal class AuthenticationRepositoryImpl(
    private val remote: NetworkSource,
    private val preferences: PreferencesSource,
    private val localTrainings: TrainingsSource,
    private val localExerciseExamoles: ExerciseExamplesSource,
    private val localUser: UserSource
) : AuthenticationRepository {

    override fun registration(
        email: String,
        password: String,
        weight: Double,
        height: Double,
        name: String,
        excludeMuscleIds: List<String>,
        excludeEquipmentIds: List<String>
    ): Flow<Unit> {
        return flow {
            val dto = RegisterDto(
                email = email,
                password = password,
                weight = weight,
                height = height,
                name = name,
                excludeMuscleIds = excludeMuscleIds,
                excludeEquipmentIds = excludeEquipmentIds
            )
            emit(remote.register(dto))
        }.map {
            val token = it.accessToken
            if (token != null) preferences.setToken(token)
        }
    }

    override fun login(email: String, password: String): Flow<Unit> =
        flow {
            emit(remote.login(AuthDto(email, password)))
        }.map {
            val token = it.accessToken
            if (token != null) preferences.setToken(token)
        }

    override fun getToken(): Flow<String?> = preferences.getToken()

    override suspend fun logout() {
        preferences.removeToken()
        localTrainings.clearTables()
        localUser.clearTable()
        localExerciseExamoles.clearTables()
    }
}