package molecule

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import atom.Design


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