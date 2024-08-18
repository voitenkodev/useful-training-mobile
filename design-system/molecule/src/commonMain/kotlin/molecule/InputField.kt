package molecule

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.LocalTextSelectionColors
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import atom.Design

@Immutable
public sealed class InputStyle {
    public data object Default : InputStyle()
    public data class Clickable(val onClick: () -> Unit) : InputStyle()
}

@Composable
public fun Input(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String? = null,
    textAlign: TextAlign? = null,

    label: @Composable (() -> Unit)? = null,
    leading: (@Composable (color: Color) -> Unit)? = null,
    trailing: (@Composable (color: Color) -> Unit)? = null,

    backgroundColor: Color = Design.colors.secondary,
    contentColor: Color = Design.colors.content,
    shape: Shape = Design.shape.default,

    enabled: Boolean = true,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    maxLength: Int? = null,
    fontWeight: FontWeight? = null,
    digits: Array<Char> = emptyArray(),
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    visualTransformation: VisualTransformation = VisualTransformation.None,

    inputStyle: InputStyle = InputStyle.Default,

    maxLines: Int = Int.MAX_VALUE,
    minLines: Int = 3
) {

    val updater by remember {
        mutableStateOf(
            { s: String ->
                val v = if (maxLength != null) s.take(maxLength) else s
                val digitsFilter =
                    if (digits.isNotEmpty()) v.filter { char -> digits.contains(char) } else v
                onValueChange.invoke(digitsFilter)
            }
        )
    }

    val textStyle = Design.typography.input
        .merge(color = contentColor)
        .merge(textAlign = textAlign ?: TextAlign.Start)
        .merge(fontWeight = fontWeight)

    val activePlaceholderColor = contentColor.copy(alpha = 0.5f)
    val disabledPlaceholderColor = Color(0xFFC2C0C0)

    val hasFocus = remember { mutableStateOf(false) }
    val source = remember { MutableInteractionSource() }
    if (source.collectIsPressedAsState().value && inputStyle is InputStyle.Clickable) {
        inputStyle.onClick.invoke()
    }

    val borderColorProvider = when {
        enabled.not() -> Color.Transparent
        else -> Color.Transparent
    }

    val placeholderColorProvider = when {
        enabled.not() -> disabledPlaceholderColor
        else -> activePlaceholderColor
    }

    val alpha = animateFloatAsState(
        targetValue = when (enabled) {
            true -> 1f
            false -> 0.4f
        },
        animationSpec = tween(durationMillis = 300, easing = LinearEasing)
    )
    Column(modifier = modifier, verticalArrangement = Arrangement.spacedBy(Design.dp.paddingS)) {

        label?.invoke()

        val customTextSelectionColors = TextSelectionColors(
            handleColor = contentColor.copy(alpha = 0.3f),
            backgroundColor = contentColor.copy(alpha = 0.3f)
        )

        CompositionLocalProvider(
            LocalTextSelectionColors provides customTextSelectionColors,
        ) {
            BasicTextField(
                modifier = Modifier
                    .alpha(alpha.value)
                    .background(shape = shape, color = backgroundColor)
                    .border(shape = shape, width = 1.dp, color = borderColorProvider)
                    .heightIn(min = Design.dp.componentM)
                    .padding(horizontal = Design.dp.paddingM)
                    .padding(vertical = Design.dp.paddingS)
                    .onFocusChanged { hasFocus.value = it.hasFocus },

                value = value,
                onValueChange = updater,
                readOnly = inputStyle is InputStyle.Clickable,
                interactionSource = source,
                decorationBox = { innerTextField ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(intrinsicSize = IntrinsicSize.Min),
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        leading?.invoke(contentColor)

                        Box(modifier = Modifier.weight(1f)) {

                            if (value.isEmpty() && placeholder != null) Text(
                                modifier = Modifier.padding(start = 2.dp),
                                text = placeholder,
                                style = textStyle.copy(color = placeholderColorProvider),
                                overflow = TextOverflow.Ellipsis,
                                maxLines = maxLines
                            )

                            innerTextField.invoke()
                        }

                        trailing?.invoke(contentColor)
                    }
                },
                textStyle = textStyle.copy(color = contentColor),
                enabled = enabled,
                visualTransformation = visualTransformation,
                cursorBrush = SolidColor(contentColor),
                keyboardOptions = keyboardOptions,
                keyboardActions = keyboardActions,
                maxLines = maxLines,
                minLines = minLines,
                singleLine = maxLines == 1,
            )
        }
    }
}


