package datasource

import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.auth.AuthResult
import dev.gitlive.firebase.auth.FirebaseAuth
import dev.gitlive.firebase.auth.FirebaseUser
import dev.gitlive.firebase.auth.auth
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.flowOn

class Auth(
    private val auth: FirebaseAuth = Firebase.auth,
    private val dispatcher: CoroutineDispatcher = Dispatchers.Default
) {

    suspend fun login(email: String, password: String): Flow<AuthResult> =
        flowOf(auth.signInWithEmailAndPassword(email, password))
            .flowOn(dispatcher)

    suspend fun registration(email: String, password: String): Flow<AuthResult> =
        flowOf(auth.signInWithEmailAndPassword(email, password))
            .flowOn(dispatcher)

    val isAuthorized: Boolean = auth.currentUser != null

    val user: FirebaseUser? = auth.currentUser
}