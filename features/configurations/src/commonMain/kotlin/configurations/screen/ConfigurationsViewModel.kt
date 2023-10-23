package configurations.screen

import ViewModel
import configurations.state.State
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

internal class ConfigurationsViewModel : ViewModel() {

    private val _state = MutableStateFlow(State())
    internal val state: StateFlow<State> = _state

    fun clearError() {
        _state.update { it.copy(error = null) }
    }

}