package datasource

import co.touchlab.kermit.Logger
import com.benasher44.uuid.uuid4
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot
import dto.Training
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.tasks.await
import state.TrainingState

class TrainingSource(
    private val store: FirebaseFirestore,
    private val dispatcher: CoroutineDispatcher
) {
    suspend fun writeTraining(
        userId: String?,
        training: Training
    ) = flowOf(
        store
            .collection("users")
            .document(userId ?: error("invalid user id"))
            .collection("trainings")
            .document(uuid4().toString())
            .set(training)
            .await()
    ).flowOn(dispatcher)

    suspend fun getTrainings(
        userId: String?,
    ) = flowOf(
        store
            .collection("users")
            .document(userId ?: error("invalid user id"))
            .collection("trainings")
            .get()
            .await()
    ).map {
        it.documents
            .map {
            Logger.i { "object = $it" }
            it.toObject(Training::class.java)
        }
    }.flowOn(dispatcher)

    suspend fun getTraining(
        userId: String?,
        trainingId: String?,
    ) = flowOf(
        store
            .collection("users")
            .document(userId ?: error("invalid user id"))
            .collection("trainings")
            .document(trainingId ?: error("invalid training id"))
            .get()
            .await()
    ).flowOn(dispatcher)
}