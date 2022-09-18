package designsystem.controls

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import designsystem.common.DesignComponent

@Composable
fun DividerPrimary(
    modifier: Modifier = Modifier.fillMaxSize(),
    thickness: Dp = 1.dp,
    color: Color = DesignComponent.colors.content.copy(alpha = 0.1f)
) = androidx.compose.material.Divider(modifier = modifier, color = color, thickness = thickness)