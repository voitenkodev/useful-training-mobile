package statistic.screen

import TrainingRepository
import ViewModel
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import models.ExerciseDate
import org.koin.core.component.inject
import statistic.mapping.toExerciseState
import statistic.state.Info
import statistic.state.State

internal class StatisticViewModel : ViewModel() {

    private val _state = MutableStateFlow(State())
    internal val state: StateFlow<State> = _state

    private val api by inject<TrainingRepository>()

    fun setQuery(query: String) {
        _state.value = state.value.copy(query = query)
        debounceGetExercises(query)
    }

    @OptIn(FlowPreview::class)
    private fun debounceGetExercises(query: String) {
        flowOf(query)
            .debounce(500)
            .distinctUntilChanged()
            .flatMapConcat { api.getExercises(query = query) }
            .onStart {
                _state.update { it.copy(loading = false) }
            }.onEach { response ->
                _state.update {
                    it.copy(
                        loading = false,
                        exercises = response.processingExercises(),
                    )
                }
            }.catch { t ->
                _state.update { it.copy(loading = false, error = t.message) }
            }.launchIn(this)
    }

    fun getExerciseNameOptions() {
        api
            .getExerciseNameOptions()
            .onStart {
                _state.value = state.value.copy(loading = true)
            }.onEach {
                _state.value = state.value.copy(exerciseNameOptions = it)
            }.catch {
                _state.value = state.value.copy(loading = false, error = it.message)
            }.launchIn(this)
    }

    fun removeExerciseNameOption(value: String) {
        api
            .removeExerciseNameOption(value)
            .onEach { removedValue ->
                _state.value = state.value.copy(
                    exerciseNameOptions = state.value.exerciseNameOptions.filterNot { it == removedValue }
                )
            }.catch {
                _state.value = state.value.copy(error = it.message)
            }.launchIn(this)
    }

    fun clearError() {
        _state.value = state.value.copy(error = null)
    }


    private fun List<ExerciseDate>.processingExercises() = this.groupBy(
        { Info(trainingId = it.trainingId, date = it.date) },
        { it.exercise.toExerciseState() }
    )
}