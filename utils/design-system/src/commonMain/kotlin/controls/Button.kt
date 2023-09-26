package controls

import Design
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun ButtonBrand(
    modifier: Modifier = Modifier,
    text: String,
    enabled: Boolean = true,
    textColor: Color = Design.colors.content,
    backgroundColor: Color = Design.colors.accent_primary,
    onClick: () -> Unit,
) {
    Button(
        modifier = modifier.requiredHeight(Design.dp.component),
        text = text,
        textStyle = Design.typography.PrimaryButton.copy(color = textColor),
        enabled = enabled,
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(backgroundColor = backgroundColor),
        shape = Design.shape.circleShape,
        borderStroke = null,
        leadIcon = null
    )
}

@Composable
fun ButtonIconBrand(
    modifier: Modifier = Modifier,
    imageVector: ImageVector,
    enabled: Boolean = true,
    backgroundColor: Color = Design.colors.accent_primary,
    contentColor: Color = Design.colors.content,
    onClick: () -> Unit,
) {
    IconButton(
        modifier = modifier
            .requiredSize(Design.dp.component)
            .alpha(if (enabled) 1f else 0.5f)
            .background(
                color = backgroundColor,
                shape = Design.shape.circleShape
            ).clip(Design.shape.circleShape),
        onClick = onClick,
        enabled = enabled,
        content = {
            Icon(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(Design.dp.paddingM),
                tint = contentColor,
                imageVector = imageVector,
                contentDescription = null
            )
        }
    )
}

@Composable
fun ButtonSecondaryIcon(
    modifier: Modifier = Modifier,
    imageVector: ImageVector,
    enabled: Boolean = true,
    onClick: () -> Unit,
) {
    IconButton(
        modifier = modifier
            .requiredSize(Design.dp.component)
            .alpha(if (enabled) 1f else 0.5f)
            .background(
                color = Design.colors.tertiary,
                shape = Design.shape.circleShape
            ).clip(Design.shape.circleShape),
        onClick = onClick,
        enabled = enabled,
        content = {
            Icon(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(Design.dp.paddingM),
                tint = Design.colors.content,
                imageVector = imageVector,
                contentDescription = null
            )
        }
    )
}

@Composable
fun ButtonAccentIcon(
    modifier: Modifier = Modifier,
    imageVector: ImageVector,
    enabled: Boolean = true,
    onClick: () -> Unit,
) {
    IconButton(
        modifier = modifier
            .requiredSize(Design.dp.component)
            .alpha(if (enabled) 1f else 0.5f)
            .background(
                color = Design.colors.accent_primary,
                shape = Design.shape.circleShape
            ).clip(Design.shape.circleShape),
        onClick = onClick,
        enabled = enabled,
        content = {
            Icon(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(Design.dp.paddingM),
                tint = Design.colors.content,
                imageVector = imageVector,
                contentDescription = null
            )
        }
    )
}

@Composable
fun ButtonTextLink(
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