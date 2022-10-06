package designsystem.components.inputs

import androidx.compose.foundation.background
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
import designsystem.atomic.DesignComponent
import designsystem.atomic.Eye
import designsystem.atomic.EyeOff
import designsystem.components.labels.InputLabel
import designsystem.controls.IconPrimary
import designsystem.controls.InputFieldPrimary

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
            .background(DesignComponent.colors.secondary, DesignComponent.shape.default)
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