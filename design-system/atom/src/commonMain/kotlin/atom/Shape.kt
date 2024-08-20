package atom

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.Shape

internal fun shape() = Shape(
    small = RoundedCornerShape(dp().shapeSmall),
    default = RoundedCornerShape(dp().shapeDefault),
    large = RoundedCornerShape(dp().shapeLarge),
    circleShape = CircleShape
)

public data class Shape(
    val small: Shape,
    val default: Shape,
    val large: Shape,
    val circleShape: Shape
)