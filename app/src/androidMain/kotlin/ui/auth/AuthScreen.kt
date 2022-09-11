package ui.auth

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavController
import auth.AuthContent

@Composable
fun AuthScreen(
    viewModel: AuthViewModel
) {

    val state = viewModel.authState.collectAsState()

    AuthContent(
        state = state.value,
        update = viewModel::update,
        login = viewModel::login,
        registration = viewModel::registration,
    )
}