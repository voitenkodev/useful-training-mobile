package presentation.auth

import Graph
import NavigatorCore
import ViewModel
import data.repository.AuthRepository
import globalKoin
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class AuthViewModel(
    private val dispatcher: (Any) -> Any,
    private val navigator: NavigatorCore,
) : ViewModel() {

    private val api = globalKoin().get<AuthRepository>()

    fun back() {
        navigator.back()
    }

    init {
        viewModelScope.launch {
            if (api.isAuthorized) navigator.navigate(Graph.Trainings.link, true)
        }
    }

    fun login(
        email: String,
        password: String,
    ) = viewModelScope.launch {
        api.login(email, password)
            .onStart {
                dispatcher(AuthAction.Loading(true))
            }.onEach {
                dispatcher(AuthAction.Loading(false))
                dispatcher(AuthAction.Error(null))
//                navigator.navigate(Graph.Trainings.link, true)
                navigator.navigate(Graph.Trainings.link)
            }.catch {
                dispatcher(AuthAction.Loading(false))
                dispatcher(AuthAction.Error(it.message))
            }.launchIn(this)
    }

    fun registration(
        email: String,
        password: String,
    ) = viewModelScope.launch {
        api.registration(email, password)
            .onStart {
                dispatcher(AuthAction.Loading(true))
            }.onEach {
                dispatcher(AuthAction.Loading(false))
                dispatcher(AuthAction.Error(null))
                navigator.navigate(Graph.Trainings.link, true)
            }.catch {
                dispatcher(AuthAction.Loading(false))
                dispatcher(AuthAction.Error(it.message))
            }.launchIn(this)
    }

    fun clearError() {
        dispatcher(AuthAction.Error(null))
    }

    fun updateEmail(value: String) {
        dispatcher(AuthAction.SetEmailAction(value))
    }

    fun updatePassword(value: String) {
        dispatcher(AuthAction.SetPasswordAction(value))
    }
}