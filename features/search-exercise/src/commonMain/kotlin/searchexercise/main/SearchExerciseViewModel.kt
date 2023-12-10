package searchexercise.main

import ExerciseExamplesRepository
import ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import org.koin.core.component.inject
import searchexercise.main.mapping.toState
import searchexercise.main.state.State

internal class SearchExerciseViewModel : ViewModel() {

    private val _state = MutableStateFlow(State())
    internal val state: StateFlow<State> = _state

    private val api by inject<ExerciseExamplesRepository>()

    init {
        api
            .observeExerciseExamples()
            .onStart { _state.update { it.copy(loading = true) } }
            .onEach { r -> _state.update { it.copy(loading = false, exerciseExamples = r.toState()) } }
            .catch { t -> _state.update { it.copy(loading = false, error = t.message) } }
            .launchIn(this)

        api
            .syncMuscleTypes()
            .flatMapConcat { api.syncExerciseExamples() }
            .catch { r -> _state.update { it.copy(error = r.message) } }
            .launchIn(this)
    }

    fun setQuery(value: String) {
        _state.update { it.copy(query = value) }
    }

    fun clearError() {
        _state.update { it.copy(error = null) }
    }
}