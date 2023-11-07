package registration.components

import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import components.inputs.InputEmail
import components.inputs.InputPassword
import components.inputs.InputPasswordRepeat
import components.states.animateAlignmentAsState
import components.states.keyboardAsBoolean
import molecule.ButtonPrimary
import molecule.PaddingL
import molecule.PaddingM
import molecule.PaddingXL
import molecule.TextBody1
import molecule.TextH2
import platformBottomInset

@Composable
internal fun CredentialsPage(
    loading: Boolean,
    email: String,
    password: String,
    passwordRepeat: String,
    updateEmail: (String) -> Unit,
    updatePassword: (String) -> Unit,
    updatePasswordRepeat: (String) -> Unit,
    confirm: () -> Unit
) {
    val focus = LocalFocusManager.current

    val confirmProvider by rememberUpdatedState {
        focus.clearFocus()
        confirm.invoke()
    }

    val align = animateAlignmentAsState(
        targetAlignment = if (keyboardAsBoolean()) Alignment.TopCenter else Alignment.BottomCenter,
        animationSpec = tween(durationMillis = 400, easing = LinearOutSlowInEasing)
    )

    Column(
        modifier = Modifier.fillMaxSize().platformBottomInset(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        PaddingL()

        TextH2(provideText = { "Credentials" })

        TextBody1(provideText = { "Enter email and password!" })

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

        InputPasswordRepeat(
            provideValue = { passwordRepeat },
            onValueChange = updatePasswordRepeat
        )

        PaddingM()

        Box(
            modifier = Modifier.weight(1f),
            contentAlignment = align.value
        ) {

            ButtonPrimary(
                text = "Register",
                onClick = confirmProvider,
                enabled = email.isNotBlank() && password.isNotBlank() && passwordRepeat.isNotBlank(),
                loading = loading
            )
        }

        PaddingXL()
    }
}
