package presentation.training

import ComposeCoroutineContext
import data.mapping.toTraining
import data.repository.TrainingRepository
import globalKoin
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import presentation.review.ReviewAction

class TrainingPresenter(val dispatcher: (Any) -> Any) : ComposeCoroutineContext() {

    private val api = globalKoin().get<TrainingRepository>()

    fun saveTraining(training: Training, success: () -> Unit) = call {
        api.setTraining(training = training.toTraining())
            .onEach {
                dispatcher(ReviewAction.FetchTrainings(selected = training))
                success.invoke()
            }
            .catch { }
            .launchIn(this)
    }
}