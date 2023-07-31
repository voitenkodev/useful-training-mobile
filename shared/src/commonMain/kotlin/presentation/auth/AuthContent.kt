package presentation.auth

import Design
import PlatformBackHandler
import VideoManager
import VideoPlayer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import components.Error
import components.Loading
import components.buttons.ButtonQuestion
import components.inputs.InputEmail
import components.inputs.InputPassword
import components.roots.ScrollableRoot
import controls.ButtonPrimary
import controls.TextFieldBody1
import controls.TextFieldH1
import utils.Logger
import utils.recomposeHighlighter

@Composable
internal fun AuthContent(vm: AuthViewModel) {

    val state by vm.state.collectAsState()

    VideoPlayer(
        modifier = Modifier.fillMaxSize(),
        url = VideoManager.getLocalVideoPath("intro", "mp4") ?: "",
//        "http://thinkingform.com/wp-content/uploads/2017/09/video-sample-mp4.mp4?_=1"
    )

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
            .fillMaxWidth()
            .recomposeHighlighter(),
        loading = { Loading(loading) },
        error = { Error(message = error, close = clearError) },
        back = { PlatformBackHandler(back) },
        header = {
            TextFieldH1(
                modifier = Modifier
                    .height(Design.dp.bigHeader)
                    .recomposeHighlighter(),
                provideText = { "\uD83D\uDC4B Welcome back!" },
                textAlign = TextAlign.Center
            )
        },
        footer = {

            ButtonPrimary(
                modifier = Modifier
                    .fillMaxWidth()
                    .recomposeHighlighter(),
                text = "Log In",
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
            item(key = "notes") {
                TextFieldBody1(
                    modifier = Modifier
                        .recomposeHighlighter(),
                    provideText = { "Sign in to your account" },
                    color = Design.colors.caption
                )
            }
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