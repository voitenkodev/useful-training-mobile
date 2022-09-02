package ui.designsystem.controls

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.ProvideTextStyle
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import ui.designsystem.DesignComponent

@Composable
fun InputFieldPrimary(
    modifier: Modifier = Modifier,
    value: String?,
    onValueChange: (String) -> Unit,
    label: String? = null,
    placeholder: String? = null,
    color: Color? = null,
    textAlign: TextAlign? = null,
    maxLines: Int = Int.MAX_VALUE,
    leadingIcon: ImageVector? = null,
) = InputField(
    modifier = modifier.border(BorderStroke(2.dp, Brush.horizontalGradient(listOf(Color(0xffa18cd1), Color(0xfffbc2eb)))), CircleShape),
    value = value,
    onValueChange = onValueChange,
    textStyle = DesignComponent.typography.BODY1,
    maxLines = maxLines,
    label = label,
    color = color ?: DesignComponent.colors.primaryInverse,
    textAlign = textAlign,
    leadingIcon = leadingIcon,
    placeholder = placeholder
)

@Composable
internal fun InputField(
    modifier: Modifier = Modifier,
    value: String?,
    onValueChange: (String) -> Unit,
    color: Color? = null,
    label: String? = null,
    placeholder: String? = null,
    textAlign: TextAlign? = null,
    textStyle: TextStyle,
    maxLines: Int = Int.MAX_VALUE,
    leadingIcon: ImageVector? = null,
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
        modifier = modifier.background(Color.Transparent).wrapContentSize(),
        value = value ?: String(),
        onValueChange = onValueChange,
        label = label?.let { { Inner(style = textStyle, text = label) } },
        placeholder = placeholder?.let { { Inner(style = textStyle, text = placeholder) } },
        textStyle = innerTextAlignTextStyle,
        maxLines = maxLines,
        leadingIcon = {
            leadingIcon?.let {
                Icon(imageVector = leadingIcon, contentDescription = null)
            }
        },
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