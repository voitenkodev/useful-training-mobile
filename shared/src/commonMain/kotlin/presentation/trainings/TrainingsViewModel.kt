package presentation.trainings

import Graph
import data.mapping.toTrainingStateList
import data.repository.TrainingRepository
import globalKoin
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import navigation.NavigatorCore
import presentation.training.Training
import utils.ViewModel
import utils.round

internal class TrainingsViewModel(private val navigator: NavigatorCore) : ViewModel() {

    private val _state = MutableStateFlow(TrainingsState())
    val state: StateFlow<TrainingsState> = _state

    private val api = globalKoin().get<TrainingRepository>()

    fun getTrainings() = viewModelScope.launch {
        api.getTrainings()
            .onStart {
                _state.value = state.value.copy(loading = true)
            }.map {
                it.toTrainingStateList()
            }.onEach {
                _state.value = state.value.copy(loading = false, error = null)
                _state.value = state.value.processingTrainings(it)
            }.catch {
                _state.value = state.value.copy(loading = false, error = it.message)
            }.launchIn(this)
    }

    fun clearError() {
        _state.value = state.value.copy(error = null)
    }

    fun addTraining() {
        navigator.navigate(Graph.Training.link)
    }

    fun moveToSummary() {
        navigator.navigate(Graph.Summary.link)
    }

    fun back() {
        navigator.back()
    }

    fun editTraining(training: Training) {
        val id = training.id ?: return
        navigator.navigate(Graph.Training.link, args = mapOf("trainingId" to id))
    }

    fun reviewTraining(training: Training) {
        val id = training.id ?: return
        navigator.navigate(Graph.Review.link, args = mapOf("trainingId" to id))
    }

    private fun TrainingsState.processingTrainings(trainings: List<Training>) = copy(
        trainings = trainings,
        weekTrainings = trainings.groupBy { it.endOfWeek }.mapKeys { item ->
            val startDate = item.value.firstOrNull()?.startOfWeek
            val endDate = item.value.firstOrNull()?.endOfWeek
            WeekInfo(
                startWeekDate = startDate ?: "",
                endWeekDate = endDate ?: "",
                tonnage = item.value.mapNotNull { it.tonnage }.sum().round(2),
                intensity = (item.value.mapNotNull { it.intensity }.sum() / item.value.size).round(1),
                trainingWeekDays = item.value.map { it.weekDay }
            )
        }
    )
}