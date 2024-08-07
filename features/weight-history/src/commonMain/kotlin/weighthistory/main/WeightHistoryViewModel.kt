package weighthistory.main

import UserRepository
import ViewModel
import grToKg
import kgToGr
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import org.koin.core.component.inject
import weighthistory.main.mapping.toState

internal class WeightHistoryViewModel : ViewModel() {

    private val _state = MutableStateFlow(State())
    internal val state: StateFlow<State> = _state.asStateFlow()

    private val userApi by inject<UserRepository>()

    init {
        userApi
            .observeWeightHistory()
            .onEach { r -> _state.update { it.copy(weightHistory = r.toState()) } }
            .catch { r -> _state.update { it.copy(error = r.message) } }
            .launchIn(this)

        userApi.syncWeightHistory()
            .onStart { _state.update { it.copy(loading = true) } }
            .onEach { _state.update { it.copy(loading = false) } }
            .catch { r -> _state.update { it.copy(error = r.message, loading = false) } }
            .launchIn(this)
    }

    fun updateWeight(value: Int) {
        userApi.updateWeight(value.grToKg())
            .onStart { _state.update { it.copy(loading = true) } }
            .onEach { _state.update { it.copy(loading = false) } }
            .catch { r -> _state.update { it.copy(error = r.message, loading = false) } }
            .launchIn(this)
    }

    fun closeWeightPickerPopup() {
        _state.update { it.copy(weightPickerPopupVisibleWithLastWeight = null) }
    }

    fun openWeightPickerPopup() {
        _state.update {
            val lastWeight: Int = it.weightHistory.firstOrNull()?.weight?.kgToGr() ?: return
            it.copy(weightPickerPopupVisibleWithLastWeight = lastWeight)
        }
    }

    fun removeWeight(id: String) {
        userApi.removeWeight(id)
            .flatMapConcat { userApi.syncWeightHistory() }
            .onStart { _state.update { it.copy(loading = true) } }
            .onEach { _state.update { it.copy(loading = false) } }
            .catch { r -> _state.update { it.copy(error = r.message, loading = false) } }
            .launchIn(this)
    }

    fun clearError() {
        _state.update { it.copy(error = null) }
    }
}