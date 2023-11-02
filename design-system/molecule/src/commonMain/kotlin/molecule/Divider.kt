package molecule

import atom.Design
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
public fun DividerHorizontal(
    modifier: Modifier = Modifier,
    thickness: Dp = 1.dp,
    color: Color = Design.colors.caption.copy(alpha = 0.3f),
) {
    androidx.compose.material.Divider(
        modifier = modifier.fillMaxWidth(),
        color = color,
        thickness = thickness
    )
}

@Composable
public fun DividerVertical(
    modifier: Modifier = Modifier,
    thickness: Dp = 1.dp,
    color: Color = Design.colors.caption.copy(alpha = 0.3f),
) {
    androidx.compose.material.Divider(
        modifier = modifier
            .fillMaxHeight()
            .width(thickness),
        color = color
    )
}