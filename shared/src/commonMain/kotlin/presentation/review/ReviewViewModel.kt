package presentation.review

import Graph
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import data.mapping.toTrainingState
import data.mapping.toTrainingStateList
import data.repository.TrainingRepository
import globalKoin
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import navigation.NavigatorCore
import presentation.training.Training
import utils.ViewModel

internal class ReviewViewModel(private val navigator: NavigatorCore) : ViewModel() {

    private val _state = mutableStateOf(ReviewState())
    val state: State<ReviewState> = _state

    private val api = globalKoin().get<TrainingRepository>()

    fun getTraining(trainingId: String) = viewModelScope.launch {
        api
            .getTraining(trainingId = trainingId)
            .onStart {
                _state.value = state.value.copy(loading = true)
            }.onEach {
                _state.value = state.value.copy(
                    loading = false,
                    error = null,
                    reviewTraining = it.toTrainingState()
                )
            }.catch {
                _state.value = state.value.copy(loading = false, error = it.message)
            }
            .launchIn(this)
    }

  fun getTrainings() = viewModelScope.launch {
        api
            .getTrainings()
            .onStart {
                _state.value = state.value.copy(loading = true)
            }.onEach {
                _state.value = state.value.copy(
                    loading = false,
                    error = null,
                    otherTrainings = it.toTrainingStateList()
                )
            }.catch {
                _state.value = state.value.copy(loading = false, error = it.message)
            }
            .launchIn(this)
    }

    fun removeTraining(trainingId: String) = viewModelScope.launch {
        api
            .removeTraining(trainingId = trainingId)
            .onStart {
                _state.value = state.value.copy(loading = false, error = null)
            }.onEach {
                _state.value = state.value.copy(loading = false, error = null)
                navigator.navigate(Graph.Trainings.link)
            }.catch {
                _state.value = state.value.copy(loading = false, error = it.message)
            }
            .launchIn(this)
    }

    fun clearError() {
        _state.value = state.value.copy(error = null)
    }

    fun showError(message: String?) {
        _state.value = state.value.copy(error = message)
    }

    fun compareWith(training: Training) {
        _state.value = state.value.copy(compareTraining = training)
    }

    fun clearComparing() {
        _state.value = state.value.copy(compareTraining = null)
    }

    fun openRemoveTrainingPopup(id: String?) {
        if (id == null) showError("Empty training")
        else _state.value = state.value.copy(removeTrainingId = id)
    }

    fun closeRemoveTrainingPopup() {
        _state.value = state.value.copy(removeTrainingId = null)
    }

    fun back() {
        navigator.back()
    }
}