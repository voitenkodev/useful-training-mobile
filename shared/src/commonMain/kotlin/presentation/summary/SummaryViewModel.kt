package presentation.summary

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import data.dto.ExerciseDateDTO
import data.mapping.toExerciseState
import data.repository.TrainingRepository
import globalKoin
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import navigation.NavigatorCore
import utils.ViewModel

internal class SummaryViewModel(private val navigator: NavigatorCore) : ViewModel() {

    private val _state = mutableStateOf(SummaryState())
    val state: State<SummaryState> = _state

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

    private fun getExercisesBy(query: String) = viewModelScope.launch {
        api
            .getExercises(query = query)
            .onStart {
                _state.value = state.value.copy(loading = true) // don't need loader
            }.onEach {
                _state.value = state.value.copy(
                    loading = false,
                    error = null,
                    exercises = it.processingExercises()
                )
            }.catch {
                _state.value = state.value.copy(loading = false, error = it.message)
            }.launchIn(viewModelScope)
    }

    fun setQuery(query: String) {
        _state.value = state.value.copy(query = query)
        debounceGetExercises(query)
    }

    fun clearError() {
        _state.value = state.value.copy(error = null)
    }

    fun back() {
        navigator.back()
    }

    override fun onCleared() {
        super.onCleared()
        searchJob?.cancel()
        searchJob = null
    }

    private fun List<ExerciseDateDTO>.processingExercises() = this.groupBy(
        {
            ExerciseInfo(trainingId = it.trainingId, date = it.date)
        }, {
            it.exercise.toExerciseState()
        }
    )
}