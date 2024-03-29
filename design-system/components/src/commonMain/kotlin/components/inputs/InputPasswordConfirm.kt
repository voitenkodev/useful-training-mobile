package components.inputs

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import atom.Design
import components.labels.InputLabel
import molecule.ButtonIconSecondary
import molecule.InputField
import resources.Icons

@Composable
public fun InputPasswordRepeat(
    modifier: Modifier = Modifier,
    provideValue: () -> String,
    onValueChange: (String) -> Unit
) {
    val passwordVisibility = rememberSaveable { mutableStateOf(false) }

    InputField(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = Design.dp.paddingM),
        value = provideValue.invoke(),
        onValueChange = onValueChange,
        visualTransformation = if (passwordVisibility.value) VisualTransformation.None else PasswordVisualTransformation(),
        label = { InputLabel(provideText = { "Confirm password" }) },
        placeholder = "********",
        backgroundColor = Design.colors.secondary,
        trailing = {
            ButtonIconSecondary(
                imageVector = if (passwordVisibility.value) Icons.eyeOff else Icons.eye,
                color = Design.colors.caption,
                onClick = { passwordVisibility.value = passwordVisibility.value.not() }
            )
        },
        maxLines = 1,
        keyboardOptions = KeyboardOptions(
            capitalization = KeyboardCapitalization.None,
            imeAction = ImeAction.Next,
            keyboardType = KeyboardType.Password
        )
    )
}