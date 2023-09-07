package controls

import Design
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
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
fun ButtonPrimaryBrand(
    modifier: Modifier = Modifier,
    text: String,
    enabled: Boolean = true,
    onClick: () -> Unit,
) {
    val innerTextColor = Design.colors.primary
    val innerBackgroundColor = Design.colors.accent_secondary

    Button(
        modifier = modifier.requiredHeight(Design.dp.component),
        text = text,
        textStyle = Design.typography.PrimaryButton.copy(color = innerTextColor, fontWeight = FontWeight.Bold),
        enabled = enabled,
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(backgroundColor = innerBackgroundColor),
        shape = Design.shape.circleShape,
        borderStroke = null,
        leadIcon = null
    )
}

@Composable
fun ButtonPrimaryWhite(
    modifier: Modifier = Modifier,
    text: String,
    enabled: Boolean = true,
    onClick: () -> Unit,
) {
    val innerTextColor = Design.colors.accent_primary
    val innerBackgroundColor = Design.colors.content

    Button(
        modifier = modifier.requiredHeight(Design.dp.component),
        text = text,
        textStyle = Design.typography.PrimaryButton.copy(color = innerTextColor, fontWeight = FontWeight.Bold),
        enabled = enabled,
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(backgroundColor = innerBackgroundColor),
        shape = Design.shape.circleShape,
        borderStroke = null,
        leadIcon = null
    )
}

@Composable
fun ButtonSecondaryBrand(
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
        modifier = modifier.requiredHeight(Design.dp.component),
        text = text,
        contentPadding = PaddingValues(vertical = 0.dp),
        textStyle = Design.typography.SecondaryButton.copy(color = innerTextColor, fontWeight = FontWeight.Bold),
        enabled = enabled,
        onClick = onClick,
        borderStroke = BorderStroke(width = 2.dp, color = innerTextColor),
        colors = ButtonDefaults.buttonColors(backgroundColor = innerBackgroundColor),
        shape = Design.shape.circleShape,
        leadIcon = leadIcon
    )
}

@Composable
fun ButtonSecondaryWhite(
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
        modifier = modifier.requiredHeight(Design.dp.component),
        text = text,
        contentPadding = PaddingValues(vertical = 0.dp),
        textStyle = Design.typography.SecondaryButton.copy(color = innerTextColor, fontWeight = FontWeight.Bold),
        enabled = enabled,
        onClick = onClick,
        borderStroke = BorderStroke(width = 2.dp, color = innerTextColor),
        colors = ButtonDefaults.buttonColors(backgroundColor = innerBackgroundColor),
        shape = Design.shape.circleShape,
        leadIcon = leadIcon
    )
}
@Composable
fun ButtonTertiary(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    enabled: Boolean = true,
    color: Color? = null,
    leadIcon: ImageVector? = null,
) {

    val innerTextColor = color ?: Design.colors.accent_secondary
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