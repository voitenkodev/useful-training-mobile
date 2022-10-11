package controls

import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import DesignComponent

@Composable
fun IconPrimary(
    modifier: Modifier = Modifier,
    imageVector: ImageVector,
    color: Color = DesignComponent.colors.content,
    onClick: () -> Unit
) = IconButton(
    modifier = modifier.size(18.dp),
    onClick = onClick
) {
    Icon(
        imageVector = imageVector,
        tint = color,
        modifier = Modifier.clip(shape = DesignComponent.shape.default),
        contentDescription = null,
    )
}