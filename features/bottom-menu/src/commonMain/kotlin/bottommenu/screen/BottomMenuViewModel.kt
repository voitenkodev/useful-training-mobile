package bottommenu.screen

import AuthenticationRepository
import ViewModel
import bottommenu.state.State
import bottommenu.state.TokenStatus
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import org.koin.core.component.inject

internal class BottomMenuViewModel : ViewModel() {

    private val api by inject<AuthenticationRepository>()

    private val _state = MutableStateFlow(State())
    val state: StateFlow<State> = _state

    init {
        subscribeToken()
    }

    private fun subscribeToken() {
        api.getToken()
            .onEach { r ->
                _state.update {
                    if (r == null) it.copy(tokenStatus = TokenStatus.Unavailable)
                    else it.copy(tokenStatus = TokenStatus.Available)
                }
            }.launchIn(this)
    }
}