package ui.training

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import datasource.AuthSource
import datasource.TrainingSource
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import mapping.toTraining
import state.TrainingState
import state.calculateDuration
import state.calculateValues
import state.validate
import ui.navigation.Router

class TrainingViewModel(
    private val savedStateHandle: SavedStateHandle,
    private val authSource: AuthSource,
    private val trainingSource: TrainingSource,
) : ViewModel() {

    private val _navigation: Channel<Router> = Channel(Channel.BUFFERED)
    val event: Flow<Router> = _navigation.receiveAsFlow()

    private val _error: Channel<String> = Channel(Channel.BUFFERED)
    val error: Flow<String> = _error.receiveAsFlow()

    private val _trainingState = MutableStateFlow(savedStateHandle["trainingState"] ?: TrainingState())
    val trainingState: StateFlow<TrainingState> = _trainingState.asStateFlow()

    fun save(trainingState: TrainingState) = viewModelScope.launch {

        val training = trainingState
            .validate()
            ?.calculateDuration()
            ?.calculateValues()

        trainingSource
            .writeTraining(authSource.user?.uid, training?.toTraining() ?: error("invalid Training"))
            .catch { _error.send(it.toString()) }
            .onEach { _navigation.send(Router.Review(training)) }
            .launchIn(this)
    }

    fun update(newState: TrainingState) {
        _trainingState.value = newState
        savedStateHandle["trainingState"] = newState
    }
}