package authentication

import Design
import PlatformBackHandler
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import components.Error
import components.Loading
import components.backgrounds.BackgroundIntro
import components.backgrounds.BrandGradientBottomEnd
import components.buttons.ButtonQuestion
import components.inputs.InputEmail
import components.inputs.InputPassword
import components.overlay.AlphaOverlay
import components.overlay.shadowBottomFrame
import components.roots.Root
import components.states.keyboardFloatAsState
import controls.ButtonBrand
import controls.TextFieldBody1
import controls.TextFieldH1
import platformInsets
import recomposeHighlighter

@Composable
fun AuthenticationContent(
    vm: AuthenticationViewModel,
    toTrainings: () -> Unit,
    back: () -> Unit
) {

    val state by vm.state.collectAsState()

    LaunchedEffect(Unit) {
        vm.subscribeToken(toTrainings)
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
    // BASE
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

    val focus = LocalFocusManager.current

    val loginProvider by rememberUpdatedState {
        focus.clearFocus()
        login.invoke()
    }
    val registrationProvider by rememberUpdatedState {
        focus.clearFocus()
        registration.invoke()
    }
    val backProvider by rememberUpdatedState(back)

    val keyboardFloatAsState = keyboardFloatAsState(
        initialValue = 1f,
        targetValue = 0.3f
    )

    Root(
        loading = { Loading(loading) },
        error = { Error(message = error, close = clearError) },
        back = { PlatformBackHandler(backProvider) },
    ) {

        BackgroundIntro(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(0.8f)
        )

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(0.8f)
                .shadowBottomFrame()
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .platformInsets()
                .padding(Design.dp.paddingM),
        ) {

            Spacer(Modifier.weight(keyboardFloatAsState.value))

            TextFieldH1(
                provideText = { "Welcome Back" }
            )

            Spacer(Modifier.size(4.dp))

            TextFieldBody1(
                provideText = { "Good to see you again, enter your details\nbelow to continue exercises" },
                color = Design.colors.caption
            )

            Spacer(Modifier.size(32.dp))

            InputEmail(
                modifier = Modifier
                    .fillMaxWidth()
                    .recomposeHighlighter(),
                provideValue = email,
                onValueChange = updateEmail
            )

            Spacer(Modifier.size(16.dp))

            InputPassword(
                modifier = Modifier
                    .fillMaxWidth()
                    .recomposeHighlighter(),
                provideValue = password,
                onValueChange = updatePassword
            )

            Spacer(Modifier.size(32.dp))

            ButtonBrand(
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .align(Alignment.CenterHorizontally)
                    .recomposeHighlighter(),
                text = "SIGN IN",
                onClick = loginProvider
            )

            Spacer(Modifier.weight(1f))

            ButtonQuestion(
                modifier = Modifier
                    .fillMaxWidth()
                    .recomposeHighlighter(),
                question = "Don't have an account yet?",
                answer = "Join Us!",
                onClick = registrationProvider
            )
        }

        BrandGradientBottomEnd()

        AlphaOverlay(
            modifier = Modifier.fillMaxSize()
        )
    }
}