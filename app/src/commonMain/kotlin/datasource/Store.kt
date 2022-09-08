package datasource

//import com.benasher44.uuid.uuid4
//import dev.gitlive.firebase.Firebase
//import dev.gitlive.firebase.firestore.FirebaseFirestore
//import dev.gitlive.firebase.firestore.firestore
//import kotlinx.coroutines.CoroutineDispatcher
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.flow.flowOf
//import kotlinx.coroutines.flow.flowOn
//import ui.screens.training.TrainingState
//
//class Store(
//    private val store: FirebaseFirestore = Firebase.firestore,
//    private val dispatcher: CoroutineDispatcher = Dispatchers.Default
//) {
//
//    fun createId(): String = uuid4().toString()
//
//    suspend fun writeTraining(
//        userId: String?,
//        training: TrainingState
//    ) = flowOf(
//        store
//            .collection("user")
//            .document(userId ?: error("invalid user id"))
//            .collection("trainings")
//            .document(createId())
//            .set(training)
//    ).flowOn(dispatcher)
//
//}