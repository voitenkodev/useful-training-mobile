package controls

import DesignComponent
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow

@Composable
fun TextFieldH1(
    text: String?,
    modifier: Modifier = Modifier,
    placeholder: String? = null,
    color: Color? = null,
    textAlign: TextAlign? = null,
    maxLines: Int = Int.MAX_VALUE,
    fontWeight: FontWeight? = null,
    overflow: TextOverflow = TextOverflow.Clip
) = TextField(
    text = text,
    modifier = modifier,
    placeholder = placeholder,
    textStyle = DesignComponent.typography.H1,
    maxLines = maxLines,
    color = color ?: DesignComponent.colors.content,
    textAlign = textAlign,
    fontWeight = fontWeight,
    overflow = overflow
)

@Composable
fun TextFieldH2(
    text: String?,
    modifier: Modifier = Modifier,
    placeholder: String? = null,
    color: Color? = null,
    textAlign: TextAlign? = null,
    maxLines: Int = Int.MAX_VALUE,
    fontWeight: FontWeight? = null,
    overflow: TextOverflow = TextOverflow.Clip
) = TextField(
    text = text,
    modifier = modifier,
    placeholder = placeholder,
    textStyle = DesignComponent.typography.H2,
    maxLines = maxLines,
    color = color ?: DesignComponent.colors.content,
    textAlign = textAlign,
    fontWeight = fontWeight,
    overflow = overflow

)

@Composable
fun TextFieldBody1(
    text: String?,
    modifier: Modifier = Modifier,
    placeholder: String? = null,
    color: Color? = null,
    textAlign: TextAlign? = null,
    maxLines: Int = Int.MAX_VALUE,
    fontWeight: FontWeight? = null,
    overflow: TextOverflow = TextOverflow.Clip
) = TextField(
    modifier = modifier,
    text = text,
    placeholder = placeholder,
    textStyle = DesignComponent.typography.Body,
    maxLines = maxLines,
    color = color ?: DesignComponent.colors.content,
    textAlign = textAlign,
    fontWeight = fontWeight,
    overflow = overflow
)

@Composable
fun TextFieldBody2(
    text: String?,
    modifier: Modifier = Modifier,
    placeholder: String? = null,
    color: Color? = null,
    textAlign: TextAlign? = null,
    maxLines: Int = Int.MAX_VALUE,
    fontWeight: FontWeight? = null,
    overflow: TextOverflow = TextOverflow.Clip
) = TextField(
    modifier = modifier,
    text = text,
    placeholder = placeholder,
    textStyle = DesignComponent.typography.Body2,
    maxLines = maxLines,
    color = color ?: DesignComponent.colors.content,
    textAlign = textAlign,
    fontWeight = fontWeight,
    overflow = overflow
)

@Composable
fun TextField(
    text: String?,
    modifier: Modifier = Modifier,
    placeholder: String? = null,
    color: Color? = null,
    textAlign: TextAlign? = null,
    textStyle: TextStyle,
    maxLines: Int = Int.MAX_VALUE,
    fontWeight: FontWeight? = null,
    overflow: TextOverflow = TextOverflow.Clip
) {
    val isPlaceholder = text == null

    val innerColor = if (isPlaceholder) color?.copy(alpha = 0.8f) else color

    val textStyle1 = if (innerColor != null) {
        textStyle.copy(color = innerColor)
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
        overflow = overflow
    )
}