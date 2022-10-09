package ui.auth

import AuthSource
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import co.touchlab.kermit.Logger
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.androidx.compose.get
import presentation.AuthContent
import redux.rememberDispatcher
import ui.navigation.ScreenNavigator
import utils.ComposeViewModel

@Composable
fun AuthScreen(
    viewModel: AuthViewModel
) {

    val context = LocalContext.current

    val dispatcher = rememberDispatcher()
    val source = get<AuthSource>()

    val authApi = remember { ComposeViewModel() }

    ScreenNavigator(viewModel.event)

    AuthContent(
        modifier = Modifier.statusBarsPadding().navigationBarsPadding().imePadding(),
        login = {
            authApi.call {
                source
                    .login(it.email, it.password)
                    .onEach { Logger.i { "SUCCESS CALL" } }
                    .catch { }
                    .launchIn(this)
            }
        },
        registration = {
            authApi.call {
                repeat(200) {
                    delay(1000)
                    Logger.i { "Counter - $it" }
                }
            }
        },
    )
}