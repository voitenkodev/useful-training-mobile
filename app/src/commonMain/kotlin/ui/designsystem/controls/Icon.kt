package ui.designsystem.controls

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import ui.designsystem.common.DesignComponent

@Composable
fun IconPrimary(
    modifier: Modifier = Modifier,
    imageVector: ImageVector,
    color: Color = DesignComponent.colors.primaryInverse,
    onClick: () -> Unit

) = IconButton(
    modifier = modifier,
    onClick = onClick
) {

    Icon(
        imageVector = imageVector,
        tint = color,
        modifier = Modifier
            .size(20.dp)
            .clip(shape = RoundedCornerShape(50)),
        contentDescription = null,
    )
}