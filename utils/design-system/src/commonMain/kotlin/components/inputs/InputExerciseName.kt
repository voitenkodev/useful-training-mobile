package components.inputs

import Design
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.unit.dp
import components.labels.AccentLabel
import controls.IconPrimary
import controls.InputFieldPrimary
import utils.recomposeHighlighter

@Composable
fun InputExerciseName(
    modifier: Modifier = Modifier,
    provideNumber: () -> Int,
    provideName: () -> String,
    update: (String) -> Unit,
    remove: () -> Unit,
) {
    val focusManager = LocalFocusManager.current

    InputFieldPrimary(
        modifier = modifier
            .fillMaxHeight()
            .recomposeHighlighter(),
        provideValue = provideName,
        placeholder = "Name of exercise",
        maxLines = 1,
        keyboardActions = KeyboardActions { focusManager.moveFocus(FocusDirection.Next) },
        onValueChange = update,
        keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Sentences, imeAction = ImeAction.Next),
        fontWeight = FontWeight.Bold,
        leading = {
            AccentLabel(
                modifier = Modifier
                    .padding(bottom = 8.dp, top = 8.dp, end = 6.dp, start = 6.dp)
                    .recomposeHighlighter(),
                provideText = { "${provideNumber()}" },
            )
        },
        trailing = {
            IconPrimary(
                modifier = Modifier
                    .height(20.dp)
                    .width(50.dp)
                    .recomposeHighlighter(),
                imageVector = Icons.Filled.Delete,
                color = Design.colors.caption,
                onClick = remove,
            )
        }
    )
}