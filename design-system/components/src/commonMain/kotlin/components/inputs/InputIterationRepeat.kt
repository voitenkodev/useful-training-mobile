package components.inputs

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import components.labels.InputLabel
import molecule.Input

@Composable
public fun InputRepeat(
    modifier: Modifier = Modifier,
    provideValue: () -> String,
    onValueChange: (String) -> Unit
) {

    var tfv by remember {
        val textFieldValue = TextFieldValue(
            text = provideValue(),
            selection = TextRange(provideValue().length)
        )
        mutableStateOf(textFieldValue)
    }

    Input(
        modifier = modifier,
        value = tfv,
        onValueChange = {
            tfv = it
            onValueChange.invoke(it.text)
        },
        textAlign = TextAlign.Center,
        leading = { InputLabel(provideText = { "Rps:" }) },
        maxLines = 1,
        maxLength = 2,
        placeholder = "0",
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number,
            imeAction = ImeAction.Next
        ),
        digits = arrayOf('1', '2', '3', '4', '5', '6', '7', '8', '9', '0'),
    )
}