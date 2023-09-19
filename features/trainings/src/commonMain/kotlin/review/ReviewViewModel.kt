package review

import decompose.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import mapping.toTrainingState
import mapping.toTrainingStateList
import org.koin.mp.KoinPlatformTools
import repository.TrainingRepository
import training.Training

class ReviewViewModel : ViewModel() {

    private val _state = MutableStateFlow(ReviewState())
    val state: StateFlow<ReviewState> = _state

    private val api = KoinPlatformTools.defaultContext().get().get<TrainingRepository>()

    fun getTraining(trainingId: String) = launch {
        api
            .getTraining(trainingId = trainingId)
            .onStart {
                _state.value = state.value.copy(loading = true)
            }.onEach {
                _state.value = state.value.copy(
                    loading = false,
                    error = null,
                    training = it.toTrainingState()
                )
            }.catch {
                _state.value = state.value.copy(loading = false, error = it.message)
            }
            .launchIn(this)
    }

    fun getTrainings() = launch {
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

    fun removeTraining(trainingId: String, onSuccess: () -> Unit) = launch {
        api
            .deleteTraining(trainingId = trainingId)
            .onStart {
                _state.value = state.value.copy(loading = true, error = null)
            }.onEach {
                _state.value = state.value.copy(loading = false, error = null)
                onSuccess.invoke()
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
}