package datasource

import com.benasher44.uuid.uuid4
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import data.dto.ShortTraining
import data.dto.Training
import data.source.TrainingProtocol
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.tasks.await

class TrainingSource(
    private val store: FirebaseFirestore,
    private val dispatcher: CoroutineDispatcher
) : TrainingProtocol {
    override suspend fun setTraining(
        userId: String?,
        trainingId: String?,
        training: Training
    ): Flow<Unit> = flow {
        emit(
            store
                .collection("users")
                .document(userId ?: throw Exception("invalid user id"))
                .collection("trainings")
                .document(trainingId ?: uuid4().toString())
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

    override suspend fun setShortTraining(
        userId: String?,
        trainingId: String?,
        training: ShortTraining
    ): Flow<Unit> = flow {
        emit(
            store
                .collection("users")
                .document(userId ?: throw Exception("invalid user id"))
                .collection("trainings_short")
                .document(trainingId ?: uuid4().toString())
                .set(training)
                .await()
        )
    }.map { }.flowOn(dispatcher)
}