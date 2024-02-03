package exerciseexamplebuilder.main

import ExerciseExamplesRepository
import StatisticsRepository
import ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import org.koin.core.component.inject

internal class ExerciseExampleBuilderViewModel : ViewModel() {

    private val _state = MutableStateFlow(State())
    internal val state: StateFlow<State> = _state

    private val exerciseExampleApi by inject<ExerciseExamplesRepository>()
    private val statisticsApi by inject<StatisticsRepository>()

    init {

    }

    fun updateName(value: String) {
        _state.update { it.copy(name = value) }
    }

    fun clearError() {
        _state.update { it.copy(error = null) }
    }
}