package designsystem.controls

import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import designsystem.common.DesignComponent

@Composable
fun TextFieldH1(
    modifier: Modifier = Modifier,
    text: String?,
    placeholder: String? = null,
    color: Color? = null,
    textAlign: TextAlign? = null,
    maxLines: Int = Int.MAX_VALUE,
    fontWeight: FontWeight? = null
) = TextField(
    modifier = modifier,
    text = text,
    placeholder = placeholder,
    textStyle = DesignComponent.typography.H1,
    maxLines = maxLines,
    color = color ?: DesignComponent.colors.primaryInverse,
    textAlign = textAlign,
    fontWeight = fontWeight
)

@Composable
fun TextFieldBody2(
    modifier: Modifier = Modifier,
    text: String?,
    placeholder: String? = null,
    color: Color? = null,
    textAlign: TextAlign? = null,
    maxLines: Int = Int.MAX_VALUE,
    fontWeight: FontWeight? = null
) = TextField(
    modifier = modifier,
    text = text,
    placeholder = placeholder,
    textStyle = DesignComponent.typography.Body2,
    maxLines = maxLines,
    color = color ?: DesignComponent.colors.primaryInverse,
    textAlign = textAlign,
    fontWeight = fontWeight
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
    fontWeight: FontWeight? = null
) {
    val isPlaceholder = text == null

    val _color = if (isPlaceholder) color?.copy(alpha = 0.8f) else color

    val textStyle1 = if (_color != null) {
        textStyle.copy(color = _color)
    } else textStyle

    val textStyle2 = if (textAlign != null) {
        textStyle1.copy(textAlign = textAlign)
    } else textStyle1

    val textStyle3 = if (fontWeight != null) {
        textStyle2.copy(fontWeight = fontWeight)
    } else textStyle2

    BasicText(
        modifier = modifier,
        text = text ?: placeholder ?: "",
        style = textStyle3,
        maxLines = maxLines,
    )
}