import data.dto.ShortTrainingDto
import data.dto.TrainingDto
import data.dto.UserDto
import data.source.AuthProtocol
import data.source.TrainingProtocol
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Runnable
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import platform.darwin.dispatch_async
import platform.darwin.dispatch_get_main_queue
import kotlin.coroutines.CoroutineContext
import kotlin.native.concurrent.freeze

internal actual class AuthSource : AuthProtocol {

    override fun login(email: String, password: String): Flow<UserDto> = flow {
        emit(UserDto(uid = "123", displayName = "Test Name", email = "example@com.dev"))
    }

    override fun registration(email: String, password: String): Flow<UserDto> = flow {
        emit(UserDto(uid = "123", displayName = "Test Name", email = "example@com.dev"))
    }

    override fun logout(): Flow<Unit> = flow { emit(Unit) }

    override val isAuthorized: Boolean = true

    override val userDto: UserDto = UserDto(uid = "123", displayName = "Test Name", email = "example@com.dev")
}

internal actual class TrainingSource : TrainingProtocol {
    override suspend fun setTraining(
        userId: String?,
        trainingId: String,
        trainingDto: TrainingDto
    ): Flow<Unit> = flow { emit(Unit) }

    override suspend fun removeTraining(userId: String?, trainingId: String): Flow<Unit> = flow { emit(Unit) }

    override suspend fun removeShortTraining(userId: String?, trainingId: String): Flow<Unit> = flow { emit(Unit) }

    override suspend fun getTrainings(
        userId: String?,
    ): Flow<List<TrainingDto>> = flow { emit(emptyList()) }

    override suspend fun getShortTrainings(
        userId: String?,
    ): Flow<List<ShortTrainingDto>> = flow { emit(emptyList()) }

    override suspend fun setShortTraining(
        userId: String?,
        trainingId: String,
        training: ShortTrainingDto
    ): Flow<Unit> = flow { emit(Unit) }
}