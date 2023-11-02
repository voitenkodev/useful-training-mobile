package authentication.screen

import PlatformBackHandler
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import authentication.state.TokenStatus
import components.Error
import components.Loading
import components.backgrounds.SpaceBackground
import components.buttons.ButtonQuestion
import components.inputs.InputEmail
import components.inputs.InputPassword
import components.overlay.AlphaOverlay
import components.roots.Root
import components.states.keyboardFloatAsState
import molecule.ButtonPrimary
import molecule.PaddingM
import molecule.PaddingS
import molecule.PaddingWeight
import molecule.PaddingXL
import molecule.TextBody1
import molecule.TextH1
import molecule.paddingM
import platformInsets

@Composable
internal fun AuthenticationContent(
    vm: AuthenticationViewModel,
    toTrainings: () -> Unit,
    toRegistration: () -> Unit,
    back: () -> Unit
) {

    val state by vm.state.collectAsState()

    LaunchedEffect(state.tokenStatus) {
        if (state.tokenStatus == TokenStatus.Available) toTrainings.invoke()
    }

    Content(
        loading = { state.loading },
        error = { state.error },
        clearError = vm::clearError,
        back = back,
        login = vm::login,
        registration = toRegistration,
        email = state.email,
        updateEmail = vm::updateEmail,
        password = state.password,
        updatePassword = vm::updatePassword
    )
}

@Composable
private fun Content(
    loading: () -> Boolean,
    error: () -> String?,
    clearError: () -> Unit,
    back: () -> Unit,

    login: () -> Unit,
    registration: () -> Unit,

    email: String,
    updateEmail: (String) -> Unit,
    password: String,
    updatePassword: (String) -> Unit
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
        targetValue = 0.1f
    )

    Root(
        loading = { Loading(loading) },
        error = { Error(message = error, close = clearError) },
        back = { PlatformBackHandler(backProvider) }
    ) {

        SpaceBackground()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .platformInsets()
                .paddingM(),
        ) {

            PaddingXL()

            PaddingXL()

            TextH1(
                provideText = { "WELCOME BACK" }
            )

            TextBody1(
                provideText = { "Good to see you again, enter your details\nbelow to continue exercises." },
            )

            PaddingXL()

            InputEmail(
                modifier = Modifier.fillMaxWidth(),
                provideValue = { email },
                onValueChange = updateEmail
            )

            PaddingM()

            InputPassword(
                modifier = Modifier.fillMaxWidth(),
                provideValue = { password },
                onValueChange = updatePassword
            )

            PaddingM()

            PaddingWeight(value = keyboardFloatAsState.value)

            ButtonPrimary(
                modifier = Modifier
                    .width(200.dp)
                    .align(Alignment.CenterHorizontally),
                text = "Sign In",
                onClick = loginProvider,
                enabled = email.isNotBlank() && password.isNotBlank()
            )

            PaddingWeight(value = 1 - keyboardFloatAsState.value)

            PaddingS()

            ButtonQuestion(
                modifier = Modifier.fillMaxWidth(),
                question = "Don't have an account yet?",
                answer = "Join Us!",
                onClick = registrationProvider
            )
        }

        AlphaOverlay(
            modifier = Modifier.fillMaxSize()
        )
    }
}