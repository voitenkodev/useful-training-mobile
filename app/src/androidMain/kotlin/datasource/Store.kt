package datasource

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.util.Util
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.tasks.await
import models.Training

class Store(
    private val store: FirebaseFirestore = FirebaseFirestore.getInstance(),
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) {

    fun createId() = Util.autoId()

    private suspend fun writeTraining(
        userId: String,
        training: Training
    ) = flowOf(
        store
            .collection("user")
            .document(userId)
            .collection("trainings")
            .document()
            .set(training)
            .await()
    ).flowOn(dispatcher)

}