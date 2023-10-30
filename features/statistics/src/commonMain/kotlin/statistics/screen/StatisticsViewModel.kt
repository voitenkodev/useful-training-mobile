package statistics.screen

import TrainingsRepository
import ViewModel
import kotlinx.collections.immutable.toImmutableList
import kotlinx.collections.immutable.toImmutableMap
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import org.koin.core.component.inject
import statistics.mapping.toState
import statistics.state.Info
import statistics.state.State

internal class StatisticsViewModel : ViewModel() {

    private val _state = MutableStateFlow(State())
    internal val state: StateFlow<State> = _state

    private val trainingsApi by inject<TrainingsRepository>()

    init {
        debounceGetExercises("")
        getExerciseNameOptions()
    }

    fun setQuery(query: String) {
        _state.update { it.copy(query = query) }
        debounceGetExercises(query)
    }

    @OptIn(FlowPreview::class)
    private fun debounceGetExercises(query: String) {
//        flowOf(query)
//            .debounce(500)
//            .distinctUntilChanged()
//            .flatMapConcat { trainingsApi.getExercises(query = query) }
//            .onStart {
//                _state.update { it.copy(loading = false) }
//            }.onEach { response ->
//                _state.update {
//                    it.copy(
//                        exercises = response.processingExercises(),
//                        loading = false
//                    )
//                }
//            }.catch { t ->
//                _state.update { it.copy(loading = false, error = t.message) }
//            }.launchIn(this)
    }

    private fun getExerciseNameOptions() {

    }

    fun removeExerciseNameOption(value: String) {

    }

    fun clearError() {
        _state.update { it.copy(error = null) }
    }
}