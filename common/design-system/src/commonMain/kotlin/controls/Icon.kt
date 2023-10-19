package controls

import Design
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
public fun IconPrimary(
    modifier: Modifier = Modifier,
    imageVector: ImageVector,
    color: Color = Design.colors.content,
    onClick: () -> Unit
) {
    IconButton(
        modifier = modifier.size(18.dp),
        onClick = onClick
    ) {
        Icon(
            imageVector = imageVector,
            tint = color,
            modifier = Modifier.clip(shape = Design.shape.default),
            contentDescription = null,
        )
    }
}