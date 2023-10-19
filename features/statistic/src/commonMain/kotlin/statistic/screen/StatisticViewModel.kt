package statistic.screen

import ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import statistic.state.State

internal class StatisticViewModel : ViewModel() {

    private val _state = MutableStateFlow(State())
    internal val state: StateFlow<State> = _state

    fun clearError() {
        _state.value = state.value.copy(error = null)
    }
}