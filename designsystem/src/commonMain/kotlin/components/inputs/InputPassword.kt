package components.inputs

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.*
import androidx.compose.ui.unit.dp
import DesignComponent
import atomic.icons.Eye
import atomic.icons.EyeOff
import components.labels.InputLabel
import controls.IconPrimary
import controls.InputFieldPrimary
import controls.secondaryBackground

@Composable
fun InputPassword(
    modifier: Modifier = Modifier,
    value: String?,
    onValueChange: (String) -> Unit,
) {
    val focusManager = LocalFocusManager.current

    val passwordVisibility = rememberSaveable { mutableStateOf(false) }

    InputFieldPrimary(
        modifier = modifier
            .secondaryBackground()
            .padding(16.dp),
        value = value,
        onValueChange = onValueChange,
        visualTransformation = if (passwordVisibility.value) VisualTransformation.None else PasswordVisualTransformation(),
        leading = { InputLabel(text = "Password") },
        trailing = {
            IconPrimary(
                imageVector = if (passwordVisibility.value) EyeOff else Eye,
                color = DesignComponent.colors.caption,
                onClick = { passwordVisibility.value = passwordVisibility.value.not() }
            )
        },
        maxLines = 1,
        keyboardActions = KeyboardActions { focusManager.moveFocus(FocusDirection.Next) },
        keyboardOptions = KeyboardOptions(
            capitalization = KeyboardCapitalization.Sentences,
            imeAction = ImeAction.Next,
            keyboardType = KeyboardType.Password
        )
    )
}