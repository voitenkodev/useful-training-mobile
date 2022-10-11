import data.dto.ShortTraining
import data.dto.Training
import data.dto.User
import data.source.AuthProtocol
import data.source.TrainingProtocol
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

actual class AuthSource : AuthProtocol {

    override fun login(email: String, password: String): Flow<User> = flow {
        emit(User(uid = "123", displayName = "Test Name", email = "example@com.dev"))
    }

    override fun registration(email: String, password: String): Flow<User> = flow {
        emit(User(uid = "123", displayName = "Test Name", email = "example@com.dev"))
    }

    override fun logout(): Flow<Unit> = flow { emit(Unit) }

    override val isAuthorized: Boolean = true

    override val user: User = User(uid = "123", displayName = "Test Name", email = "example@com.dev")
}

actual class TrainingSource : TrainingProtocol {
    override suspend fun setTraining(
        userId: String?,
        trainingId: String,
        training: Training
    ): Flow<Unit> = flow { emit(Unit) }

    override suspend fun removeTraining(userId: String?, trainingId: String): Flow<Unit> = flow { emit(Unit) }

    override suspend fun removeShortTraining(userId: String?, trainingId: String): Flow<Unit> = flow { emit(Unit) }

    override suspend fun getTrainings(
        userId: String?,
    ): Flow<List<Training>> = flow { emit(emptyList()) }

    override suspend fun getShortTrainings(
        userId: String?,
    ): Flow<List<ShortTraining>> = flow { emit(emptyList()) }

    override suspend fun setShortTraining(
        userId: String?,
        trainingId: String,
        training: ShortTraining
    ): Flow<Unit> = flow { emit(Unit) }
}
