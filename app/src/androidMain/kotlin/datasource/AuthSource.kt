package datasource

import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.tasks.await

class AuthSource(
    private val auth: FirebaseAuth,
    private val dispatcher: CoroutineDispatcher
) {

    suspend fun login(email: String, password: String): Flow<AuthResult> =
        flowOf(auth.signInWithEmailAndPassword(email, password).await())
            .flowOn(dispatcher)

    suspend fun registration(email: String, password: String): Flow<AuthResult> =
        flowOf(auth.createUserWithEmailAndPassword(email, password).await())
            .flowOn(dispatcher)

    fun logout(): Flow<Unit> =
        flowOf(auth.signOut())
            .flowOn(dispatcher)

    val isAuthorized: Boolean = auth.currentUser != null

    val user: FirebaseUser? get() = auth.currentUser
}