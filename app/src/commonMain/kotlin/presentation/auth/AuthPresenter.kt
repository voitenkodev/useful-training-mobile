package presentation.auth

import ComposeCoroutineContext
import data.repository.AuthRepository
import globalKoin
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart

class AuthPresenter(val dispatcher: (Any) -> Any) : ComposeCoroutineContext() {

    private val api = globalKoin().get<AuthRepository>()

    fun checkAuthorization(success: () -> Unit) = call {
        if (api.isAuthorized) success.invoke()
    }

    fun login(email: String, password: String, success: () -> Unit) = call {
        api.login(email, password)
            .onStart {
                dispatcher(AuthAction.Loading(true))
            }.onEach {
                dispatcher(AuthAction.Loading(false))
                dispatcher(AuthAction.Error(null))
                success.invoke()
            }.catch {
                dispatcher(AuthAction.Loading(false))
                dispatcher(AuthAction.Error(it.message))
            }.launchIn(this)
    }

    fun registration(email: String, password: String, success: () -> Unit) = call {
        api.registration(email, password)
            .onStart {
                dispatcher(AuthAction.Loading(true))
            }.onEach {
                dispatcher(AuthAction.Loading(false))
                dispatcher(AuthAction.Error(null))
                success.invoke()
            }.catch {
                dispatcher(AuthAction.Loading(false))
                dispatcher(AuthAction.Error(it.message))
            }.launchIn(this)
    }
}