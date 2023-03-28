package presentation.summary

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import data.repository.TrainingRepository
import globalKoin
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import navigation.NavigatorCore
import utils.ViewModel

internal class SummaryViewModel(private val navigator: NavigatorCore) : ViewModel() {

    private val _state = mutableStateOf(SummaryState())
    val state: State<SummaryState> = _state

    private val api = globalKoin().get<TrainingRepository>()

    fun getExercisesBy(name: String) = viewModelScope.launch {
        api
            .getExercises(name = name)
            .onStart {
                _state.value = state.value.copy(loading = true)
            }.onEach {
                _state.value = state.value.copy(
                    loading = false,
                    error = null,
                )

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

    fun back() {
        navigator.back()
    }
}