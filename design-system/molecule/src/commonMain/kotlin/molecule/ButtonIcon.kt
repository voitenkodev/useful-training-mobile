package molecule

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import atom.Design

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
            .size(Design.dp.componentM)
            .alpha(if (enabled) 1f else 0.5f)
            .border(
                color = Design.colors.white5,
                width = 1.dp,
                shape = Design.shape.circleShape
            ).background(
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
            .padding(Design.dp.paddingXS)
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
        modifier = modifier.size(Design.dp.iconS),
        onClick = onClick
    ) {
        Icon(
            imageVector = imageVector,
            tint = color,
            contentDescription = null,
        )
    }
}