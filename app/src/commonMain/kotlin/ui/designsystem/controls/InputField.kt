package ui.designsystem.controls

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.ProvideTextStyle
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import ui.designsystem.common.DesignComponent

@Composable
fun InputFieldBody1(
    modifier: Modifier = Modifier,
    value: String?,
    onValueChange: (String) -> Unit,
    placeholder: String? = null,
    color: Color? = null,
    textAlign: TextAlign? = null,
    maxLines: Int = Int.MAX_VALUE,
    enabled: Boolean = true,
    keyboardOptions: KeyboardOptions? = null,
) = InputField(
    modifier = modifier,
    value = value,
    onValueChange = onValueChange,
    textStyle = DesignComponent.typography.Body1,
    maxLines = maxLines,
    color = color ?: DesignComponent.colors.primaryInverse,
    textAlign = textAlign,
    placeholder = placeholder,
    enabled = enabled,
    keyboardOptions = keyboardOptions
)

@Composable
fun InputFieldBody2(
    modifier: Modifier = Modifier,
    value: String?,
    onValueChange: (String) -> Unit,
    placeholder: String? = null,
    color: Color? = null,
    textAlign: TextAlign? = null,
    maxLines: Int = Int.MAX_VALUE,
    enabled: Boolean = true,
    keyboardOptions: KeyboardOptions? = null,
) = InputField(
    modifier = modifier,
    value = value,
    onValueChange = onValueChange,
    textStyle = DesignComponent.typography.Body2,
    maxLines = maxLines,
    color = color ?: DesignComponent.colors.primaryInverse,
    textAlign = textAlign,
    placeholder = placeholder,
    enabled = enabled,
    keyboardOptions = keyboardOptions
)

@Composable
internal fun InputField(
    modifier: Modifier = Modifier,
    value: String?,
    onValueChange: (String) -> Unit,
    color: Color? = null,
    placeholder: String? = null,
    textAlign: TextAlign? = null,
    enabled: Boolean = true,
    textStyle: TextStyle,
    maxLines: Int = Int.MAX_VALUE,
    keyboardOptions: KeyboardOptions? = null,
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
        enabled = enabled,
        textStyle = innerTextAlignTextStyle,
        maxLines = maxLines,
        singleLine = maxLines == 1,
        keyboardOptions = keyboardOptions ?: KeyboardOptions.Default,
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
    Text(modifier = Modifier.fillMaxSize().alpha(0.5f), text = text, maxLines = 1)
}