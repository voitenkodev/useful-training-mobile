package ui.review

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import data.repository.TrainingRepository
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import redux.Direction
import redux.TrainingState

class ReviewViewModel(
    private val trainingRepository: TrainingRepository,
) : ViewModel() {

    private val _navigation: Channel<Direction> = Channel(Channel.BUFFERED)
    val event: Flow<Direction> = _navigation.receiveAsFlow()

    fun ok() = viewModelScope.launch {
        _navigation.send(Direction.Trainings)
    }

    fun remove(state: TrainingState) = viewModelScope.launch {
        val id = state.id

        trainingRepository
            .removeTraining(trainingId = id ?: error("invalid Training ID"))
            .onEach { _navigation.send(Direction.Trainings) }
            .catch { }
            .launchIn(this)
    }
}