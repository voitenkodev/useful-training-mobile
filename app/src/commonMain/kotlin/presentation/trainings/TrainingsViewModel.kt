package presentation.trainings

import Graph
import NavigatorCore
import ViewModel
import data.mapping.toTrainingStateList
import data.repository.TrainingRepository
import globalKoin
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import presentation.review.ReviewAction
import presentation.training.Training
import presentation.training.TrainingAction

class TrainingsViewModel(
    private val dispatcher: (Any) -> Any,
    private val navigator: NavigatorCore,
) : ViewModel() {

    private val api = globalKoin().get<TrainingRepository>()

    fun fetchTrainings() = viewModelScope.launch {
        api.getTrainings().onStart {
            dispatcher(TrainingsAction.Loading(true))
        }.map {
            it.toTrainingStateList()
        }.onEach {
            dispatcher(TrainingsAction.Loading(false))
            dispatcher(TrainingsAction.Error(null))
            dispatcher(TrainingsAction.FetchTrainings(it))
        }.catch {
            dispatcher(TrainingsAction.Loading(false))
            dispatcher(TrainingsAction.Error(it.message))
        }.launchIn(this)
    }

    fun clearError() {
        dispatcher(TrainingsAction.Error(null))
    }

    fun addTraining() {
        dispatcher(TrainingAction.PutTrainingAction(Training()))
        navigator.navigate(Graph.Training.link)
    }

    fun back() {
        navigator.back()
    }

    fun editTraining(training: Training) {
        dispatcher(TrainingAction.PutTrainingAction(training))
        dispatcher(TrainingAction.ProvideEmptyIterations)
        navigator.navigate(Graph.Training.link)
    }

    fun reviewTraining(training: Training) {
        dispatcher(ReviewAction.FetchTrainings(selected = training))
        navigator.navigate(Graph.Review.link)
    }
}