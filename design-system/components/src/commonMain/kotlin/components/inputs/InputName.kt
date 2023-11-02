package components.inputs

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import atom.Design
import components.labels.InputLabel
import molecule.ButtonIconSecondary
import molecule.InputPrimary
import molecule.reversedCircleBackground

@Composable
public fun InputName(
    modifier: Modifier = Modifier,
    provideValue: () -> String,
    onValueChange: (String) -> Unit,
) {

    val focusManager = LocalFocusManager.current

    InputPrimary(
        modifier = modifier
            .reversedCircleBackground()
            .padding(horizontal = Design.dp.paddingM),
        provideValue = provideValue,
        onValueChange = onValueChange,
        color = Design.colors.primary,
        trailing = {

            AnimatedVisibility(
                visible = provideValue().isNotEmpty(),
                enter = fadeIn() + scaleIn(),
                exit = scaleOut() + fadeOut(),
            ) {
                ButtonIconSecondary(
                    modifier = Modifier
                        .wrapContentSize()
                        .height(IntrinsicSize.Min),
                    imageVector = Icons.Default.Clear,
                    color = Design.colors.caption,
                    onClick = { onValueChange.invoke("") }
                )
            }
        },
        leading = {
            InputLabel(
                provideText = { "Name" }
            )
        },
        maxLines = 1,
        keyboardActions = KeyboardActions { focusManager.moveFocus(FocusDirection.Next) },
        keyboardOptions = KeyboardOptions(
            capitalization = KeyboardCapitalization.None,
            imeAction = ImeAction.Next,
            keyboardType = KeyboardType.Text,
        )
    )
}