package ui.designsystem.controls

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.ProvideTextStyle
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import ui.designsystem.common.DesignComponent

@Composable
fun InputFieldPrimary(
    modifier: Modifier = Modifier,
    value: String?,
    onValueChange: (String) -> Unit,
    placeholder: String? = null,
    color: Color? = null,
    textAlign: TextAlign? = null,
    maxLines: Int = Int.MAX_VALUE,
) = InputField(
    modifier = modifier.border(
        BorderStroke(2.dp, Brush.horizontalGradient(listOf(Color(0xffa18cd1), Color(0xfffbc2eb)))),
        RoundedCornerShape(8.dp)
    ).padding(16.dp),
    value = value,
    onValueChange = onValueChange,
    textStyle = DesignComponent.typography.Body1,
    maxLines = maxLines,
    color = color ?: DesignComponent.colors.primaryInverse,
    textAlign = textAlign,
    placeholder = placeholder
)

@Composable
fun InputFieldSecondary(
    modifier: Modifier = Modifier,
    value: String?,
    onValueChange: (String) -> Unit,
    placeholder: String? = null,
    color: Color? = null,
    textAlign: TextAlign? = null,
    maxLines: Int = Int.MAX_VALUE,
) = InputField(
    modifier = modifier.padding(8.dp),
    value = value,
    onValueChange = onValueChange,
    textStyle = DesignComponent.typography.Body2,
    maxLines = maxLines,
    color = color ?: DesignComponent.colors.primaryInverse,
    textAlign = textAlign,
    placeholder = placeholder
)

@Composable
internal fun InputField(
    modifier: Modifier = Modifier,
    value: String?,
    onValueChange: (String) -> Unit,
    color: Color? = null,
    placeholder: String? = null,
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

    BasicTextField(
        modifier = modifier.background(Color.Transparent).wrapContentSize(),
        value = value ?: String(),
        onValueChange = onValueChange,
        textStyle = innerTextAlignTextStyle,
        maxLines = maxLines,
        singleLine = maxLines == 1,
        decorationBox = { innerTextField ->
            Row(modifier = Modifier.fillMaxWidth()) {
                if (placeholder?.isNotEmpty() == true && value.isNullOrEmpty()) {
                    Inner(style = innerTextAlignTextStyle, text = placeholder)
                }
            }
            innerTextField()
        },
    )
}

@Composable
private fun Inner(style: TextStyle, text: String) = ProvideTextStyle(value = style) {
    Text(modifier = Modifier.fillMaxSize().alpha(0.6f), text = text, maxLines = 1)
}