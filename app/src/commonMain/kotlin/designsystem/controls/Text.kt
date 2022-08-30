package designsystem.controls

import designsystem.GallerySpaceComponent
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign

@Composable
fun H1Text(
    modifier: Modifier = Modifier,
    text: String?,
    placeholder: String? = null,
    color: Color? = null,
    textAlign: TextAlign? = null,
    maxLines: Int = Int.MAX_VALUE,
) = Text(
    modifier = modifier,
    text = text,
    placeholder = placeholder,
    textStyle = GallerySpaceComponent.typography.H1,
    maxLines = maxLines,
    color = color ?: GallerySpaceComponent.colors.primaryInverse,
    textAlign = textAlign,
)

@Composable
fun H2Text(
    modifier: Modifier = Modifier,
    text: String?,
    placeholder: String? = null,
    color: Color? = null,
    textAlign: TextAlign? = null,
    maxLines: Int = Int.MAX_VALUE,
) = Text(
    modifier = modifier,
    text = text,
    placeholder = placeholder,
    textStyle = GallerySpaceComponent.typography.H2,
    maxLines = maxLines,
    color = color ?: GallerySpaceComponent.colors.primaryInverse,
    textAlign = textAlign,
)

@Composable
fun BODY1Text(
    modifier: Modifier = Modifier,
    text: String?,
    placeholder: String? = null,
    color: Color? = null,
    textAlign: TextAlign? = null,
    maxLines: Int = Int.MAX_VALUE,
) = Text(
    modifier = modifier,
    text = text,
    placeholder = placeholder,
    textStyle = GallerySpaceComponent.typography.BODY1,
    maxLines = maxLines,
    color = color ?: GallerySpaceComponent.colors.primaryInverse,
    textAlign = textAlign,
)

@Composable
fun BODY2Text(
    modifier: Modifier = Modifier,
    text: String?,
    placeholder: String? = null,
    color: Color? = null,
    textAlign: TextAlign? = null,
    maxLines: Int = Int.MAX_VALUE,
) = Text(
    modifier = modifier,
    text = text,
    placeholder = placeholder,
    textStyle = GallerySpaceComponent.typography.BODY2,
    maxLines = maxLines,
    color = color ?: GallerySpaceComponent.colors.primaryInverse.copy(alpha = 0.6f),
    textAlign = textAlign,
)

@Composable
fun CAPTION1Text(
    modifier: Modifier = Modifier,
    text: String?,
    placeholder: String? = null,
    color: Color? = null,
    textAlign: TextAlign? = null,
    maxLines: Int = Int.MAX_VALUE,
) = Text(
    modifier = modifier,
    text = text,
    placeholder = placeholder,
    textStyle = GallerySpaceComponent.typography.CAPTION1,
    maxLines = maxLines,
    color = color ?: GallerySpaceComponent.colors.caption,
    textAlign = textAlign,
)

@Composable
internal fun Text(
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