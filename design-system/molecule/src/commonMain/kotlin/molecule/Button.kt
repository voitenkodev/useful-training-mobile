package molecular.molecule

import atom.Design
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
public fun ButtonPrimary(
    modifier: Modifier = Modifier,
    text: String,
    enabled: Boolean = true,
    textColor: Color = Design.colors.content,
    backgroundColor: Color = Design.colors.accentPrimary,
    onClick: () -> Unit,
) {
    Button(
        modifier = modifier,
        contentPadding = PaddingValues(horizontal = Design.dp.paddingXL + Design.dp.paddingXL, vertical = Design.dp.paddingM),
        text = text,
        textStyle = Design.typography.PrimaryButton.copy(color = textColor),
        enabled = enabled,
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = backgroundColor,
            disabledBackgroundColor = Design.colors.caption.copy(alpha = 0.1f),
        ),
        shape = Design.shape.circleShape,
        borderStroke = null,
        leadIcon = null
    )
}

@Composable
public fun ButtonSmall(
    modifier: Modifier = Modifier,
    text: String,
    enabled: Boolean = true,
    textColor: Color = Design.colors.content,
    backgroundColor: Color = Design.colors.accentPrimary,
    onClick: () -> Unit,
) {
    Button(
        modifier = modifier,
        text = text,
        contentPadding = PaddingValues(horizontal = Design.dp.paddingL, vertical = Design.dp.paddingS),
        textStyle = Design.typography.PrimaryButton.copy(color = textColor),
        enabled = enabled,
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = backgroundColor,
            disabledBackgroundColor = Design.colors.caption,
        ),
        shape = Design.shape.circleShape,
        borderStroke = null,
        leadIcon = null
    )
}

@Composable
public fun ButtonTextLink(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    enabled: Boolean = true,
    color: Color? = null,
    leadIcon: ImageVector? = null,
) {

    val innerTextColor = color ?: Design.colors.content
    val innerBackgroundColor = Color.Companion.Transparent

    Button(
        modifier = modifier,
        text = text,
        contentPadding = PaddingValues(vertical = 0.dp),
        textStyle = Design.typography.TertiaryButton.copy(color = innerTextColor, fontWeight = FontWeight.Bold),
        enabled = enabled,
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(backgroundColor = innerBackgroundColor),
        shape = Design.shape.default,
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
                    tint = Design.colors.content
                )
            }
            TextField(
                modifier = Modifier.padding(horizontal = 0.dp),
                provideText = { text },
                textStyle = textStyle
            )
        }
    )
}