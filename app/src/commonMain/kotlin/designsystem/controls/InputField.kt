package designsystem.controls

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.ProvideTextStyle
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import designsystem.common.DesignComponent

@Composable
fun InputFieldPrimary(
    modifier: Modifier = Modifier,
    value: String?,
    onValueChange: (String) -> Unit,
    placeholder: String? = null,
    color: Color? = null,
    textAlign: TextAlign? = null,
    leadIcon: @Composable (() -> Unit)? = null,
    maxLines: Int = Int.MAX_VALUE,
    enabled: Boolean = true,
    keyboardOptions: KeyboardOptions? = null,
    maxLength: Int? = null,
    digits: Array<Char> = emptyArray(),
    keyboardActions: KeyboardActions? = null
) = InputField(
    modifier = modifier,
    value = value,
    onValueChange = onValueChange,
    textStyle = DesignComponent.typography.Body,
    maxLines = maxLines,
    color = color ?: DesignComponent.colors.primaryInverse100,
    textAlign = textAlign,
    placeholder = placeholder,
    enabled = enabled,
    keyboardOptions = keyboardOptions,
    leadIcon = leadIcon,
    maxLength = maxLength,
    digits = digits,
    keyboardActions = keyboardActions
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
    enabled: Boolean = true,
    leadIcon: @Composable (() -> Unit)? = null,
    keyboardOptions: KeyboardOptions? = null,
    maxLength: Int? = null,
    digits: Array<Char> = emptyArray(),
    keyboardActions: KeyboardActions? = null
) = InputField(
    modifier = modifier.padding(8.dp),
    value = value,
    onValueChange = onValueChange,
    textStyle = DesignComponent.typography.Body2,
    maxLines = maxLines,
    color = color ?: DesignComponent.colors.primaryInverse100,
    textAlign = textAlign,
    placeholder = placeholder,
    enabled = enabled,
    keyboardOptions = keyboardOptions,
    maxLength = maxLength,
    digits = digits,
    keyboardActions = keyboardActions,
    leadIcon = leadIcon
)

@Composable
internal fun InputField(
    modifier: Modifier = Modifier,
    value: String?,
    onValueChange: (String) -> Unit,
    color: Color? = null,
    placeholder: String? = null,
    textAlign: TextAlign? = null,
    leadIcon: @Composable (() -> Unit)? = null,
    enabled: Boolean = true,
    textStyle: TextStyle,
    maxLines: Int = Int.MAX_VALUE,
    digits: Array<Char> = emptyArray(),
    maxLength: Int? = null,
    keyboardOptions: KeyboardOptions? = null,
    keyboardActions: KeyboardActions? = null
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
        onValueChange = {
            val v = if (maxLength != null) it.take(maxLength) else it
            val digitsFilter = if (digits.isNotEmpty()) v.filter { digits.contains(it) } else v
            onValueChange.invoke(digitsFilter)
        },
        enabled = enabled,
        textStyle = innerTextAlignTextStyle,
        maxLines = maxLines,
        singleLine = maxLines == 1,
        keyboardOptions = keyboardOptions ?: KeyboardOptions.Default,
        keyboardActions = keyboardActions ?: KeyboardActions.Default,
        decorationBox = { innerTextField ->
            Row(modifier = Modifier.fillMaxWidth()) {
                if (leadIcon != null) {
                    leadIcon.invoke()
                    Spacer(modifier = Modifier.size(6.dp))
                }
                Box {
                    if (placeholder?.isNotEmpty() == true && value.isNullOrEmpty()) {
                        Inner(style = innerTextAlignTextStyle, text = placeholder)
                    }
                    innerTextField()
                }
            }
        }
    )
}

@Composable
private fun Inner(style: TextStyle, text: String) = ProvideTextStyle(value = style) {
    Text(modifier = Modifier.fillMaxWidth().alpha(0.5f), text = text, maxLines = 1)
}