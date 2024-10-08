package authentication.register.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import atom.Design
import components.BottomButtons
import components.inputs.InputName
import molecule.ButtonPrimary
import molecule.ButtonSecondary
import molecule.PaddingL
import molecule.PaddingM
import molecule.PaddingWeight
import molecule.PaddingXS
import molecule.PaddingXXL
import molecule.TextBody1
import molecule.TextH1
import resources.Icons

@Composable
internal fun NamePage(
    name: String,
    updateName: (String) -> Unit,
    confirm: () -> Unit,
    back: () -> Unit,
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
        modifier = Modifier.fillMaxSize().imePadding(),
        horizontalAlignment = Alignment.Start
    ) {

        PaddingL()

        TextH1(
            modifier = Modifier.padding(horizontal = Design.dp.paddingL),
            provideText = { "Nice to meet you" },
        )

        PaddingXS()

        TextBody1(
            modifier = Modifier.padding(horizontal = Design.dp.paddingL),
            provideText = { "How can we call you?" },
            color = Design.colors.label
        )

        PaddingXXL()

        InputName(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = Design.dp.paddingL),
            provideValue = { name },
            onValueChange = updateName
        )

        PaddingM()

        PaddingWeight()

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
                    trailingIcon = Icons.arrowRight,
                    text = "Next",
                    onClick = confirmProvider,
                    enabled = name.isNotBlank()
                )
            }
        )
    }
}
