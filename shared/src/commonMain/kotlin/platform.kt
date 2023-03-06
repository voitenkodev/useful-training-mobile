import data.dto.UserDto
import data.source.AuthProtocol
import data.source.TrainingProtocol
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.auth.FirebaseAuth
import dev.gitlive.firebase.auth.auth
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlin.coroutines.CoroutineContext

//internal class AuthSource : AuthProtocol {
//
//    private val auth: FirebaseAuth = Firebase.auth
//
//    override fun login(email: String, password: String): Flow<UserDto> = flow {
//        emit(auth.signInWithEmailAndPassword(email, password))
//    }.map {
//        UserDto(
//            uid = it.user?.uid,
//            displayName = it.user?.displayName,
//            email = it.user?.email
//        )
//    } // .flowOn(dispatcher)
//
//    override fun registration(email: String, password: String): Flow<UserDto> = flow {
//        emit(auth.createUserWithEmailAndPassword(email, password))
//    }.map {
//        UserDto(
//            uid = it.user?.uid,
//            displayName = it.user?.displayName,
//            email = it.user?.email
//        )
//    } // .flowOn(dispatcher)
//
//    override fun logout(): Flow<Unit> =
//        flow {
//            emit(auth.signOut())
//        }
//    //.flowOn(dispatcher)
//
//    override val isAuthorized: Boolean = auth.currentUser != null
//    override val userDto: UserDto?
//        get() = auth.currentUser?.let {
//            UserDto(
//                uid = it.uid,
//                displayName = it.displayName,
//                email = it.email
//            )
//        }
//}

internal expect class AuthSource() : AuthProtocol

internal expect class TrainingSource() : TrainingProtocol