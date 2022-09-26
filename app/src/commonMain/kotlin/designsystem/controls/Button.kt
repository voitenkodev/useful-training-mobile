package designsystem.controls

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import designsystem.common.DesignComponent

@Composable
fun ButtonPrimary(
    modifier: Modifier = Modifier,
    text: String,
    enabled: Boolean = true,
    leadIcon: ImageVector? = null,
    onClick: () -> Unit,
) {
    val _textColor = DesignComponent.colors.content
    val _backgroundColor = DesignComponent.colors.accent_primary

    Button(
        modifier = modifier,
        text = text.uppercase(),
        textStyle = DesignComponent.typography.PrimaryButton.copy(color = _textColor, fontWeight = FontWeight.Bold),
        contentPadding = PaddingValues(16.dp),
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

    val _textColor = DesignComponent.colors.accent_secondary
    val _backgroundColor = Color.Companion.Transparent

    Button(
        modifier = modifier,
        text = text,
        contentPadding = PaddingValues(vertical = 0.dp),
        textStyle = DesignComponent.typography.SecondaryButton.copy(color = _textColor, fontWeight = FontWeight.Bold),
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
    contentPadding: PaddingValues = ButtonDefaults.TextButtonContentPadding,
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
        modifier = modifier,
        onClick = onClick,
        enabled = enabled,
        contentPadding = contentPadding,
        shape = shape ?: MaterialTheme.shapes.small,
        border = borderStroke,
        colors = colors,
        content = {
            if (leadIcon != null) {
                Icon(
                    imageVector = leadIcon,
                    modifier = Modifier.size(24.dp),
                    contentDescription = null,
                    tint = DesignComponent.colors.content
                )
            }
            TextField(
                modifier = Modifier.padding(horizontal = 0.dp),
                text = text,
                textStyle = textStyle
            )
        }
    )
}