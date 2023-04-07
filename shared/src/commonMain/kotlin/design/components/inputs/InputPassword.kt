package design.components.inputs

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import design.Design
import design.atomic.icons.Eye
import design.atomic.icons.EyeOff
import design.components.labels.InputLabel
import design.controls.IconPrimary
import design.controls.InputFieldPrimary
import design.controls.tertiaryBackground

@Composable
internal fun InputPassword(
    modifier: Modifier = Modifier,
    value: String?,
    onValueChange: (String) -> Unit,
) {
    val focusManager = LocalFocusManager.current
    val passwordVisibility = rememberSaveable { mutableStateOf(false) }

    InputFieldPrimary(
        modifier = modifier
            .tertiaryBackground()
            .padding(horizontal = Design.dp.padding),
        value = value,
        onValueChange = onValueChange,
        visualTransformation = if (passwordVisibility.value) VisualTransformation.None else PasswordVisualTransformation(),
        leading = { InputLabel(text = "Password") },
        trailing = {
            AnimatedVisibility(
                visible = value?.isNotEmpty() == true,
                enter = fadeIn() + scaleIn(),
                exit = scaleOut() + fadeOut(),
            ) {
                IconPrimary(
                    imageVector = if (passwordVisibility.value) EyeOff else Eye,
                    color = Design.colors.caption,
                    onClick = { passwordVisibility.value = passwordVisibility.value.not() }
                )
            }
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