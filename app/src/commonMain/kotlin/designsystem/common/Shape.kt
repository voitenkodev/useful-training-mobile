package designsystem.common

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

@Composable
fun AppShape() = AppShape(
    default = androidx.compose.foundation.shape.RoundedCornerShape(10.dp),
    circleShape = CircleShape,
)

data class AppShape(
    val default: Shape,
    val circleShape: Shape,
)