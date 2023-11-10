package molecule

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import atom.Design

@Composable
public fun IconPrimary(
    modifier: Modifier = Modifier,
    imageVector: ImageVector,
    enabled: Boolean = true,
    contentColor: Color = Design.colors.content
) {
    Icon(
        modifier = modifier.requiredSize(Design.dp.componentL)
            .alpha(if (enabled) 1f else 0.5f)
            .padding(Design.dp.paddingM),
        tint = contentColor,
        imageVector = imageVector,
        contentDescription = null
    )
}

@Composable
public fun IconSecondary(
    modifier: Modifier = Modifier,
    imageVector: ImageVector,
    color: Color = Design.colors.content,
) {
    Icon(
        imageVector = imageVector,
        tint = color,
        modifier = modifier
            .size(18.dp)
            .clip(shape = Design.shape.default),
        contentDescription = null
    )
}