package molecule

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import atom.Design

@Composable
public fun InputField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String? = null,
    textAlign: TextAlign? = null,
    leading: @Composable (() -> Unit)? = null,
    trailing: @Composable (() -> Unit)? = null,
    maxLines: Int = Int.MAX_VALUE,
    enabled: Boolean = true,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    maxLength: Int? = null,
    fontWeight: FontWeight? = null,
    digits: Array<Char> = emptyArray(),
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    visualTransformation: VisualTransformation = VisualTransformation.None,
) {

    val updater by remember {
        mutableStateOf(
            { s: String ->
                val v = if (maxLength != null) s.take(maxLength) else s
                val digitsFilter = if (digits.isNotEmpty()) v.filter { char -> digits.contains(char) } else v
                onValueChange.invoke(digitsFilter)
            }
        )
    }

    val textStyle = Design.typography.Input
        .merge(color = Design.colors.content)
        .merge(textAlign = textAlign)
        .merge(fontWeight = fontWeight)

    androidx.compose.material3.OutlinedTextField(
        value = value,
        onValueChange = updater,
        modifier = modifier,
        enabled = enabled,
        colors = OutlinedTextFieldDefaults.colors(
            errorContainerColor = Design.colors.red,

            focusedContainerColor = Design.colors.secondary,
            disabledContainerColor = Design.colors.black30,
            unfocusedContainerColor = Design.colors.secondary,

            disabledBorderColor = Color.Transparent,
            errorBorderColor = Design.colors.red,
            focusedBorderColor = Design.colors.white5,
            unfocusedBorderColor = Design.colors.white5,

            unfocusedPlaceholderColor = Design.colors.content.copy(alpha = 0.3f),
            disabledPlaceholderColor = Design.colors.content.copy(alpha = 0.3f),
            errorPlaceholderColor = Design.colors.content.copy(alpha = 0.3f),
            focusedPlaceholderColor = Design.colors.content.copy(alpha = 0.3f),

            cursorColor = Design.colors.content
        ),
        shape = Design.shape.default,
        placeholder = placeholder?.let {
            {
                androidx.compose.material3.Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = placeholder,
                    maxLines = 1,
                    textAlign = textStyle.textAlign,
                    fontFamily = textStyle.fontFamily,
                    fontSize = textStyle.fontSize,
                )
            }
        },
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        prefix = leading,
        suffix = trailing,
        maxLines = maxLines,
        singleLine = maxLines == 1,
        textStyle = textStyle
    )
}