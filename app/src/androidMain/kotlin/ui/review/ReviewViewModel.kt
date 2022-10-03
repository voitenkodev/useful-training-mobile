package ui.review

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import data.repository.TrainingRepository
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import redux.TrainingState
import ui.navigation.Direction
import ui.navigation.Router

class ReviewViewModel(
    private val trainingRepository: TrainingRepository,
) : ViewModel() {

    private val _navigation: Channel<Router> = Channel(Channel.BUFFERED)
    val event: Flow<Router> = _navigation.receiveAsFlow()

    fun ok() = viewModelScope.launch {
        _navigation.send(Router.Trainings.apply { direction = Direction.BACK })
    }

    fun remove(state: TrainingState) = viewModelScope.launch {
        val id = state.id

        trainingRepository
            .removeTraining(trainingId = id ?: error("invalid Training ID"))
            .onEach { _navigation.send(Router.Trainings.apply { direction = Direction.BACK }) }
            .catch { }
            .launchIn(this)
    }
}