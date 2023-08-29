package presentation.auth

import Design
import PlatformBackHandler
import VideoPlayer
import Videos
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import components.Error
import components.Loading
import components.buttons.ButtonQuestion
import components.inputs.InputEmail
import components.inputs.InputPassword
import components.roots.ScrollableRoot
import controls.ButtonPrimary
import controls.TextFieldBody1
import controls.TextFieldH1
import controls.primaryBackground
import controls.primaryFrame
import kotlinx.coroutines.delay
import utils.recomposeHighlighter

@Composable
internal fun AuthContent(vm: AuthViewModel) {

    val state by vm.state.collectAsState()

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

    BackgroundVideo()

    ScrollableRoot(
        modifier = Modifier
            .padding(top = 44.dp, bottom = 30.dp) // TODO MOVE IT TO IOS PART
            .fillMaxSize()
            .recomposeHighlighter(),
        loading = { Loading(loading) },
        error = { Error(message = error, close = clearError) },
        back = { PlatformBackHandler(back) },
        header = {
            TextFieldH1(
                modifier = Modifier
                    .height(Design.dp.bigHeader)
                    .alphaPresent(
                        delayMillis = 100,
                        durationMillis = 700
                    )
                    .recomposeHighlighter(),
                provideText = { "\uD83D\uDC4B Welcome back!" },
                textAlign = TextAlign.Center
            )
        },
        footer = {

            ButtonPrimary(
                modifier = Modifier
                    .fillMaxWidth()
                    .alphaPresent(
                        delayMillis = 500,
                        durationMillis = 700
                    )
                    .recomposeHighlighter(),
                text = "Log In",
                onClick = loginProvider
            )

            ButtonQuestion(
                modifier = Modifier
                    .fillMaxWidth()
                    .alphaPresent(
                        delayMillis = 500,
                        durationMillis = 700
                    )
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
                        .alphaPresent(
                            delayMillis = 100,
                            durationMillis = 700
                        )
                        .recomposeHighlighter(),
                    provideText = { "Sign in to your account" },
                    color = Design.colors.caption
                )
            }
            item(key = "input_email") {
                InputEmail(
                    modifier = Modifier
                        .fillMaxWidth()
                        .alphaPresent(
                            delayMillis = 300,
                            durationMillis = 700
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
                        .alphaPresent(
                            delayMillis = 300,
                            durationMillis = 700
                        )
                        .recomposeHighlighter(),
                    provideValue = password,
                    onValueChange = updatePassword
                )
            }
        }
    )
}

@Composable
private fun BackgroundVideo() {
    val animatedValue = remember { mutableStateOf(1f) }

    val animatedFloat by animateFloatAsState(
        targetValue = animatedValue.value,
        animationSpec = tween(durationMillis = 1700)
    )

    LaunchedEffect(Unit) {
        delay(500)
        animatedValue.value = 0.4f
    }

    VideoPlayer(
        modifier = Modifier
            .fillMaxSize(),
        nativeLocalResource = Videos.intro_2,
    )

    Spacer(
        Modifier
            .fillMaxSize()
            .primaryFrame()
    )

    Spacer(
        Modifier
            .fillMaxSize()
            .alpha(animatedFloat)
            .primaryBackground()
    )
}

// TODO Move it to Design system
@Composable
fun Modifier.alphaPresent(
    durationMillis: Int,
    delayMillis: Int
): Modifier = composed {
    val animatedValue = remember { mutableStateOf(0f) }

    val animatedFloat by animateFloatAsState(
        targetValue = animatedValue.value,
        animationSpec = tween(durationMillis, delayMillis)
    )

    LaunchedEffect(Unit) {
        animatedValue.value = 1f
    }

    this.then(
        Modifier.graphicsLayer(alpha = animatedFloat)
    )
}