package ui.trainings

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import datasource.AuthSource
import datasource.TrainingSource
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import state.MOCK_1
import state.MOCK_2
import state.MOCK_3
import state.TrainingState
import ui.navigation.Router

class TrainingsViewModel(
    private val savedStateHandle: SavedStateHandle,
    private val authSource: AuthSource,
    private val trainingSource: TrainingSource,
) : ViewModel() {

    private val _navigation: Channel<Router> = Channel(Channel.BUFFERED)
    val event: Flow<Router> = _navigation.receiveAsFlow()

    private val _trainingState = MutableStateFlow(savedStateHandle["trainingsState"] ?: listOf(MOCK_1, MOCK_2, MOCK_3))
    val trainingState: StateFlow<List<TrainingState>> = _trainingState.asStateFlow()

    // listOf(MOCK_1, MOCK_2, MOCK_3)
    init {
        // todo load trainings + save in statehandler
//        _trainingState.value = newState
//        savedStateHandle["trainingsState"] = newState
    }

    fun save(trainingState: TrainingState) = viewModelScope.launch {
        trainingSource.writeTraining(authSource.user?.uid, trainingState).onEach { _navigation.send(Router.Review(trainingState)) }
            .launchIn(this)
    }

    fun get(training: TrainingState) = viewModelScope.launch {
        _navigation.send(Router.Training(training))
    }

    fun add() = viewModelScope.launch {
        _navigation.send(Router.Training())
    }
}