import androidx.activity.OnBackPressedCallback
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import data.dto.ShortTraining
import data.dto.Training
import data.dto.User
import data.source.AuthProtocol
import data.source.TrainingProtocol
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.tasks.await
import kotlin.coroutines.CoroutineContext

actual class AuthSource : AuthProtocol {

    private val auth: FirebaseAuth = FirebaseAuth.getInstance()
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO


    override fun login(email: String, password: String): Flow<User> =
        flow {
            emit(auth.signInWithEmailAndPassword(email, password).await())
        }.map {
            User(
                uid = it.user?.uid,
                displayName = it.user?.displayName,
                email = it.user?.email
            )
        }.flowOn(dispatcher)

    override fun registration(email: String, password: String): Flow<User> =
        flow {
            emit(auth.createUserWithEmailAndPassword(email, password).await())
        }.map {
            User(
                uid = it.user?.uid,
                displayName = it.user?.displayName,
                email = it.user?.email
            )
        }.flowOn(dispatcher)

    override fun logout(): Flow<Unit> =
        flow {
            emit(auth.signOut())
        }.flowOn(dispatcher)

    override val isAuthorized: Boolean = auth.currentUser != null

    override val user: User?
        get() = auth.currentUser?.let {
            User(
                uid = it.uid,
                displayName = it.displayName,
                email = it.email
            )
        }
}

actual class TrainingSource : TrainingProtocol {

    private val store: FirebaseFirestore = FirebaseFirestore.getInstance()
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO

    override suspend fun setTraining(
        userId: String?,
        trainingId: String,
        training: Training
    ): Flow<Unit> = flow {
        emit(
            store
                .collection("users")
                .document(userId ?: throw Exception("invalid user id"))
                .collection("trainings")
                .document(trainingId)
                .set(training)
                .await()
        )
    }.map { }.flowOn(dispatcher)

    override suspend fun removeTraining(userId: String?, trainingId: String): Flow<Unit> = flow {
        emit(
            store
                .collection("users")
                .document(userId ?: throw Exception("invalid user id"))
                .collection("trainings")
                .document(trainingId)
                .delete()
                .await()
        )
    }.map { }.flowOn(dispatcher)

    override suspend fun removeShortTraining(userId: String?, trainingId: String): Flow<Unit> = flow {
        emit(
            store
                .collection("users")
                .document(userId ?: throw Exception("invalid user id"))
                .collection("trainings_short")
                .document(trainingId)
                .delete()
                .await()
        )
    }.map { }.flowOn(dispatcher)

    override suspend fun getTrainings(
        userId: String?,
    ): Flow<List<Training>> = flow {
        emit(
            store
                .collection("users")
                .document(userId ?: error("invalid user id"))
                .collection("trainings")
                .orderBy("date", Query.Direction.DESCENDING)
                .get()
                .await()
        )
    }.map {
        it.documents.mapNotNull { it.toObject(Training::class.java)?.copy(id = it.id) }
    }.flowOn(dispatcher)

    override suspend fun getShortTrainings(
        userId: String?,
    ): Flow<List<ShortTraining>> = flow {
        emit(
            store
                .collection("users")
                .document(userId ?: error("invalid user id"))
                .collection("trainings_short")
                .orderBy("date", Query.Direction.DESCENDING)
                .get()
                .await()
        )
    }.map {
        it.documents.mapNotNull { it.toObject(ShortTraining::class.java)?.copy(id = it.id) }
    }.flowOn(dispatcher)

    override suspend fun setShortTraining(
        userId: String?,
        trainingId: String,
        training: ShortTraining
    ): Flow<Unit> = flow {
        emit(
            store
                .collection("users")
                .document(userId ?: throw Exception("invalid user id"))
                .collection("trainings_short")
                .document(trainingId)
                .set(training)
                .await()
        )
    }.map { }.flowOn(dispatcher)
}

