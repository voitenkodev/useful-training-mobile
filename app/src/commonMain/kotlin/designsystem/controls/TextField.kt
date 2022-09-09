package designsystem.controls

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import designsystem.common.DesignComponent

@Composable
fun TextFieldH1(
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
fun TextFieldBody2(
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
    textStyle = DesignComponent.typography.Body2,
    maxLines = maxLines,
    color = color ?: DesignComponent.colors.primaryInverse,
    textAlign = textAlign,
)

@Composable
fun TextFieldBody2Bold(
    modifier: Modifier = Modifier,
    text: String?,
    placeholder: String? = null,
    color: Color? = null,
    textAlign: TextAlign? = null,
    maxLines: Int = Int.MAX_VALUE,
) = TextField(
    modifier = modifier.padding(8.dp),
    text = text,
    placeholder = placeholder,
    textStyle = DesignComponent.typography.Body2Bold,
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

    val _color = if (isPlaceholder) color?.copy(alpha = 0.8f) else color

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
        maxLines = maxLines,
    )
}