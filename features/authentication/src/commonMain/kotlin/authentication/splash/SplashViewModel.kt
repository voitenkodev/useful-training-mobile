package authentication.splash

import AuthenticationRepository
import ViewModel
import authentication.splash.models.TokenStatus
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.core.component.inject

internal class SplashViewModel : ViewModel() {

    private val api by inject<AuthenticationRepository>()

    private val _state = MutableStateFlow(State())
    val state: StateFlow<State> = _state

    init {
        launch {
            _state.update {
                if (api.getToken().firstOrNull() == null) it.copy(tokenStatus = TokenStatus.Unavailable)
                else it.copy(tokenStatus = TokenStatus.Available)
            }
        }
    }
}