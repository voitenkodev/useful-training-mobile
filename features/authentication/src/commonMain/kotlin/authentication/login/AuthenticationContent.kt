package authentication.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import atom.Design
import authentication.login.models.AuthStatus
import components.inputs.InputEmail
import components.inputs.InputPassword
import components.roots.ScreenRoot
import molecule.ButtonPrimary
import molecule.ButtonTextLink
import molecule.PaddingL
import molecule.PaddingM
import molecule.PaddingWeight
import molecule.PaddingXL
import molecule.TextBody2
import molecule.TextH2
import molecule.primaryBackground

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
        updatePassword = vm::updatePassword
    )
}

@Composable
private fun Content(
    loading: () -> Boolean,
    error: () -> String?,
    clearError: () -> Unit,

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

    ScreenRoot(modifier = Modifier.primaryBackground().imePadding()) {

        Column(
            modifier = Modifier.fillMaxSize().systemBarsPadding(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            PaddingXL()

            PaddingM()

            TextH2(provideText = { "Sign In" }, textAlign = TextAlign.Center)

            TextBody2(provideText = { "Sign in with your email" }, textAlign = TextAlign.Center)

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

            PaddingWeight()

            ButtonPrimary(
                modifier = Modifier.width(Design.dp.componentXXL),
                text = "Sign In",
                onClick = loginProvider,
                enabled = email.isNotBlank() && password.isNotBlank(),
                loading = loading()
            )

            PaddingL()

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.CenterHorizontally),
                verticalAlignment = Alignment.CenterVertically
            ) {

                TextBody2(
                    provideText = { "Don't have an account yet?" },
                    color = Design.colors.caption
                )

                ButtonTextLink(
                    text = "Join Us!",
                    onClick = registrationProvider
                )
            }

            PaddingL()
        }
    }
}