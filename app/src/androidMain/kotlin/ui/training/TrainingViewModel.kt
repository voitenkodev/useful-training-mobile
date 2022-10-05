package ui.training

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import data.mapping.toTraining
import data.repository.TrainingRepository
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import redux.Direction
import redux.TrainingState

class TrainingViewModel(
    private val trainingRepository: TrainingRepository,
) : ViewModel() {

    private val _navigation: Channel<Direction> = Channel(Channel.BUFFERED)
    val event: Flow<Direction> = _navigation.receiveAsFlow()

    private val _error: Channel<String> = Channel(Channel.BUFFERED)
    val error: Flow<String> = _error.receiveAsFlow()

    fun save(trainingState: TrainingState) = viewModelScope.launch {

        trainingRepository.setTraining(training = trainingState.toTraining())
            .onEach { _navigation.send(Direction.Review) }
            .catch { _error.send(it.toString()) }
            .launchIn(this)
    }
}