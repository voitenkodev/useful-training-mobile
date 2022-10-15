package presentation.auth

import ComposeCoroutineContext
import Direction
import NavigatorAction
import data.repository.AuthRepository
import globalKoin
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart

class AuthPresenter(val dispatcher: (Any) -> Any) : ComposeCoroutineContext() {

    private val api = globalKoin().get<AuthRepository>()

    fun checkAuthorization() = call {
        if (api.isAuthorized) dispatcher(NavigatorAction.NAVIGATE(Direction.Trainings, popToInclusive = true))
    }

    fun login(email: String, password: String) = call {
        api.login(email, password)
            .onStart {
                dispatcher(AuthAction.Loading(true))
            }.onEach {
                dispatcher(AuthAction.Loading(false))
                dispatcher(AuthAction.Error(null))
                dispatcher(NavigatorAction.NAVIGATE(Direction.Trainings, popToInclusive = true))
            }.catch {
                dispatcher(AuthAction.Loading(false))
                dispatcher(AuthAction.Error(it.message))
            }.launchIn(this)
    }

    fun registration(email: String, password: String) = call {
        api.registration(email, password)
            .onStart {
                dispatcher(AuthAction.Loading(true))
            }.onEach {
                dispatcher(AuthAction.Loading(false))
                dispatcher(AuthAction.Error(null))
                dispatcher(NavigatorAction.NAVIGATE(Direction.Trainings, popToInclusive = true))
            }.catch {
                dispatcher(AuthAction.Loading(false))
                dispatcher(AuthAction.Error(it.message))
            }.launchIn(this)
    }
}