@Composable
public fun Input(
    modifier: Modifier = Modifier,
    value: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    placeholder: String? = null,
    textAlign: TextAlign? = null,

    label: @Composable (() -> Unit)? = null,
    leading: (@Composable (color: Color) -> Unit)? = null,
    trailing: (@Composable (color: Color) -> Unit)? = null,

    backgroundColor: Color = Design.colors.secondary,
    contentColor: Color = Design.colors.content,
    shape: Shape = Design.shape.default,

    enabled: Boolean = true,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    maxLength: Int? = null,
    fontWeight: FontWeight? = null,
    digits: Array<Char> = emptyArray(),
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    visualTransformation: VisualTransformation = VisualTransformation.None,

    inputStyle: InputStyle = InputStyle.Default,

    maxLines: Int = Int.MAX_VALUE,
    minLines: Int = 3
) {

    val updater by remember {
        mutableStateOf(
            { tf: TextFieldValue ->
                val s = tf.text
                val v = if (maxLength != null) s.take(maxLength) else s
                val digitsFilter =
                    if (digits.isNotEmpty()) v.filter { char -> digits.contains(char) } else v
                onValueChange.invoke(tf.copy(text = digitsFilter))
            }
        )
    }

    val textStyle = Design.typography.input
        .merge(color = contentColor)
        .merge(textAlign = textAlign ?: TextAlign.Start)
        .merge(fontWeight = fontWeight)

    val activePlaceholderColor = contentColor.copy(alpha = 0.5f)
    val disabledPlaceholderColor = Color(0xFFC2C0C0)

    val hasFocus = remember { mutableStateOf(false) }
    val source = remember { MutableInteractionSource() }
    if (source.collectIsPressedAsState().value && inputStyle is InputStyle.Clickable) {
        inputStyle.onClick.invoke()
    }

    val borderColorProvider = when {
        enabled.not() -> Color.Transparent
        hasFocus.value -> Design.colors.yellow
        else -> Color.Transparent
    }

    val placeholderColorProvider = when {
        enabled.not() -> disabledPlaceholderColor
        else -> activePlaceholderColor
    }

    val alpha = animateFloatAsState(
        targetValue = when (enabled) {
            true -> 1f
            false -> 0.4f
        },
        animationSpec = tween(durationMillis = 300, easing = LinearEasing)
    )
    Column(modifier = modifier, verticalArrangement = Arrangement.spacedBy(Design.dp.paddingS)) {

        label?.invoke()

        val customTextSelectionColors = TextSelectionColors(
            handleColor = contentColor.copy(alpha = 0.3f),
            backgroundColor = contentColor.copy(alpha = 0.3f),
        )

        CompositionLocalProvider(
            LocalTextSelectionColors provides customTextSelectionColors,
        ) {
            BasicTextField(
                modifier = Modifier
                    .alpha(alpha.value)
                    .background(shape = shape, color = backgroundColor)
                    .border(shape = shape, width = 1.dp, color = borderColorProvider)
                    .heightIn(min = Design.dp.componentM)
                    .padding(horizontal = Design.dp.paddingM)
                    .padding(vertical = Design.dp.paddingS)
                    .onFocusChanged { hasFocus.value = it.hasFocus },
                value = value,
                onValueChange = updater,
                readOnly = inputStyle is InputStyle.Clickable,
                interactionSource = source,
                decorationBox = { innerTextField ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(intrinsicSize = IntrinsicSize.Min),
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        leading?.invoke(contentColor)

                        Box(modifier = Modifier.weight(1f)) {

                            if (value.text.isEmpty() && placeholder != null) Text(
                                modifier = Modifier.padding(start = 2.dp),
                                text = placeholder,
                                style = textStyle.copy(color = placeholderColorProvider),
                                overflow = TextOverflow.Ellipsis,
                                maxLines = maxLines
                            )

                            innerTextField.invoke()
                        }

                        trailing?.invoke(contentColor)
                    }
                },
                cursorBrush = SolidColor(contentColor),
                textStyle = textStyle.copy(color = contentColor),
                enabled = enabled,
                visualTransformation = visualTransformation,
                keyboardOptions = keyboardOptions,
                keyboardActions = keyboardActions,
                maxLines = maxLines,
                minLines = minLines,
                singleLine = maxLines == 1,
            )
        }
    }
}