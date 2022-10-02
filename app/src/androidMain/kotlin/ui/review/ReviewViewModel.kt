package ui.review

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import data.mapping.toShortTrainingState
import data.repository.TrainingRepository
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import presentation.state.ShortTrainingState
import presentation.state.TrainingState
import ui.navigation.Direction
import ui.navigation.Router

class ReviewViewModel(
    savedStateHandle: SavedStateHandle,
    private val trainingRepository: TrainingRepository,
) : ViewModel() {

    private val _navigation: Channel<Router> = Channel(Channel.BUFFERED)
    val event: Flow<Router> = _navigation.receiveAsFlow()

    private val _trainingState = MutableStateFlow(savedStateHandle["trainingState"] ?: TrainingState())
    val trainingState: StateFlow<TrainingState> = _trainingState.asStateFlow()

    private val _comparingState = MutableStateFlow<List<ShortTrainingState>>(savedStateHandle["comparingState"] ?: emptyList())
    val comparingState: StateFlow<List<ShortTrainingState>> = _comparingState.asStateFlow()

    init {
        viewModelScope.launch {
            trainingRepository.getShortTrainings()
                .map { it.toShortTrainingState() }
                .onEach {
                    val result = it.filterNot { it.id == trainingState.value.id }
                    _comparingState.value = result
                    savedStateHandle["comparingState"] = result
                }
                .catch { }
                .launchIn(this)
        }
    }

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