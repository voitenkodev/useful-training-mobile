package presentation.review

import Graph
import NavigatorCore
import ViewModel
import data.repository.TrainingRepository
import globalKoin
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import presentation.training.Training

class ReviewViewModel(
    private val dispatcher: (Any) -> Any,
    private val navigator: NavigatorCore,
) : ViewModel() {

    private val api = globalKoin().get<TrainingRepository>()

    fun removeTraining(trainingId: String) = viewModelScope.launch {
        api
            .removeTraining(trainingId = trainingId)
            .onStart {
                dispatcher(ReviewAction.Loading(true))
            }
            .onEach {
                dispatcher(ReviewAction.Loading(false))
                navigator.navigate(Graph.Trainings.link)
            }
            .catch {
                showError(it.message)
                dispatcher(ReviewAction.Loading(false))
            }
            .launchIn(this)
    }

    fun clearError() {
        dispatcher(ReviewAction.Error(null))
    }

    fun showError(message: String?) {
        dispatcher(ReviewAction.Error(message))
    }

    fun compareWith(training: Training) {
        dispatcher(ReviewAction.CompareTrainings(training))
    }

    fun clearComparing() {
        dispatcher(ReviewAction.CompareTrainings(null))
    }

    fun openRemoveTrainingPopup(id: String?) {
        if (id == null) showError("Empty training")
        else dispatcher(ReviewAction.AskToRemoveTraining(id))
    }

    fun closeRemoveTrainingPopup() {
        dispatcher(ReviewAction.AskToRemoveTraining(null))
    }

    fun back() {
        navigator.back()
    }
}