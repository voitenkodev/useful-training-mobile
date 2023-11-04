package percentagepicker

import androidx.compose.ui.geometry.Size
import kotlin.math.abs

internal fun proportionForPosition(range: ClosedRange<Int>, canvasSize: Size, newOffsetX: Float): Int {
    return (range.endInclusive / canvasSize.width * newOffsetX).toInt()
}

internal fun proportionForOffset(range: ClosedRange<Int>, canvasSize: Size, newPosition: Int): Float {
    return (canvasSize.width / range.endInclusive) * newPosition
}

internal fun List<ThumbInternalState>.findNearTo(offsetX: Float): ThumbInternalState? {
    if (isEmpty()) {
        return null
    }

    var nearest = this[0]
    var minDifference = abs(this[0].offsetX.minus(offsetX))

    for (element in this) {
        val difference = abs(element.offsetX - offsetX)
        if (difference < minDifference) {
            nearest = element
            minDifference = difference
        }
    }

    return nearest
}