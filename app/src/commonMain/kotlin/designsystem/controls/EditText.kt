package designsystem.controls

import designsystem.GallerySpaceComponent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.ProvideTextStyle
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign

@Composable
fun BODY1EditText(
    modifier: Modifier = Modifier,
    text: TextFieldValue?,
    onValueChange: (TextFieldValue) -> Unit,
    label: String? = null,
    color: Color? = null,
    textAlign: TextAlign? = null,
    maxLines: Int = Int.MAX_VALUE,
) = EditText(
    modifier = modifier,
    text = text,
    onValueChange = onValueChange,
    textStyle = GallerySpaceComponent.typography.BODY1,
    maxLines = maxLines,
    label = label,
    color = color ?: GallerySpaceComponent.colors.primaryInverse,
    textAlign = textAlign,
)

@Composable
internal fun EditText(
    modifier: Modifier = Modifier,
    text: TextFieldValue?,
    onValueChange: (TextFieldValue) -> Unit,
    color: Color? = null,
    label: String? = null,
    textAlign: TextAlign? = null,
    textStyle: TextStyle,
    maxLines: Int = Int.MAX_VALUE,
) {

    val innerColorTextStyle = if (color != null) {
        textStyle.copy(color = color)
    } else textStyle

    val innerTextAlignTextStyle = if (textAlign != null) {
        innerColorTextStyle.copy(textAlign = textAlign)
    } else innerColorTextStyle

    val mainColor = innerTextAlignTextStyle.color
    val disabledColor = innerTextAlignTextStyle.color.copy(alpha = 0.5f)
    val placeholderColor = innerTextAlignTextStyle.color.copy(alpha = 0.7f)
    val errorColor = Color.Red

    TextField(
        modifier = modifier.background(Color.Transparent).fillMaxWidth(),
        value = text ?: TextFieldValue(),
        onValueChange = onValueChange,
        label = label?.let { { Inner(style = textStyle, text = label) } },
        textStyle = innerTextAlignTextStyle,
        maxLines = maxLines,
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,

            cursorColor = mainColor,
            textColor = mainColor,
            leadingIconColor = mainColor,
            trailingIconColor = mainColor,

            focusedLabelColor = placeholderColor,
            unfocusedLabelColor = placeholderColor,
            placeholderColor = placeholderColor,

            errorCursorColor = errorColor,
            errorIndicatorColor = errorColor,
            errorLeadingIconColor = errorColor,
            errorTrailingIconColor = errorColor,
            errorLabelColor = errorColor,

            disabledTextColor = disabledColor,
            disabledIndicatorColor = disabledColor,
            disabledLabelColor = disabledColor,
            disabledLeadingIconColor = disabledColor,
            disabledTrailingIconColor = disabledColor,
            disabledPlaceholderColor = disabledColor
        )
    )
}

@Composable
private fun Inner(style: TextStyle, text: String) = ProvideTextStyle(value = style) {
    androidx.compose.material.Text(modifier = Modifier.alpha(0.6f), text = text, maxLines = 1)
}