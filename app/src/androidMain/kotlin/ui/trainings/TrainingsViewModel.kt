package ui.trainings

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import datasource.AuthSource
import datasource.TrainingSource
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import data.mapping.toTrainingStateList
import presentation.state.TrainingState
import ui.navigation.Router

class TrainingsViewModel(
    private val savedStateHandle: SavedStateHandle,
    private val authSource: AuthSource,
    private val trainingSource: TrainingSource,
) : ViewModel() {

    private val _navigation: Channel<Router> = Channel(Channel.BUFFERED)
    val event: Flow<Router> = _navigation.receiveAsFlow()

    private val _trainingState = MutableStateFlow(savedStateHandle["trainingsState"] ?: emptyList<TrainingState>())
    val trainingState: StateFlow<List<TrainingState>> = _trainingState.asStateFlow()

    init {
        viewModelScope.launch {
            trainingSource
                .getTrainings(authSource.user?.uid)
                .map { it.toTrainingStateList() }
                .onEach {
                    _trainingState.value = it
                    savedStateHandle["trainingsState"] = it
                }
                .launchIn(this)
        }
    }

    fun get(training: TrainingState) = viewModelScope.launch {
        _navigation.send(Router.Training(training))
    }

    fun show(training: TrainingState) = viewModelScope.launch {
        _navigation.send(Router.Review(training))
    }

    fun add() = viewModelScope.launch {
        _navigation.send(Router.Training())
    }
}