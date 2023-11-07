package registration.screen.success

import UserRepository
import ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import org.koin.core.component.inject
import registration.state.SuccessState

internal class SuccessRegistrationViewModel : ViewModel() {

    private val userApi by inject<UserRepository>()

    private val _state = MutableStateFlow(SuccessState())
    val state: StateFlow<SuccessState> = _state

    init {
        userApi
            .observeUser()
            .onEach { r -> _state.update { it.copy(name = r.name) } }
            .launchIn(this)
    }
}