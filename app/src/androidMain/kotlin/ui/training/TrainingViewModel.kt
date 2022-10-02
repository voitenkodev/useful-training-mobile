package ui.training

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import data.repository.TrainingRepository
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import data.mapping.toTraining
import presentation.state.TrainingState
import presentation.state.calculateDuration
import presentation.state.calculateValues
import presentation.state.validate
import ui.navigation.Router

class TrainingViewModel(
    private val savedStateHandle: SavedStateHandle,
    private val trainingRepo: TrainingRepository,
) : ViewModel() {

    private val _navigation: Channel<Router> = Channel(Channel.BUFFERED)
    val event: Flow<Router> = _navigation.receiveAsFlow()

    private val _error: Channel<String> = Channel(Channel.BUFFERED)
    val error: Flow<String> = _error.receiveAsFlow()

    private val _trainingState = MutableStateFlow(savedStateHandle["trainingState"] ?: TrainingState())
    val trainingState: StateFlow<TrainingState> = _trainingState.asStateFlow()

    fun save(trainingState: TrainingState) = viewModelScope.launch {

        val finalState = trainingState
            .validate()
            ?.calculateDuration()
            ?.calculateValues()

        trainingRepo.setTraining(training = finalState?.toTraining() ?: error("invalid Training"))
            .onEach { _navigation.send(Router.Review(finalState)) }
            .catch { _error.send(it.toString()) }
            .launchIn(this)
    }

    fun update(newState: TrainingState) {
        _trainingState.value = newState
        savedStateHandle["trainingState"] = newState
    }
}