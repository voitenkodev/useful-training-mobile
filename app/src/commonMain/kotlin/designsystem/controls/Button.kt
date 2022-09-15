package designsystem.controls

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import designsystem.common.DesignComponent

@Composable
fun ButtonPrimary(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    enabled: Boolean = true,
    leadIcon: ImageVector? = null,
) {

    val _textColor = DesignComponent.colors.tertiaryInverse
    val _backgroundColor = DesignComponent.colors.tertiary100

    Button(
        modifier = modifier,
        text = text,
        textStyle = DesignComponent.typography.PrimaryButton.copy(color = _textColor),
        enabled = enabled,
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(backgroundColor = _backgroundColor),
        shape = DesignComponent.shape.maxShape,
        borderStroke = null,
        leadIcon = leadIcon
    )
}

@Composable
fun ButtonSecondary(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    enabled: Boolean = true,
    leadIcon: ImageVector? = null,
) {

    val _textColor = DesignComponent.colors.secondary100
    val _backgroundColor = Color.Companion.Transparent

    Button(
        modifier = modifier,
        text = text,
        textStyle = DesignComponent.typography.SecondaryButton.copy(color = _textColor),
        enabled = enabled,
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(backgroundColor = _backgroundColor),
        shape = DesignComponent.shape.maxShape,
        borderStroke = null,
        leadIcon = leadIcon
    )
}

@Composable
private fun Button(
    modifier: Modifier = Modifier,
    text: String,
    textStyle: TextStyle,
    onClick: () -> Unit,
    enabled: Boolean = true,
    colors: ButtonColors,
    shape: Shape? = null,
    borderStroke: BorderStroke? = null,
    leadIcon: ImageVector? = null,
) {
    TextButton(
        modifier = Modifier
            .wrapContentSize()
            .then(modifier),
        onClick = onClick,
        enabled = enabled,
        shape = shape ?: MaterialTheme.shapes.small,
        border = borderStroke,
        colors = colors,
        content = {
            if (leadIcon != null) {
                Icon(
                    imageVector = leadIcon,
                    modifier = Modifier.size(24.dp),
                    contentDescription = null,
                    tint = DesignComponent.colors.primary100
                )
            }
            TextField(
                modifier = Modifier.padding(horizontal = 0.dp, vertical = 8.dp),
                text = text,
                textStyle = textStyle
            )
        }
    )
}