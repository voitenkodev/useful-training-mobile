package presentation.training

import ComposeCoroutineContext
import data.mapping.toTraining
import data.repository.TrainingRepository
import globalKoin
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class TrainingPresenter(val dispatcher: (Any) -> Any) : ComposeCoroutineContext() {

    private val api = globalKoin().get<TrainingRepository>()

    fun saveTraining(training: Training, success: (Training) -> Unit) {
        call {
            api.setTraining(training = training.toTraining())
                .onEach { success.invoke(training) }
                .catch { }
                .launchIn(this)
        }
    }
}