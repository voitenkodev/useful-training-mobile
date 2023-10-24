package components.inputs

import Design
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.layout.padding
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
import components.labels.InputLabel
import molecular.ButtonIconSecondary
import molecular.InputPrimary
import molecular.reversedCircleBackground
import recomposeHighlighter

@Composable
public fun InputSearch(
    modifier: Modifier = Modifier,
    value: () -> String,
    onValueChange: (String) -> Unit,
) {
    val focusManager = LocalFocusManager.current

    InputPrimary(
        modifier = modifier
            .reversedCircleBackground()
            .padding(horizontal = Design.dp.paddingM)
            .recomposeHighlighter(),
        provideValue = value,
        onValueChange = onValueChange,
        color = Design.colors.primary,
        trailing = {
            AnimatedVisibility(
                modifier = Modifier.recomposeHighlighter(),
                visible = value().isNotEmpty(),
                enter = fadeIn() + scaleIn(),
                exit = scaleOut() + fadeOut(),
            ) {
                ButtonIconSecondary(
                    modifier = Modifier.recomposeHighlighter(),
                    imageVector = Icons.Default.Clear,
                    color = Design.colors.caption,
                    onClick = { onValueChange.invoke("") }
                )
            }
        },
        leading = {
            InputLabel(
                modifier = Modifier.recomposeHighlighter(),
                provideText = { "Search" },
            )
        },
        maxLines = 1,
        keyboardActions = KeyboardActions { focusManager.moveFocus(FocusDirection.Next) },
        keyboardOptions = KeyboardOptions(
            capitalization = KeyboardCapitalization.Sentences,
            imeAction = ImeAction.Next,
            keyboardType = KeyboardType.Email
        )
    )
}