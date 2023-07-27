package controls

import Design
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import utils.recomposeHighlighter

@Composable
fun TextFieldH1(
    provideText: () -> String?,
    modifier: Modifier = Modifier,
    placeholder: String? = null,
    color: Color? = null,
    textAlign: TextAlign? = null,
    maxLines: Int = Int.MAX_VALUE,
    fontWeight: FontWeight? = null,
    overflow: TextOverflow = TextOverflow.Clip
) {
    TextField(
        provideText = provideText,
        modifier = modifier,
        placeholder = placeholder,
        textStyle = Design.typography.H1,
        maxLines = maxLines,
        color = color ?: Design.colors.content,
        textAlign = textAlign,
        fontWeight = fontWeight,
        overflow = overflow
    )
}

@Composable
fun TextFieldH2(
    provideText: () -> String?,
    modifier: Modifier = Modifier,
    placeholder: String? = null,
    color: Color? = null,
    textAlign: TextAlign? = null,
    maxLines: Int = Int.MAX_VALUE,
    fontWeight: FontWeight? = null,
    overflow: TextOverflow = TextOverflow.Clip
) = TextField(
    provideText = provideText,
    modifier = modifier,
    placeholder = placeholder,
    textStyle = Design.typography.H2,
    maxLines = maxLines,
    color = color ?: Design.colors.content,
    textAlign = textAlign,
    fontWeight = fontWeight,
    overflow = overflow

)

@Composable
fun TextFieldBody1(
    provideText: () -> String?,
    modifier: Modifier = Modifier,
    placeholder: String? = null,
    color: Color? = null,
    textAlign: TextAlign? = null,
    maxLines: Int = Int.MAX_VALUE,
    fontWeight: FontWeight? = null,
    overflow: TextOverflow = TextOverflow.Clip
) = TextField(
    modifier = modifier,
    provideText = provideText,
    placeholder = placeholder,
    textStyle = Design.typography.Body,
    maxLines = maxLines,
    color = color ?: Design.colors.content,
    textAlign = textAlign,
    fontWeight = fontWeight,
    overflow = overflow
)

@Composable
fun TextFieldBody2(
    provideText: () -> String?,
    modifier: Modifier = Modifier,
    placeholder: String? = null,
    color: Color? = null,
    textAlign: TextAlign? = null,
    maxLines: Int = Int.MAX_VALUE,
    fontWeight: FontWeight? = null,
    overflow: TextOverflow = TextOverflow.Clip
) = TextField(
    modifier = modifier,
    provideText = provideText,
    placeholder = placeholder,
    textStyle = Design.typography.Body2,
    maxLines = maxLines,
    color = color ?: Design.colors.content,
    textAlign = textAlign,
    fontWeight = fontWeight,
    overflow = overflow
)

@Composable
internal fun TextField(
    provideText: () -> String?,
    modifier: Modifier = Modifier,
    placeholder: String? = null,
    color: Color? = null,
    textAlign: TextAlign? = null,
    textStyle: TextStyle,
    maxLines: Int = Int.MAX_VALUE,
    fontWeight: FontWeight? = null,
    overflow: TextOverflow = TextOverflow.Clip
) {
    val isPlaceholder = provideText() == null

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
        modifier = modifier.recomposeHighlighter(),
        text = provideText() ?: placeholder ?: "",
        style = textStyle3,
        maxLines = maxLines,
        overflow = overflow
    )
}