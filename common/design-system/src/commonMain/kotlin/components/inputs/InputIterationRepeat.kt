package components.inputs

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import molecular.InputSecondary
import recomposeHighlighter

@Composable
public fun InputRepeat(
    modifier: Modifier = Modifier,
    provideValue: () -> String,
    onValueChange: (String) -> Unit,
) {
    InputSecondary(
        modifier = modifier.recomposeHighlighter(),
        provideValue = provideValue,
        onValueChange = onValueChange,
        textAlign = TextAlign.Center,
        maxLines = 1,
        maxLength = 2,
        placeholder = "0",
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number, imeAction = ImeAction.Next),
        digits = arrayOf('1', '2', '3', '4', '5', '6', '7', '8', '9', '0'),
    )
}