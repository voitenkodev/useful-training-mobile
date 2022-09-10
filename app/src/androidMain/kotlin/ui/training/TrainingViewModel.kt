package ui.training

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import datasource.AuthSource
import datasource.TrainingSource
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import training.TrainingState

class TrainingViewModel(
    private val savedStateHandle: SavedStateHandle,
    private val authSource: AuthSource,
    private val trainingSource: TrainingSource,
) : ViewModel() {

    private val _trainingState = MutableStateFlow(savedStateHandle["trainingState"] ?: TrainingState.empty(0.0))
    val trainingState: StateFlow<TrainingState> = _trainingState.asStateFlow()

    fun save(trainingState: TrainingState) = viewModelScope.launch {
        trainingSource
            .writeTraining(authSource.user?.uid, trainingState)
            .onEach { }
            .launchIn(this)
    }

    fun update(newState: TrainingState) {
        _trainingState.value = newState
        savedStateHandle["trainingState"] = newState
    }
}