package ui.review

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import state.TrainingState
import ui.navigation.Direction
import ui.navigation.Router

class ReviewViewModel(
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val _navigation: Channel<Router> = Channel(Channel.BUFFERED)
    val event: Flow<Router> = _navigation.receiveAsFlow()

    private val _trainingState = MutableStateFlow(savedStateHandle["trainingState"] ?: TrainingState())
    val trainingState: StateFlow<TrainingState> = _trainingState.asStateFlow()

    fun ok() = viewModelScope.launch {
        _navigation.send(Router.Trainings.apply { direction = Direction.BACK })
    }
}