package design.controls

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import design.Design

@Composable
internal fun DividerPrimary(
    modifier: Modifier = Modifier,
    thickness: Dp = 1.dp,
    color: Color = Design.colors.caption.copy(alpha = 0.3f),
    orientation: Orientation = Orientation.Horizontal
) {
    if (orientation == Orientation.Horizontal) androidx.compose.material.Divider(
        modifier = modifier.fillMaxWidth(),
        color = color,
        thickness = thickness
    )
    else if (orientation == Orientation.Vertical) androidx.compose.material.Divider(
        modifier = modifier
            .fillMaxHeight()
            .width(thickness),
        color = color,
    )
}