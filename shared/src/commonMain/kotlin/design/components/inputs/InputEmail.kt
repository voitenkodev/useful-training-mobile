package design.components.inputs

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import design.Design
import design.components.labels.InputLabel
import design.controls.IconPrimary
import design.controls.InputFieldPrimary
import design.controls.tertiaryBackground

@Composable
internal fun InputEmail(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
) {

    InputFieldPrimary(
        modifier = modifier
            .tertiaryBackground()
            .padding(horizontal = Design.dp.padding),
        value = value,
        onValueChange = onValueChange,
        trailing = {
            AnimatedVisibility(
                visible = value.isNotEmpty(),
                enter = fadeIn() + scaleIn(),
                exit = scaleOut() + fadeOut(),
            ) {
                IconPrimary(
                    modifier = Modifier.wrapContentSize().height(IntrinsicSize.Min),
                    imageVector = Icons.Default.Clear,
                    color = Design.colors.caption,
                    onClick = { onValueChange.invoke(String()) }
                )
            }
        },
        leading = { InputLabel(text = "Email") },
        maxLines = 1,
        keyboardOptions = KeyboardOptions(
            capitalization = KeyboardCapitalization.Sentences,
            imeAction = ImeAction.Next,
            keyboardType = KeyboardType.Email
        )
    )
}