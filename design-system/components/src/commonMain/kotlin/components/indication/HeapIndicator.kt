package components.indication

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import atom.Design

@Composable
public fun HeapIndicator(modifier: Modifier = Modifier) {
    val baseAlpha = 0.1f
    val color = Design.colors.orange

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Spacer(
            modifier = Modifier
                .background(
                    color = Design.colors.content,
                    shape = Design.shape.small
                ).width(4.dp)
                .height(14.dp)
        )

        repeat(10) {
            Spacer(
                modifier = Modifier
                    .background(
                        color = color.copy(alpha = baseAlpha + it * 0.1f),
                        shape = Design.shape.small
                    ).width(4.dp)
                    .height(14.dp)
            )
        }

        Spacer(
            modifier = Modifier
                .background(
                    color = Design.colors.content,
                    shape = Design.shape.small
                ).width(4.dp)
                .height(14.dp)
        )
    }
}