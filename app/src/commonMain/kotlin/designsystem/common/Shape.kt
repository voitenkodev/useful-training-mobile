package designsystem.common

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

@Composable
fun AppShape() = AppShape(
    maxShape = androidx.compose.foundation.shape.RoundedCornerShape(16.dp),
    circleShape = CircleShape,
)

data class AppShape(
    val maxShape: Shape,
    val circleShape: Shape,
)