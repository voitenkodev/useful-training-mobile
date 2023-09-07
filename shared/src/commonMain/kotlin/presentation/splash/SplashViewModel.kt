package presentation.splash

import Graph
import globalKoin
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import navigation.NavigatorCore
import repository.AuthRepository
import utils.ViewModel

internal class SplashViewModel(private val navigator: NavigatorCore) : ViewModel() {

    private val api = globalKoin().get<AuthRepository>()

    init {
        viewModelScope.launch {
            api.getToken()
                .onEach {
                    if (it == null) navigator.navigate(Graph.Auth.link, true)
                    else navigator.navigate(Graph.Trainings.link, true)
                }
                .launchIn(this)
        }
    }
}