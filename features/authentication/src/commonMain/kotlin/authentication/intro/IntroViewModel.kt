package authentication.intro

import ViewModel
import authentication.intro.models.ScreenState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

internal class IntroViewModel : ViewModel() {

    private val _state = MutableStateFlow(State())
    val state: StateFlow<State> = _state.asStateFlow()

    fun markScreenAsShowedOnce() {
        _state.update { it.copy(screenState = ScreenState.ShowedOnce) }
    }
}