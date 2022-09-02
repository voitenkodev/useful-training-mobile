package datasource

import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.tasks.await

class Auth(private val auth: FirebaseAuth = Firebase.auth) {

    suspend fun login(email: String, password: String): Flow<AuthResult> =
        flowOf(auth.signInWithEmailAndPassword(email, password).await())

    suspend fun registration(email: String, password: String): Flow<AuthResult> =
        flowOf(auth.signInWithEmailAndPassword(email, password).await())

    val isAuthorized: Boolean = auth.currentUser != null

    val user: FirebaseUser? = auth.currentUser
}