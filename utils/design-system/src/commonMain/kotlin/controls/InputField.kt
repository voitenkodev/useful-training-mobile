package controls

import Design
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.ProvideTextStyle
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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

@Composable
fun InputFieldPrimary(
    modifier: Modifier = Modifier,
    provideValue: () -> String,
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
) {

    InputField(
        modifier = modifier,
        provideValue = provideValue,
        onValueChange = onValueChange,
        textStyle = Design.typography.Input,
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
}

@Composable
fun InputFieldSecondary(
    modifier: Modifier = Modifier,
    provideValue: () -> String,
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
    provideValue = provideValue,
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
private fun InputField(
    modifier: Modifier = Modifier,
    provideValue: () -> String,
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

    Row(
        modifier = modifier.requiredHeight(Design.dp.component),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp),
    ) {

        if (leading != null) {
            leading.invoke()
            DividerPrimary(
                modifier = Modifier.requiredHeight(Design.dp.component - Design.dp.padding - Design.dp.padding),
                orientation = Orientation.Vertical
            )
        }

        InnerInputField(
            Modifier
                .requiredHeight(Design.dp.component)
                .background(Color.Transparent)
                .weight(1f),
            provideValue = provideValue,
            onValueChange = onValueChange,
            textStyle = textStyle3,
            keyboardActions = keyboardActions,
            keyboardOptions = keyboardOptions,
            maxLength = maxLength,
            visualTransformation = visualTransformation,
            digits = digits,
            maxLines = maxLines,
            enabled = enabled,
            placeholder = placeholder
        )

        trailing?.invoke()
    }
}

@Composable
private fun InnerInputField(
    modifier: Modifier,
    provideValue: () -> String,
    onValueChange: (String) -> Unit,
    placeholder: String?,
    enabled: Boolean,
    textStyle: TextStyle,
    maxLines: Int,
    digits: Array<Char>,
    visualTransformation: VisualTransformation,
    maxLength: Int?,
    keyboardOptions: KeyboardOptions?,
    keyboardActions: KeyboardActions?
) {

    val updater by remember {
        mutableStateOf(
            { s: String ->
                val v = if (maxLength != null) s.take(maxLength) else s
                val digitsFilter = if (digits.isNotEmpty()) v.filter { char -> digits.contains(char) } else v
                onValueChange.invoke(digitsFilter)
            }
        )
    }

    BasicTextField(
        modifier = modifier,
        value = provideValue(),
        onValueChange = updater,
        enabled = enabled,
        textStyle = textStyle,
        maxLines = maxLines,
        visualTransformation = visualTransformation,
        cursorBrush = SolidColor(textStyle.color),
        singleLine = maxLines == 1,
        keyboardOptions = keyboardOptions ?: KeyboardOptions.Default,
        keyboardActions = keyboardActions ?: KeyboardActions.Default,
        decorationBox = { innerTextField ->
            InputFieldBox(
                innerTextField = innerTextField,
                placeholder = placeholder,
                provideValue = provideValue,
                textStyle = textStyle
            )
        }
    )
}

@Composable
private fun InputFieldBox(
    innerTextField: @Composable () -> Unit,
    placeholder: String?,
    provideValue: () -> String,
    textStyle: TextStyle
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.CenterStart
    ) {
        innerTextField()
        if (placeholder?.isNotEmpty() == true && provideValue().isEmpty()) {
            Inner(style = textStyle, text = placeholder)
        }
    }
}

@Composable
private fun Inner(style: TextStyle, text: String) = ProvideTextStyle(value = style) {
    Text(
        modifier = Modifier.fillMaxWidth().alpha(0.5f),
        text = text,
        maxLines = 1
    )
}