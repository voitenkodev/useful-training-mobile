package presentation.review

import ComposeCoroutineContext
import data.repository.TrainingRepository
import globalKoin
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class ReviewPresenter(val dispatcher: (Any) -> Any) : ComposeCoroutineContext() {

    private val api = globalKoin().get<TrainingRepository>()

    fun removeTraining(trainingId: String?, success: () -> Unit) = call {
        api
            .removeTraining(trainingId = trainingId ?: error("invalid Training ID"))
            .onEach { success.invoke() }
            .catch { }
            .launchIn(this)
    }
}