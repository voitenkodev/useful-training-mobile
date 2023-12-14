package authentication.register.pages

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
import components.inputs.InputName
import molecule.ButtonPrimary
import molecule.PaddingM
import molecule.PaddingWeight
import molecule.PaddingXL
import molecule.TextBody2
import molecule.TextH2

@Composable
internal fun NamePage(
    name: String,
    updateName: (String) -> Unit,
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

        TextH2(provideText = { "Nice to meet you" })

        TextBody2(provideText = { "How can we call you?" })

        PaddingXL()

        InputName(
            provideValue = { name },
            onValueChange = updateName
        )

        PaddingM()

        PaddingWeight()

        ButtonPrimary(
            text = "Confirm",
            onClick = confirmProvider,
            enabled = name.isNotBlank()
        )

        PaddingXL()
    }
}
