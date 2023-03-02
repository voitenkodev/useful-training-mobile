package design.atomic

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

fun appShape() = AppShape(
    default = RoundedCornerShape(10.dp),
    circleShape = CircleShape,
)

data class AppShape(
    val default: Shape,
    val circleShape: Shape,
)