package atomic

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

internal fun shape() = Shape(
    default = RoundedCornerShape(10.dp),
    circleShape = CircleShape,
)

data class Shape(
    val default: Shape,
    val circleShape: Shape,
)