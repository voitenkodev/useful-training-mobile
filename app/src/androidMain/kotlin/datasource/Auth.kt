package datasource

import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.tasks.await

class Auth(
    private val auth: FirebaseAuth = Firebase.auth,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) {

    suspend fun login(email: String, password: String): Flow<AuthResult> =
        flowOf(auth.signInWithEmailAndPassword(email, password).await())
            .flowOn(dispatcher)

    suspend fun registration(email: String, password: String): Flow<AuthResult> =
        flowOf(auth.signInWithEmailAndPassword(email, password).await())
            .flowOn(dispatcher)

    val isAuthorized: Boolean = auth.currentUser != null

    val user: FirebaseUser? = auth.currentUser
}