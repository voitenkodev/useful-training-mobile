package percentagepicker

import androidx.compose.ui.graphics.Color

public data class ThumbRangeState(
    val id: String?,
    val positionInRange: Int,
    val color: Color
)

internal data class ThumbInternalState(
    val id: String?,
    val positionInLine: Int,
    val positionBetween: Int,
    val color: Color,
    val offsetX: Float,
    val isSelected: Boolean = false
)