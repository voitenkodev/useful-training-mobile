package datasource

import com.google.firebase.auth.FirebaseAuth
import data.source.AuthProtocol
import data.dto.User
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.tasks.await

class AuthSource(
    private val auth: FirebaseAuth,
    private val dispatcher: CoroutineDispatcher
) : AuthProtocol {

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