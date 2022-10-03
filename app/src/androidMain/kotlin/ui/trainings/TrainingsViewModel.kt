package ui.trainings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import data.mapping.toTrainingStateList
import data.repository.TrainingRepository
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import redux.TrainingState
import ui.navigation.Router

class TrainingsViewModel(
    private val trainingRepository: TrainingRepository,
) : ViewModel() {

    private val _navigation: Channel<Router> = Channel(Channel.BUFFERED)
    val event: Flow<Router> = _navigation.receiveAsFlow()

    private val _trainingState = MutableStateFlow(emptyList<TrainingState>())
    val trainingState: StateFlow<List<TrainingState>> = _trainingState.asStateFlow()

    init {
        viewModelScope.launch {
            trainingRepository
                .getTrainings()
                .map { it.toTrainingStateList() }
                .onEach { _trainingState.value = it }
                .launchIn(this)
        }
    }

    fun get() = viewModelScope.launch {
        _navigation.send(Router.Training)
    }

    fun show() = viewModelScope.launch {
        _navigation.send(Router.Review)
    }

    fun add() = viewModelScope.launch {
        _navigation.send(Router.Training)
    }
}