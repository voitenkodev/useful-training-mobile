package presentation.training

import ComposeCoroutineContext
import data.mapping.toTraining
import data.mapping.toTrainingState
import data.repository.TrainingRepository
import globalKoin
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import presentation.review.ReviewAction

class TrainingPresenter(val dispatcher: (Any) -> Any) : ComposeCoroutineContext() {

    private val api = globalKoin().get<TrainingRepository>()

    fun saveTraining(training: Training, success: () -> Unit) {
        call {
            api.setTraining(training = training.toTraining())
                .onStart { dispatcher(TrainingAction.Loading(true)) }
                .onEach {
                    dispatcher(TrainingAction.Loading(false))
                    dispatcher(ReviewAction.FetchTrainings(selected = it.toTrainingState()))
                    success.invoke()
                }
                .catch {
                    dispatcher(TrainingAction.Error(it.message))
                    dispatcher(TrainingAction.Loading(false))
                }
                .launchIn(this)
        }
    }
}