package presentation.summary

import data.dto.ExerciseDateDTO
import data.mapping.toExerciseState
import data.mapping.toTrainingStateList
import data.repository.TrainingRepository
import globalKoin
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import navigation.NavigatorCore
import utils.ViewModel

internal class SummaryViewModel(private val navigator: NavigatorCore) : ViewModel() {

    private val _state = MutableStateFlow(SummaryState())
    val state: StateFlow<SummaryState> = _state

    private val api = globalKoin().get<TrainingRepository>()

    private var searchJob: Job? = null

    private fun debounceGetExercises(query: String) {
        searchJob?.cancel()
        searchJob = viewModelScope.launch {
            if (query.isBlank()) {
                _state.value = state.value.copy(exercises = emptyMap())
                return@launch
            }
            delay(500)
            getExercisesBy(query)
        }
    }

    fun getTrainings() = viewModelScope.launch {
        api.getTrainings().onStart {
            _state.value = state.value.copy(loading = true)
        }.map {
            it.toTrainingStateList()
        }.onEach { trainings ->
            _state.value = state.value.copy(loading = false, error = null)
            _state.value = state.value.copy(trainings = trainings)
        }.catch {
            _state.value = state.value.copy(loading = false, error = it.message)
        }.launchIn(this)
    }

    private fun getExercisesBy(query: String) = viewModelScope.launch {
        api.getExercises(query = query).onStart {
            _state.value = state.value.copy(loading = false) // don't need loader
        }.onEach {
            _state.value = state.value.copy(
                loading = false, error = null, exercises = it.processingExercises()
            )
        }.catch {
            _state.value = state.value.copy(loading = false, error = it.message)
        }.launchIn(viewModelScope)
    }

    fun setQuery(query: String) {
        _state.value = state.value.copy(query = query)
//        debounceGetExercises(query)
    }

    fun clearError() {
        _state.value = state.value.copy(error = null)
    }

    fun findIndexOfTraining(day: Int, month: Int) {
        val index = state.value.trainings
            .indexOfFirst { it.day == day && it.month == month }

        _state.value = state.value.copy(autoScrollIndex = index)
    }

    fun clearAutoScrollIndex() {
        _state.value = state.value.copy(autoScrollIndex = -1)
    }

    fun decreaseMonth() {
        val isPreviousYear = state.value.selectedMonth == 1
        val newMonth = if (isPreviousYear) 12
        else state.value.selectedMonth - 1
        val newYear = if (isPreviousYear) state.value.selectedYear - 1
        else state.value.selectedYear

        _state.value = state.value.copy(selectedYear = newYear, selectedMonth = newMonth)
    }

    fun increaseMonth() {
        val isNextYear = state.value.selectedMonth == 12
        val newMonth = if (isNextYear) 1
        else state.value.selectedMonth + 1
        val newYear = if (isNextYear) state.value.selectedYear + 1
        else state.value.selectedYear

        _state.value = state.value.copy(selectedYear = newYear, selectedMonth = newMonth)
    }

    fun back() {
        navigator.back()
    }

    override fun onCleared() {
        super.onCleared()
        searchJob?.cancel()
        searchJob = null
    }

    private fun List<ExerciseDateDTO>.processingExercises() = this.groupBy({
        ExerciseInfo(trainingId = it.trainingId, date = it.date)
    }, {
        it.exercise.toExerciseState()
    })
}