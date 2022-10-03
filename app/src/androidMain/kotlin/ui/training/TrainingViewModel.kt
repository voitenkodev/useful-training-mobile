package ui.training

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import data.mapping.toTraining
import data.repository.TrainingRepository
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import redux.TrainingState
import ui.navigation.Router

class TrainingViewModel(
    private val trainingRepository: TrainingRepository,
) : ViewModel() {

    private val _navigation: Channel<Router> = Channel(Channel.BUFFERED)
    val event: Flow<Router> = _navigation.receiveAsFlow()

    private val _error: Channel<String> = Channel(Channel.BUFFERED)
    val error: Flow<String> = _error.receiveAsFlow()

    fun save(trainingState: TrainingState) = viewModelScope.launch {

        trainingRepository.setTraining(training = trainingState.toTraining())
            .onEach { _navigation.send(Router.Review) }
            .catch { _error.send(it.toString()) }
            .launchIn(this)
    }
}