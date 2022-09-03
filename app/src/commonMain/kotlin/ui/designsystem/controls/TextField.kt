package ui.designsystem.controls

import ui.designsystem.common.DesignComponent
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign

@Composable
fun TextFieldPrimary(
    modifier: Modifier = Modifier,
    text: String?,
    placeholder: String? = null,
    color: Color? = null,
    textAlign: TextAlign? = null,
    maxLines: Int = Int.MAX_VALUE,
) = TextField(
    modifier = modifier,
    text = text,
    placeholder = placeholder,
    textStyle = DesignComponent.typography.H1,
    maxLines = maxLines,
    color = color ?: DesignComponent.colors.primaryInverse,
    textAlign = textAlign,
)

@Composable
internal fun TextField(
    modifier: Modifier = Modifier,
    text: String?,
    placeholder: String? = null,
    color: Color? = null,
    textAlign: TextAlign? = null,
    textStyle: TextStyle,
    maxLines: Int = Int.MAX_VALUE,
) {
    val isPlaceholder = text == null

    val _color = if (isPlaceholder) color?.copy(alpha = 0.7f) else color

    val innerColorTextStyle = if (_color != null) {
        textStyle.copy(color = _color)
    } else textStyle

    val innerTextAlignTextStyle = if (textAlign != null) {
        innerColorTextStyle.copy(textAlign = textAlign)
    } else innerColorTextStyle

    BasicText(
        modifier = modifier,
        text = text ?: placeholder ?: "",
        style = innerTextAlignTextStyle,
        maxLines = maxLines
    )
}