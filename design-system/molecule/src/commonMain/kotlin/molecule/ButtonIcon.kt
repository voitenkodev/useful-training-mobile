package molecule

import atom.Design
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
public fun ButtonIconPrimary(
    modifier: Modifier = Modifier,
    imageVector: ImageVector,
    enabled: Boolean = true,
    backgroundColor: Color = Design.colors.orange,
    contentColor: Color = Design.colors.content,
    onClick: () -> Unit,
) {
    IconButton(
        modifier = modifier
            .size(Design.dp.componentL)
            .alpha(if (enabled) 1f else 0.5f)
            .borderDefaultPrimary()
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
public fun ButtonIconTransparent(
    modifier: Modifier = Modifier,
    imageVector: ImageVector,
    enabled: Boolean = true,
    contentColor: Color = Design.colors.content,
    onClick: () -> Unit
) {
    IconButton(
        modifier = modifier
            .requiredSize(Design.dp.componentS)
            .alpha(if (enabled) 1f else 0.5f)
            .clip(Design.shape.circleShape),
        onClick = onClick,
        enabled = enabled,
        content = {
            Icon(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(Design.dp.paddingS),
                tint = contentColor,
                imageVector = imageVector,
                contentDescription = null
            )
        }
    )
}

@Composable
public fun ButtonIconSecondary(
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