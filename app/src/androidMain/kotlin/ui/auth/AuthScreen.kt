package ui.auth

import android.widget.Toast
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import content.AuthContent
import kotlinx.coroutines.flow.collectLatest
import ui.navigation.ScreenNavigator
import ui.navigation.Router

@Composable
fun AuthScreen(
    viewModel: AuthViewModel,
    navigate: (Router) -> Unit
) {

    val state = viewModel.authState.collectAsState()

    val context = LocalContext.current
    LaunchedEffect(key1 = Unit) {
        viewModel.error.collectLatest { value: String ->
            Toast.makeText(context, value, Toast.LENGTH_SHORT).show()

        }
    }
    ScreenNavigator(
        viewModel.event,
        navigate = navigate
    )

    AuthContent(
        modifier = Modifier.statusBarsPadding().navigationBarsPadding().imePadding(),
        state = state.value,
        update = viewModel::update,
        login = viewModel::login,
        registration = viewModel::registration,
    )
}