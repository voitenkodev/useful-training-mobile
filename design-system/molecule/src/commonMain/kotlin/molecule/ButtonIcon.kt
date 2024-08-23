package molecule

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
import atom.Design

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
            .padding(Design.dp.paddingXS)
            .requiredSize(Design.dp.iconM)
            .alpha(if (enabled) 1f else 0.5f)
            .clip(Design.shape.circleShape),
        onClick = onClick,
        enabled = enabled,
        content = {
            Icon(
                modifier = Modifier.fillMaxSize(),
                tint = contentColor,
                imageVector = imageVector,
                contentDescription = null
            )
        }
    )
}

@Composable
public fun ButtonIconXS(
    modifier: Modifier = Modifier,
    imageVector: ImageVector,
    color: Color = Design.colors.content,
    onClick: () -> Unit
) {
    IconButton(
        modifier = modifier.size(Design.dp.iconXS),
        onClick = onClick
    ) {
        Icon(
            imageVector = imageVector,
            tint = color,
            contentDescription = null,
        )
    }
}

@Composable
public fun ButtonIconS(
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

@Composable
public fun ButtonIconM(
    modifier: Modifier = Modifier,
    imageVector: ImageVector,
    color: Color = Design.colors.content,
    onClick: () -> Unit
) {
    IconButton(
        modifier = modifier.size(Design.dp.iconM),
        onClick = onClick
    ) {
        Icon(
            imageVector = imageVector,
            tint = color,
            contentDescription = null,
        )
    }
}

@Composable
public fun ButtonIconL(
    modifier: Modifier = Modifier,
    imageVector: ImageVector,
    color: Color = Design.colors.content,
    onClick: () -> Unit
) {
    IconButton(
        modifier = modifier.size(Design.dp.iconL),
        onClick = onClick
    ) {
        Icon(
            imageVector = imageVector,
            tint = color,
            contentDescription = null,
        )
    }
}