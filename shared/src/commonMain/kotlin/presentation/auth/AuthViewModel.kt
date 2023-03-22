package presentation.auth

import DataStoreFactory
import Graph
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import data.repository.AuthRepositoryImpl
import data.source.datastore.DataStoreKeys
import data.source.network.AuthSource
import data.source.network.Client
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import navigation.NavigatorCore
import utils.ViewModel

internal class AuthViewModel(private val navigator: NavigatorCore) : ViewModel() {

    private val datastore = DataStoreFactory.client
    private val api = AuthRepositoryImpl(
        AuthSource(
            network = Client(dataStore = datastore).address(),
            dataStore = datastore
        )
    )

    private val _state = mutableStateOf(AuthState())
    val state: State<AuthState> = _state

    init {
        viewModelScope.launch {
            datastore.data
                .map { it[DataStoreKeys.KEY_TOKEN] }
                .filterNotNull()
                .onEach { navigator.navigate(Graph.Trainings.link, true) }
                .launchIn(this)
        }
    }

    fun login(email: String, password: String) = viewModelScope.launch {
        _state.value = state.value.validate()
        api.login(email, password)
            .onStart {
                _state.value = state.value.copy(loading = true)
            }.onEach {
                _state.value = state.value.copy(loading = false, error = null)
                navigator.navigate(Graph.Trainings.link, true)
            }.catch {
                _state.value = state.value.copy(loading = false, error = it.message)
            }.launchIn(this)
    }

    fun registration(email: String, password: String) = viewModelScope.launch {
        api.registration(email, password)
            .onStart {
                _state.value = state.value.copy(loading = true)
            }.onEach {
                _state.value = state.value.copy(loading = false, error = null)
                navigator.navigate(Graph.Trainings.link, true)
            }.catch {
                _state.value = state.value.copy(loading = false, error = it.message)
            }.launchIn(this)
    }

    fun back() {
        navigator.back()
    }

    fun clearError() {
        _state.value = state.value.copy(error = null)
    }

    fun updateEmail(value: String) {
        _state.value = state.value.copy(email = value)
    }

    fun updatePassword(value: String) {
        _state.value = state.value.copy(password = value)
    }

    private fun AuthState.validate(): AuthState {
        val emailAddressRegex = Regex(
            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                    "\\@" +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                    "(" +
                    "\\." +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}"
                    + ")+"
        )

        val newEmail = this.email.trim()
        val newPassword = this.password.trim()

        val isEmailValid = newEmail.matches(emailAddressRegex)
        val isPasswordValid = newPassword.length > 5

        val newError = if (isEmailValid.not()) "Invalid Email Field"
        else if (isPasswordValid.not()) "Invalid password field"
        else null

        return this.copy(email = newEmail, password = newPassword, error = newError)
    }
}