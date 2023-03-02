package design.controls

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.wrapContentSize
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
import design.Design

@Composable
internal fun InputFieldPrimary(
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
    textStyle = Design.typography.Body,
    maxLines = maxLines,
    color = color ?: Design.colors.content,
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
internal fun InputFieldSecondary(
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
    modifier = modifier,
    value = value,
    onValueChange = onValueChange,
    textStyle = Design.typography.Body2,
    maxLines = maxLines,
    color = color ?: Design.colors.content,
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
        modifier = modifier.requiredHeight(Design.dp.component).background(Color.Transparent).animateContentSize(),
        value = value ?: String(),
        onValueChange = {
            val v = if (maxLength != null) it.take(maxLength) else it
            val digitsFilter = if (digits.isNotEmpty()) v.filter { char -> digits.contains(char) } else v
            onValueChange.invoke(digitsFilter)
        },
        enabled = enabled,
        textStyle = textStyle3,
        maxLines = maxLines,
        visualTransformation = visualTransformation,
        cursorBrush = SolidColor(Design.colors.content),
        singleLine = maxLines == 1,
        keyboardOptions = keyboardOptions ?: KeyboardOptions.Default,
        keyboardActions = keyboardActions ?: KeyboardActions.Default,
        decorationBox = { innerTextField ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {

                leading?.let {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        modifier = Modifier.wrapContentSize().height(IntrinsicSize.Min)
                    ) {
                        it.invoke()
                        DividerPrimary(orientation = Orientation.Vertical)
                    }
                }

                Box(modifier = Modifier.weight(1f)) {
                    innerTextField()
                    if (placeholder?.isNotEmpty() == true && value.isNullOrEmpty()) {
                        Inner(style = textStyle3, text = placeholder)
                    }
                }

                trailing?.invoke()
            }
        })
}

@Composable
private fun Inner(style: TextStyle, text: String) = ProvideTextStyle(value = style) {
    Text(modifier = Modifier.fillMaxWidth().alpha(0.5f), text = text, maxLines = 1)
}