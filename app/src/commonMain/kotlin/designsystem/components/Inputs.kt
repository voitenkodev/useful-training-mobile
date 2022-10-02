package designsystem.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.*
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import designsystem.common.DesignComponent
import designsystem.common.Eye
import designsystem.common.EyeOff
import designsystem.controls.IconPrimary
import designsystem.controls.InputFieldPrimary
import designsystem.controls.InputFieldSecondary

@Composable
fun InputEmail(
    modifier: Modifier = Modifier,
    value: String?,
    onValueChange: (String) -> Unit,
) {
    val focusManager = LocalFocusManager.current

    InputFieldPrimary(
        modifier = modifier
            .background(DesignComponent.colors.secondary, DesignComponent.shape.default)
            .padding(16.dp),
        value = value,
        onValueChange = onValueChange,
        trailing = value?.isNotEmpty().takeIf { it == true }?.let {
            {
                IconPrimary(
                    imageVector = Icons.Default.Clear,
                    color = DesignComponent.colors.caption,
                    onClick = { onValueChange.invoke(String()) }
                )
            }
        },
        leading = { InputLabel(text = "Email") },
        maxLines = 1,
        keyboardActions = KeyboardActions { focusManager.moveFocus(FocusDirection.Next) },
        keyboardOptions = KeyboardOptions(
            capitalization = KeyboardCapitalization.Sentences,
            imeAction = ImeAction.Next,
            keyboardType = KeyboardType.Email
        )
    )
}

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

@Composable
fun InputName(
    modifier: Modifier = Modifier,
    value: String?,
    onValueChange: (String) -> Unit,
) {
    val focusManager = LocalFocusManager.current

    InputFieldPrimary(
        modifier = modifier.fillMaxHeight(),
        value = value,
        placeholder = "Name of exercise",
        maxLines = 1,
        keyboardActions = KeyboardActions { focusManager.moveFocus(FocusDirection.Next) },
        onValueChange = onValueChange,
        keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Sentences, imeAction = ImeAction.Next),
        fontWeight = FontWeight.Bold,
    )
}

@Composable
fun InputWeight(
    modifier: Modifier = Modifier,
    value: String?,
    onValueChange: (String) -> Unit,
) {
    val focusManager = LocalFocusManager.current

    InputFieldSecondary(
        modifier = modifier.padding(bottom = 2.dp),
        value = value,
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

@Composable
fun InputRepeat(
    modifier: Modifier = Modifier,
    value: String?,
    onValueChange: (String) -> Unit,
) {
    InputFieldSecondary(
        modifier = modifier.padding(top = 2.dp),
        value = value,
        onValueChange = onValueChange,
        textAlign = TextAlign.Center,
        maxLines = 1,
        maxLength = 2,
        placeholder = "0",
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number, imeAction = ImeAction.Next),
        digits = arrayOf('1', '2', '3', '4', '5', '6', '7', '8', '9', '0'),
    )
}