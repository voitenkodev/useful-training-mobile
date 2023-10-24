package components.inputs

import Design
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
import atomic.icons.Eye
import atomic.icons.EyeOff
import components.labels.InputLabel
import molecular.ButtonIconSecondary
import molecular.InputPrimary
import molecular.reversedCircleBackground
import recomposeHighlighter

@Composable
public fun InputPassword(
    modifier: Modifier = Modifier,
    provideValue: () -> String,
    onValueChange: (String) -> Unit,
) {
    val passwordVisibility = rememberSaveable { mutableStateOf(false) }

    InputPrimary(
        modifier = modifier
            .reversedCircleBackground()
            .padding(horizontal = Design.dp.paddingM)
            .recomposeHighlighter(),
        provideValue = provideValue,
        onValueChange = onValueChange,
        color = Design.colors.primary,
        visualTransformation = if (passwordVisibility.value) VisualTransformation.None else PasswordVisualTransformation(),
        leading = {
            InputLabel(
                modifier = Modifier.recomposeHighlighter(),
                provideText = { "Password" }
            )
        },
        trailing = {
            ButtonIconSecondary(
                imageVector = if (passwordVisibility.value) EyeOff else Eye,
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