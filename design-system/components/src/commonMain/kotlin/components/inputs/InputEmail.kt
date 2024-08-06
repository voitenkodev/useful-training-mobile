package components.inputs

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import atom.Design
import components.labels.InputLabel
import molecule.ButtonIconSecondary
import molecule.Input

@Composable
public fun InputEmail(
    modifier: Modifier = Modifier,
    provideValue: () -> String,
    onValueChange: (String) -> Unit
) {

    val focusManager = LocalFocusManager.current

    Input(
        modifier = modifier,
        value = provideValue(),
        onValueChange = onValueChange,
        trailing = {
            AnimatedVisibility(
                modifier = Modifier,
                visible = provideValue().isNotEmpty(),
                enter = fadeIn() + scaleIn(),
                exit = scaleOut() + fadeOut(),
            ) {
                ButtonIconSecondary(
                    modifier = Modifier.size(Design.dp.componentXXS),
                    imageVector = resources.Icons.clear,
                    color = it.copy(alpha = 0.5f),
                    onClick = { onValueChange.invoke("") }
                )
            }
        },
        placeholder = "Your email",
        label = {
            InputLabel(provideText = { "Enter email" })
        },
        maxLines = 1,
        keyboardActions = KeyboardActions { focusManager.moveFocus(FocusDirection.Next) },
        keyboardOptions = KeyboardOptions(
            capitalization = KeyboardCapitalization.None,
            imeAction = ImeAction.Next,
            keyboardType = KeyboardType.Email
        )
    )
}