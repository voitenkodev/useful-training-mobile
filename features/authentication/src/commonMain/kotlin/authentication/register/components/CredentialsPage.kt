package authentication.register.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import components.inputs.InputEmail
import components.inputs.InputPassword
import components.inputs.InputPasswordRepeat
import molecule.ButtonPrimary
import molecule.PaddingM
import molecule.PaddingWeight
import molecule.PaddingXL
import molecule.TextBody2
import molecule.TextH2

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

    Column(
        modifier = Modifier.fillMaxSize().imePadding().navigationBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        PaddingM()

        TextH2(provideText = { "Credentials" })

        TextBody2(provideText = { "Enter email and password!" })

        PaddingXL()

        InputEmail(
            provideValue = { email },
            onValueChange = updateEmail
        )

        PaddingXL()

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

        PaddingWeight()

        ButtonPrimary(
            text = "Register",
            onClick = confirmProvider,
            enabled = email.isNotBlank() && password.isNotBlank() && passwordRepeat.isNotBlank(),
            loading = loading
        )

        PaddingXL()
    }
}
