package presentation.trainings

import Graph
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import data.mapping.toTrainingStateList
import data.repository.TrainingRepository
import globalKoin
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import navigation.NavigatorCore
import presentation.training.Training
import utils.ViewModel

internal class TrainingsViewModel(private val navigator: NavigatorCore) : ViewModel() {

    private val _state = mutableStateOf(TrainingsState())
    val state: State<TrainingsState> = _state

    private val api = globalKoin().get<TrainingRepository>()

    fun fetchTrainings() = viewModelScope.launch {
        api.getTrainings().onStart {
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

    fun back() {
        navigator.back()
    }

    fun editTraining(training: Training) {
//        dispatcher(TrainingAction.PutTrainingAction(training))
//        dispatcher(TrainingAction.ProvideEmptyIterations)
//        navigator.navigate(Graph.Training.link)
    }

    fun reviewTraining(training: Training) {
        navigator.navigate(Graph.Review.link)
    }

    private fun TrainingsState.processingTrainings(trainings: List<Training>) = copy(
        trainings = trainings,
        weekTrainings = trainings.groupBy { it.endOfWeek }.mapKeys { item ->
            val startDate = item.value.firstOrNull()?.startOfWeek
            val endDate = item.value.firstOrNull()?.endOfWeek
            WeekInfo(
                startWeekDate = startDate ?: "",
                endWeekDate = endDate ?: "",
                tonnage = item.value.mapNotNull { it.tonnage }.sum(),
                intensity = item.value.mapNotNull { it.intensity }.sum() / item.value.size,
                trainingWeekDays = item.value.map { it.weekDay }
            )
        }
    )
}