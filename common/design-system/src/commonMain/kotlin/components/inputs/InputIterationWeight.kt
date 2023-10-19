package components.inputs

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import controls.InputFieldSecondary
import controls.rootBackground
import recomposeHighlighter

@Composable
public fun InputWeight(
    modifier: Modifier = Modifier,
    provideValue: () -> String,
    onValueChange: (String) -> Unit,
) {
    val focusManager = LocalFocusManager.current

    InputFieldSecondary(
        modifier = modifier
            .rootBackground()
            .recomposeHighlighter(),
        provideValue = provideValue,
        onValueChange = onValueChange,
        textAlign = TextAlign.Center,
        maxLines = 1,
        maxLength = 6,
        placeholder = "0.0",
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number, imeAction = ImeAction.Next),
        keyboardActions = KeyboardActions { focusManager.moveFocus(FocusDirection.Next) },
        digits = arrayOf('1', '2', '3', '4', '5', '6', '7', '8', '9', '0', ',', '.'),
    )
}