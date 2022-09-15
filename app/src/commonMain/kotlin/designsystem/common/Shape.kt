package designsystem.common

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

@Composable
fun AppShape() = AppShape(
    minShape = androidx.compose.foundation.shape.RoundedCornerShape(8.dp),
    maxShape = androidx.compose.foundation.shape.RoundedCornerShape(16.dp),
)

data class AppShape(
    val minShape: Shape,
    val maxShape: Shape
)