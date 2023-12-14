package authentication.success

import UserRepository
import ViewModel
import kg
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import meter
import org.koin.core.component.inject

internal class SuccessRegistrationViewModel : ViewModel() {

    private val userApi by inject<UserRepository>()

    private val _state = MutableStateFlow(State())
    val state: StateFlow<State> = _state

    init {
        userApi
            .observeUser()
            .onEach { r ->
                _state.update {
                    it.copy(
                        name = r.name,
                        weight = r.weight.kg(),
                        height = r.height.meter()
                    )
                }
            }.catch { t -> _state.update { it.copy(error = t.message) } }
            .launchIn(this)
    }

    fun clearError() {
        _state.update { it.copy(error = null) }
    }
}