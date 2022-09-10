package datasource

import com.benasher44.uuid.uuid4
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.tasks.await
import training.TrainingState

class TrainingSource(
    private val store: FirebaseFirestore,
    private val dispatcher: CoroutineDispatcher
) {
    suspend fun writeTraining(
        userId: String?,
        training: TrainingState
    ) = flowOf(
        store
            .collection("users")
            .document(userId ?: error("invalid user id"))
            .collection("trainings")
            .document(uuid4().toString())
            .set(training)
            .await()
    ).flowOn(dispatcher)
}