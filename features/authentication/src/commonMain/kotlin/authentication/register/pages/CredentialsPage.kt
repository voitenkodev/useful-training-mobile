package authentication.register.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import atom.Design
import components.BottomButtons
import components.inputs.InputEmail
import components.inputs.InputPassword
import components.inputs.InputPasswordConfirm
import molecule.ButtonPrimary
import molecule.ButtonSecondary
import molecule.PaddingL
import molecule.PaddingM
import molecule.PaddingXS
import molecule.PaddingXXL
import molecule.TextBody1
import molecule.TextH1
import resources.Icons

@Composable
internal fun CredentialsPage(
    loading: Boolean,
    email: String,
    password: String,
    passwordRepeat: String,
    updateEmail: (String) -> Unit,
    updatePassword: (String) -> Unit,
    updatePasswordRepeat: (String) -> Unit,
    confirm: () -> Unit,
    back: () -> Unit
) {
    val focus = LocalFocusManager.current

    val confirmProvider by rememberUpdatedState {
        focus.clearFocus()
        confirm.invoke()
    }

    val backProvider by rememberUpdatedState {
        focus.clearFocus()
        back.invoke()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .imePadding()
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .verticalScroll(rememberScrollState()),
        ) {

            PaddingL()

            TextH1(
                modifier = Modifier.padding(horizontal = Design.dp.paddingL),
                provideText = { "Last step" },
            )

            PaddingXS()

            TextBody1(
                modifier = Modifier.padding(horizontal = Design.dp.paddingL),
                provideText = { "Enter email and password!" },
                color = Design.colors.label
            )

            PaddingXXL()

            InputEmail(
                modifier = Modifier.fillMaxWidth()
                    .padding(horizontal = Design.dp.paddingL),
                provideValue = { email },
                onValueChange = updateEmail
            )

            PaddingL()

            InputPassword(
                modifier = Modifier.fillMaxWidth()
                    .padding(horizontal = Design.dp.paddingL),
                provideValue = { password },
                onValueChange = updatePassword
            )

            PaddingM()

            InputPasswordConfirm(
                modifier = Modifier.fillMaxWidth()
                    .padding(horizontal = Design.dp.paddingL),
                provideValue = { passwordRepeat },
                onValueChange = updatePasswordRepeat
            )

            PaddingM()
        }

        PaddingL()

        BottomButtons(
            modifier = Modifier.fillMaxWidth(),
            first = {
                ButtonSecondary(
                    modifier = Modifier.weight(1f),
                    leadingIcon = Icons.arrowLeft,
                    text = "Back",
                    onClick = backProvider
                )
            },
            second = {
                ButtonPrimary(
                    modifier = Modifier.weight(1f),
                    text = "Register",
                    onClick = confirmProvider,
                    enabled = email.isNotBlank() && password.isNotBlank() && passwordRepeat.isNotBlank(),
                )
            }
        )
    }
}
