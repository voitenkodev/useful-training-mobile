package controls

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset

@Composable
fun IterationVerticalGrid(
    modifier: Modifier = Modifier,
    spacing: Dp,
    content: @Composable () -> Unit
) = Layout(
    content = content,
    modifier = modifier
) { measure, constraints ->

    var currentRow = 0
    var currentOrigin = IntOffset.Zero
    val spacingValue = spacing.toPx().toInt()
    val place = measure.map { measurable ->
        val placeable = measurable.measure(constraints)

        if (currentOrigin.x > 0f && currentOrigin.x + placeable.width > constraints.maxWidth) {
            currentRow += 1
            currentOrigin = currentOrigin.copy(x = 0, y = currentOrigin.y + placeable.height + spacingValue)
        }

        placeable to currentOrigin.also {
            currentOrigin = it.copy(x = it.x + placeable.width + spacingValue)
        }
    }

    layout(
        width = constraints.maxWidth,
        height = place.lastOrNull()?.run { first.height + second.y } ?: 0
    ) {
        place.forEach {
            val (placeable, origin) = it
            placeable.place(origin.x, origin.y)
        }
    }
}