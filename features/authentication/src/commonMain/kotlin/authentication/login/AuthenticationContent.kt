package authentication.login

import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import authentication.login.state.AuthStatus
import authentication.login.state.ScreenState
import components.Error
import components.buttons.ButtonQuestion
import components.inputs.InputEmail
import components.inputs.InputPassword
import components.overlay.AlphaOverlay
import components.roots.ScreenRoot
import components.states.animateAlignmentAsState
import components.states.keyboardAsBoolean
import molecule.ButtonPrimary
import molecule.PaddingL
import molecule.PaddingM
import molecule.PaddingXL
import molecule.TextBody2
import molecule.TextH2
import platformInsets

@Composable
internal fun AuthenticationContent(
    vm: AuthenticationViewModel,
    toTrainings: () -> Unit,
    toRegistration: () -> Unit
) {

    val state by vm.state.collectAsState()

    LaunchedEffect(state.authStatus) {
        if (state.authStatus == AuthStatus.Available) toTrainings.invoke()
    }

    Content(
        loading = { state.loading },
        error = { state.error },
        clearError = vm::clearError,
        login = vm::login,
        registration = toRegistration,
        email = state.email,
        updateEmail = vm::updateEmail,
        password = state.password,
        updatePassword = vm::updatePassword,
        screenState = state.screenState,
        markScreenAsShowedOnce = vm::markScreenAsShowedOnce
    )
}

@Composable
private fun Content(
    loading: () -> Boolean,
    error: () -> String?,
    clearError: () -> Unit,

    screenState: ScreenState,
    markScreenAsShowedOnce: () -> Unit,

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

    val align = animateAlignmentAsState(
        targetAlignment = if (keyboardAsBoolean()) Alignment.TopCenter else Alignment.BottomCenter,
        animationSpec = tween(durationMillis = 400, easing = LinearOutSlowInEasing)
    )

    ScreenRoot(error = { Error(message = error, close = clearError) }) {

        Column(
            modifier = Modifier.fillMaxSize().platformInsets(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            PaddingXL()

            PaddingM()

            TextH2(provideText = { "Alien Workout" })

            TextBody2(provideText = { "Take your power-up" })

            PaddingXL()

            InputEmail(
                provideValue = { email },
                onValueChange = updateEmail
            )

            PaddingM()

            InputPassword(
                provideValue = { password },
                onValueChange = updatePassword
            )

            PaddingM()

            Box(
                modifier = Modifier.weight(1f),
                contentAlignment = align.value
            ) {

                ButtonPrimary(
                    text = "Sign In",
                    onClick = loginProvider,
                    enabled = email.isNotBlank() && password.isNotBlank(),
                    loading = loading()
                )
            }

            PaddingL()

            ButtonQuestion(
                modifier = Modifier.fillMaxWidth(),
                question = "Don't have an account yet?",
                answer = "Join Us!",
                onClick = registrationProvider
            )

            PaddingL()
        }

        AlphaOverlay(
            modifier = Modifier.fillMaxSize(),
            condition = screenState == ScreenState.Default,
            finishedListener = markScreenAsShowedOnce
        )
    }
}