package ui.auth

import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import content.AuthContent
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
        modifier = Modifier.statusBarsPadding().navigationBarsPadding(),
        state = state.value,
        update = viewModel::update,
        login = viewModel::login,
        registration = viewModel::registration,
    )
}