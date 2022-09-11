package ui.auth

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import auth.AuthContent
import ui.navigation.LocalNavigator
import ui.navigation.Router

@Composable
fun AuthScreen(
    viewModel: AuthViewModel,
    navigate: (Router) -> Unit
) {

    val state = viewModel.authState.collectAsState()

    LocalNavigator(
        viewModel.event,
        navigate = navigate
    )

    AuthContent(
        state = state.value,
        update = viewModel::update,
        login = viewModel::login,
        registration = viewModel::registration,
    )
}