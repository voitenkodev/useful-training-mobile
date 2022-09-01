package ui.designsystem.controls

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import ui.designsystem.DesignComponent

@Composable
fun Divider(
    modifier: Modifier = Modifier,
    thickness: Dp = 1.dp,
    color: Color = DesignComponent.colors.shadow
) = androidx.compose.material.Divider(modifier = modifier, color = color, thickness = thickness)