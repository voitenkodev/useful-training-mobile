package presentation.auth

import Design
import PlatformBackHandler
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.ime
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.style.TextAlign
import components.Error
import components.Loading
import components.buttons.ButtonQuestion
import components.inputs.InputEmail
import components.inputs.InputPassword
import components.roots.ScrollableRoot
import controls.ButtonPrimaryBrand
import controls.TextFieldH1
import recomposeHighlighter
import utils.Logger

@Composable
internal fun AuthContent(vm: AuthViewModel) {

    val state by vm.state.collectAsState()

    val keyboard = keyboardAsState()

    Logger.l { "$keyboard" }

    Content(
        loading = { state.loading },
        error = { state.error },
        clearError = vm::clearError,
        back = vm::back,

        login = vm::login,
        registration = vm::registration,

        email = { state.email },
        updateEmail = vm::updateEmail,
        password = { state.password },
        updatePassword = vm::updatePassword
    )
}

@Composable
fun keyboardAsState(): State<Boolean> {
    val isImeVisible = WindowInsets.ime.getBottom(LocalDensity.current) > 0
    return rememberUpdatedState(isImeVisible)
}

@Composable
private fun Content(
    loading: () -> Boolean,
    error: () -> String?,
    clearError: () -> Unit,
    back: () -> Unit,

    // FOOTER
    login: () -> Unit,
    registration: () -> Unit,

    //CONTENT
    email: () -> String,
    updateEmail: (String) -> Unit,
    password: () -> String,
    updatePassword: (String) -> Unit,
) {

    val loginProvider by rememberUpdatedState(login)
    val registrationProvider by rememberUpdatedState(registration)

    ScrollableRoot(
        modifier = Modifier
            .fillMaxSize()
            .recomposeHighlighter(),
        loading = { Loading(loading) },
        error = { Error(message = error, close = clearError) },
        back = { PlatformBackHandler(back) },
        header = {
            TextFieldH1(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(Design.dp.bigHeader)
                    .recomposeHighlighter(),
                provideText = { "\uD83D\uDC4B Welcome back" },
                textAlign = TextAlign.Start,
                maxLines = 1
            )
        },
        footer = {

            ButtonPrimaryBrand(
                modifier = Modifier
                    .fillMaxWidth()
                    .recomposeHighlighter(),
                text = "Sign In",
                onClick = loginProvider
            )

            ButtonQuestion(
                modifier = Modifier
                    .fillMaxWidth()
                    .recomposeHighlighter(),
                question = "Don't have an account yet?",
                answer = "Sign Up!",
                onClick = registrationProvider
            )
        },
        content = {
            item(key = "input_email") {
                InputEmail(
                    modifier = Modifier
                        .fillMaxWidth()
                        .recomposeHighlighter(),
                    provideValue = email,
                    onValueChange = updateEmail
                )
            }
            item(key = "input_password") {
                InputPassword(
                    modifier = Modifier
                        .fillMaxWidth()
                        .recomposeHighlighter(),
                    provideValue = password,
                    onValueChange = updatePassword
                )
            }
        }
    )
}