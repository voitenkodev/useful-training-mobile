package data.authentication

import AuthenticationRepository
import NetworkSource
import PreferencesSource
import exercise_example_muscle.ExerciseExamplesSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import models.AuthDto
import models.RegisterDto
import traininig_exercise_iteration.TrainingsSource
import user_weight.UserSource

internal class AuthenticationRepositoryImpl(
    private val remote: NetworkSource,
    private val preferences: PreferencesSource,
    private val localTrainings: TrainingsSource,
    private val localExerciseExamoles: ExerciseExamplesSource,
    private val localUser: UserSource
) : AuthenticationRepository {

    override fun registration(email: String, password: String, weight: Double, height: Double, name: String): Flow<Unit> {
        return flow {
            val dto = RegisterDto(
                email = email,
                password = password,
                weight = weight,
                height = height,
                name = name
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