package components.inputs

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import atom.Design
import components.labels.InputLabel
import molecule.ButtonIconSecondary
import molecule.InputPrimary
import molecule.secondaryDefaultBackground

@Composable
public fun InputExerciseName(
    modifier: Modifier = Modifier,
    provideName: () -> String,
    update: (String) -> Unit
) {
    val focusManager = LocalFocusManager.current

    InputPrimary(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = Design.dp.paddingM)
            .secondaryDefaultBackground()
            .padding(horizontal = Design.dp.paddingM),
        provideValue = provideName,
        placeholder = "Exercise name",
        maxLines = 1,
        color = Design.colors.content,
        keyboardActions = KeyboardActions { focusManager.moveFocus(FocusDirection.Next) },
        onValueChange = update,
        keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Sentences, imeAction = ImeAction.Next),
        fontWeight = FontWeight.Bold,
        trailing = {
            AnimatedVisibility(
                visible = provideName().isNotEmpty(),
                enter = fadeIn() + scaleIn(),
                exit = scaleOut() + fadeOut(),
            ) {
                ButtonIconSecondary(
                    modifier = Modifier
                        .wrapContentSize()
                        .height(IntrinsicSize.Min),
                    imageVector = Icons.Default.Clear,
                    color = Design.colors.caption,
                    onClick = { update.invoke("") }
                )
            }
        }
    )
}