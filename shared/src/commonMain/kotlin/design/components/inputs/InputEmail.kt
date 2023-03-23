package design.components.inputs

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import design.Design
import design.components.labels.InputLabel
import design.controls.IconPrimary
import design.controls.InputFieldPrimary
import design.controls.tertiaryBackground

@Composable
internal fun InputEmail(
    modifier: Modifier = Modifier,
    value: String?,
    onValueChange: (String) -> Unit,
) {

    var isFocused by remember { mutableStateOf(false) }

    InputFieldPrimary(
        modifier = modifier
            .tertiaryBackground()
            .onFocusChanged { isFocused = it.isFocused }
            .padding(horizontal = Design.dp.padding),
        value = value,
        onValueChange = onValueChange,
        trailing = value
            .takeIf { isFocused && it?.isNotEmpty() == true }
            ?.let {
                {
                    IconPrimary(
                        imageVector = Icons.Default.Clear,
                        color = Design.colors.caption,
                        onClick = { onValueChange.invoke(String()) }
                    )
                }
            },
        leading = { InputLabel(text = "Email") },
        maxLines = 1,
        keyboardOptions = KeyboardOptions(
            capitalization = KeyboardCapitalization.Sentences,
            imeAction = ImeAction.Next,
            keyboardType = KeyboardType.Email
        )
    )
}