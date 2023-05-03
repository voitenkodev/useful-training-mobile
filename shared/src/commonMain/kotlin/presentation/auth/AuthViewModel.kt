package presentation.auth

import Graph
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import data.repository.AuthRepository
import data.source.datastore.DataStoreKeys
import globalKoin
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
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

    private val datastore = globalKoin().get<DataStore<Preferences>>()
    private val api = globalKoin().get<AuthRepository>()

    private val _state = MutableStateFlow(AuthState())
    val state: StateFlow<AuthState> = _state

    init {
        viewModelScope.launch {
            datastore.data
                .map { it[DataStoreKeys.KEY_TOKEN] }
                .filterNotNull()
                .onEach { navigator.navigate(Graph.Trainings.link, true) }
                .launchIn(this)
        }
    }

    fun login() {
        viewModelScope.launch {
            _state.value = state.value.validate()

            if (state.value.error == null) api.login(state.value.email, state.value.password)
                .onStart {
                    _state.value = state.value.copy(loading = true)
                }.onEach {
                    _state.value = state.value.copy(loading = false, error = null)
                }.catch {
                    _state.value = state.value.copy(loading = false, error = it.message)
                }.launchIn(this)
        }
    }

    fun registration() {
        viewModelScope.launch {
            _state.value = state.value.validate()

            if (state.value.error == null) api.registration(state.value.email, state.value.password)
                .onStart {
                    _state.value = state.value.copy(loading = true)
                }.onEach {
                    _state.value = state.value.copy(loading = false, error = null)
                }.catch {
                    _state.value = state.value.copy(loading = false, error = it.message)
                }.launchIn(this)
        }
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

        val newEmail = this.email.trim().lowercase()
        val newPassword = this.password.trim()

        val isEmailValid = newEmail.matches(emailAddressRegex)
        val isPasswordValid = newPassword.length > 5

        val newError = if (isEmailValid.not()) "Invalid Email Field"
        else if (isPasswordValid.not()) "Invalid password field"
        else null

        return this.copy(email = newEmail, password = newPassword, error = newError)
    }
}