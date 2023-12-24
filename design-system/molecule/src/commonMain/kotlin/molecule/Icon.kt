package molecule

import androidx.compose.foundation.Image
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import atom.Design

@Composable
public fun Icon(
    modifier: Modifier = Modifier,
    imageVector: ImageVector,
    color: Color = Design.colors.content,
) {
    Icon(
        imageVector = imageVector,
        tint = color,
        modifier = modifier,
        contentDescription = null
    )
}

@Composable
public fun IconImage(
    modifier: Modifier = Modifier,
    imageVector: ImageVector
) {
    Image(
        imageVector = imageVector,
        modifier = modifier,
        contentDescription = null
    )
}