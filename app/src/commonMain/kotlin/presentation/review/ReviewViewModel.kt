package presentation.review

import Graph
import NavigatorCore
import ViewModel
import data.repository.AuthRepository
import data.repository.TrainingRepository
import globalKoin
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import presentation.auth.AuthAction
import presentation.training.Training

class ReviewViewModel(
    private val dispatcher: (Any) -> Any,
    private val navigator: NavigatorCore,
) : ViewModel() {

    private val api = globalKoin().get<TrainingRepository>()

    fun removeTraining(trainingId: String?) = viewModelScope.launch {
        api
            .removeTraining(trainingId = trainingId ?: error("invalid Training ID"))
            .onEach {
                navigator.navigate(Graph.Trainings.link)
            }
            .catch { }
            .launchIn(this)
    }

    fun clearError() {
        dispatcher(ReviewAction.Error(null))
    }

    fun compareWith(training: Training) {
        dispatcher(ReviewAction.CompareTrainings(training))
    }

    fun clearComparing() {
        dispatcher(ReviewAction.CompareTrainings(null))
    }

    fun back(){
        navigator.back()
    }
}