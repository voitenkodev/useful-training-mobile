package atom

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

internal fun shape() = Shape(
    small = RoundedCornerShape(6.dp),
    default = RoundedCornerShape(16.dp),
    circleShape = CircleShape
)

public data class Shape(
    val small: Shape,
    val default: Shape,
    val circleShape: Shape
)