package designsystem.controls

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.ProvideTextStyle
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.VisualTransformation
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
    leading: @Composable (() -> Unit)? = null,
    trailing: @Composable (() -> Unit)? = null,
    maxLines: Int = Int.MAX_VALUE,
    enabled: Boolean = true,
    keyboardOptions: KeyboardOptions? = null,
    maxLength: Int? = null,
    fontWeight: FontWeight? = null,
    digits: Array<Char> = emptyArray(),
    keyboardActions: KeyboardActions? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
) = InputField(
    modifier = modifier,
    value = value,
    onValueChange = onValueChange,
    textStyle = DesignComponent.typography.Body,
    maxLines = maxLines,
    color = color ?: DesignComponent.colors.content,
    textAlign = textAlign,
    placeholder = placeholder,
    enabled = enabled,
    keyboardOptions = keyboardOptions,
    leading = leading,
    trailing = trailing,
    maxLength = maxLength,
    digits = digits,
    keyboardActions = keyboardActions,
    fontWeight = fontWeight,
    visualTransformation = visualTransformation
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
    leading: @Composable (() -> Unit)? = null,
    trailing: @Composable (() -> Unit)? = null,
    keyboardOptions: KeyboardOptions? = null,
    maxLength: Int? = null,
    fontWeight: FontWeight? = null,
    digits: Array<Char> = emptyArray(),
    keyboardActions: KeyboardActions? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
) = InputField(
    modifier = modifier.padding(8.dp),
    value = value,
    onValueChange = onValueChange,
    textStyle = DesignComponent.typography.Body2,
    maxLines = maxLines,
    color = color ?: DesignComponent.colors.content,
    textAlign = textAlign,
    placeholder = placeholder,
    enabled = enabled,
    keyboardOptions = keyboardOptions,
    maxLength = maxLength,
    digits = digits,
    keyboardActions = keyboardActions,
    leading = leading,
    trailing = trailing,
    fontWeight = fontWeight,
    visualTransformation = visualTransformation
)

@Composable
internal fun InputField(
    modifier: Modifier = Modifier,
    value: String?,
    onValueChange: (String) -> Unit,
    color: Color? = null,
    placeholder: String? = null,
    textAlign: TextAlign? = null,
    leading: @Composable (() -> Unit)? = null,
    trailing: @Composable (() -> Unit)? = null,
    enabled: Boolean = true,
    textStyle: TextStyle,
    maxLines: Int = Int.MAX_VALUE,
    digits: Array<Char> = emptyArray(),
    fontWeight: FontWeight? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    maxLength: Int? = null,
    keyboardOptions: KeyboardOptions? = null,
    keyboardActions: KeyboardActions? = null
) {

    val textStyle1 = if (color != null) {
        textStyle.copy(color = color)
    } else textStyle

    val textStyle2 = if (textAlign != null) {
        textStyle1.copy(textAlign = textAlign)
    } else textStyle1

    val textStyle3 = if (fontWeight != null) {
        textStyle2.copy(fontWeight = fontWeight)
    } else textStyle2

    BasicTextField(
        modifier = modifier.background(Color.Transparent).animateContentSize(),
        value = value ?: String(),
        onValueChange = {
            val v = if (maxLength != null) it.take(maxLength) else it
            val digitsFilter = if (digits.isNotEmpty()) v.filter { digits.contains(it) } else v
            onValueChange.invoke(digitsFilter)
        },
        enabled = enabled,
        textStyle = textStyle3,
        maxLines = maxLines,
        visualTransformation = visualTransformation,
        cursorBrush = SolidColor(DesignComponent.colors.content),
        singleLine = maxLines == 1,
        keyboardOptions = keyboardOptions ?: KeyboardOptions.Default,
        keyboardActions = keyboardActions ?: KeyboardActions.Default,
        decorationBox = { innerTextField ->
            Row(
                modifier = Modifier.fillMaxWidth().height(IntrinsicSize.Min),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {

                leading?.let {
                    it.invoke()
                    DividerPrimary(orientation = Orientation.Vertical)
                }

                Box(modifier = Modifier.weight(1f)) {
                    if (placeholder?.isNotEmpty() == true && value.isNullOrEmpty()) {
                        Inner(style = textStyle3, text = placeholder)
                    }
                    innerTextField()
                }

                trailing?.invoke()
            }
        })
}

@Composable
private fun Inner(style: TextStyle, text: String) = ProvideTextStyle(value = style) {
    Text(modifier = Modifier.fillMaxWidth().alpha(0.5f), text = text, maxLines = 1)
}