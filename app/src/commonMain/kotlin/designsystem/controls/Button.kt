package designsystem.controls

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import designsystem.GallerySpaceComponent
import designsystem.common.almostWhite

@Composable
fun ButtonPrimary(
    modifier: Modifier = Modifier,
    text: String,
    textColor: Color? = null,
    backgroundColor: Color? = null,
    onClick: () -> Unit,
    enabled: Boolean = true,
    leadIcon: ImageVector? = null,
) {
    val _textColor = textColor ?: GallerySpaceComponent.colors.primary
    val _backgroundColor = backgroundColor ?: GallerySpaceComponent.colors.primaryInverse

    Button(
        modifier = modifier,
        text = text,
        textStyle = GallerySpaceComponent.typography.BUTTON.copy(color = _textColor),
        enabled = enabled,
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(backgroundColor = _backgroundColor),
        shape = RoundedCornerShape(50),
        borderStroke = null,
        leadIcon = leadIcon
    )
}

@Composable
fun ButtonSecondary(
    modifier: Modifier = Modifier,
    text: String,
    color: Color? = null,
    onClick: () -> Unit,
    enabled: Boolean = true,
    leadIcon: ImageVector? = null,
) {

    val textColor = color ?: GallerySpaceComponent.colors.primaryInverse

    Button(
        modifier = modifier,
        text = text,
        textStyle = GallerySpaceComponent.typography.BUTTON.copy(color = textColor),
        enabled = enabled,
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
        shape = RoundedCornerShape(50),
        borderStroke = BorderStroke(2.dp, almostWhite),
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
        content = {
            if (leadIcon != null) {
                Icon(
                    imageVector = leadIcon,
                    modifier = Modifier.size(24.dp),
                    contentDescription = "",
                    tint = almostWhite
                )
            }
            Text(
                modifier = Modifier
                    .padding(horizontal = 8.dp, vertical = 4.dp),
                text = text.uppercase(),
                textStyle = textStyle
            )
        },
        enabled = enabled,
        shape = shape ?: MaterialTheme.shapes.small,
        border = borderStroke,
        colors = colors
    )
}