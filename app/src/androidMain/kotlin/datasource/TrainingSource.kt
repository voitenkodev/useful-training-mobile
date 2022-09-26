package datasource

import com.benasher44.uuid.uuid4
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import dto.Training
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.tasks.await

class TrainingSource(
    private val store: FirebaseFirestore,
    private val dispatcher: CoroutineDispatcher
) {
    suspend fun writeTraining(
        userId: String?,
        training: Training
    ) = flow {
        emit(
            store
                .collection("users")
                .document(userId ?: throw Exception("invalid user id"))
                .collection("trainings")
                .document(uuid4().toString())
                .set(training)
                .await()
        )
    }.flowOn(dispatcher)

    suspend fun getTrainings(
        userId: String?,
    ) = flow {
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

    suspend fun getTraining(
        userId: String?,
        trainingId: String?,
    ) = flow {
        emit(
            store
                .collection("users")
                .document(userId ?: error("invalid user id"))
                .collection("trainings")
                .document(trainingId ?: error("invalid training id"))
                .get()
                .await()
        )
    }.flowOn(dispatcher)
}