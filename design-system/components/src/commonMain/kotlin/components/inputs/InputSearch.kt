package components.inputs

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import atom.Design
import components.labels.InputLabel
import molecule.ButtonIconSecondary
import molecule.Icon
import molecule.Input
import molecule.InputStyle
import resources.Icons

@Composable
public fun InputSearch(
    modifier: Modifier = Modifier,
    provideName: () -> String,
    update: (String) -> Unit,
    onClick: (() -> Unit)? = null,
    backgroundColor: Color = Design.colors.secondary,
) {
    val focusManager = LocalFocusManager.current

    Input(
        modifier = modifier.fillMaxWidth(),
        value = provideName.invoke(),
        placeholder = "Search exercise",
        maxLines = 1,
        keyboardActions = KeyboardActions { focusManager.moveFocus(FocusDirection.Next) },
        onValueChange = update,
        backgroundColor = backgroundColor,
        inputStyle = when (onClick) {
            null -> InputStyle.Default
            else -> InputStyle.Clickable(onClick)
        },
        keyboardOptions = KeyboardOptions(
            capitalization = KeyboardCapitalization.Sentences,
            imeAction = ImeAction.Next
        ),
        fontWeight = FontWeight.Bold,
        leading = {
            Icon(
                modifier = Modifier.size(Design.dp.iconS),
                imageVector = Icons.search,
                color = it.copy(alpha = 0.5f),
            )
        },
        trailing = {
            AnimatedVisibility(
                visible = provideName().isNotEmpty(),
                enter = fadeIn() + scaleIn(),
                exit = scaleOut() + fadeOut(),
            ) {
                ButtonIconSecondary(
                    imageVector = Icons.close,
                    color = it.copy(alpha = 0.5f),
                    onClick = { update.invoke("") }
                )
            }
        }
    )
}