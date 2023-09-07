package login

import Design
import PlatformBackHandler
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import components.Error
import components.Loading
import components.backgrounds.BackgroundIntroVideo
import components.buttons.ButtonQuestion
import components.inputs.InputEmail
import components.inputs.InputPassword
import components.overlay.alphaOverlay
import components.roots.ScrollableRoot
import controls.ButtonPrimary
import controls.TextFieldH1
import recomposeHighlighter

@Composable
fun LoginContent(
    vm: LoginViewModel,
    letsDoIt: () -> Unit,
    back: () -> Unit
) {

    val state by vm.state.collectAsState()

    LaunchedEffect(Unit) {
        vm.subscribeToken(letsDoIt)
    }

    Content(
        loading = { state.loading },
        error = { state.error },
        clearError = vm::clearError,
        back = back,

        login = vm::login,
        registration = vm::registration,

        email = { state.email },
        updateEmail = vm::updateEmail,
        password = { state.password },
        updatePassword = vm::updatePassword
    )
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

    BackgroundIntroVideo()

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
                    .alphaOverlay(
                        delayMillis = 2000,
                        durationMillis = 800
                    )
                    .recomposeHighlighter(),
                provideText = { "\uD83D\uDC4B Welcome back" },
                textAlign = TextAlign.Start,
                maxLines = 1
            )
        },
        footer = {

            ButtonPrimary(
                modifier = Modifier
                    .fillMaxWidth()
                    .alphaOverlay(
                        delayMillis = 2000,
                        durationMillis = 800
                    )
                    .recomposeHighlighter(),
                text = "Log In",
                onClick = loginProvider
            )

            ButtonQuestion(
                modifier = Modifier
                    .fillMaxWidth()
                    .alphaOverlay(
                        delayMillis = 2000,
                        durationMillis = 800
                    )
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
                        .alphaOverlay(
                            delayMillis = 2000,
                            durationMillis = 800
                        )
                        .recomposeHighlighter(),
                    provideValue = email,
                    onValueChange = updateEmail
                )
            }
            item(key = "input_password") {
                InputPassword(
                    modifier = Modifier
                        .fillMaxWidth()
                        .alphaOverlay(
                            delayMillis = 2000,
                            durationMillis = 800
                        )
                        .recomposeHighlighter(),
                    provideValue = password,
                    onValueChange = updatePassword
                )
            }
        }
    )
}