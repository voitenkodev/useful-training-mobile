package components.inputs

import Design
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
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
import controls.IconPrimary
import controls.InputFieldPrimary
import controls.tertiaryBackground
import utils.recomposeHighlighter

@Composable
fun InputPassword(
    modifier: Modifier = Modifier,
    provideValue: () -> String,
    onValueChange: (String) -> Unit,
) {
    val passwordVisibility = rememberSaveable { mutableStateOf(false) }

    InputFieldPrimary(
        modifier = modifier
            .tertiaryBackground()
            .padding(horizontal = Design.dp.padding)
            .recomposeHighlighter(),
        provideValue = provideValue,
        onValueChange = onValueChange,
        visualTransformation = if (passwordVisibility.value) VisualTransformation.None else PasswordVisualTransformation(),
        leading = {
            InputLabel(
                modifier = Modifier.recomposeHighlighter(),
                provideText = { "Password" }
            )
        },
        trailing = {
            AnimatedVisibility(
                visible = provideValue().isNotEmpty(),
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
        keyboardOptions = KeyboardOptions(
            capitalization = KeyboardCapitalization.None,
            imeAction = ImeAction.Next,
            keyboardType = KeyboardType.Password
        )
    )
}