package components.overlay

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import atom.Design

@Composable
public fun TopShadow(
    modifier: Modifier = Modifier
) {
    val color = Design.colors.primary

    Box(
        modifier = Modifier
            .background(
                brush = Brush.verticalGradient(
                    0.126f to color.copy(alpha = 1f),
                    0.307f to color.copy(alpha = 0.8f),
//                    0.458f to color.copy(alpha = 0.7f),
                    0.573f to color.copy(alpha = 0.52f),
                    0.715f to color.copy(alpha = 0.2f),
//                    0.767f to color.copy(alpha = 0.18f),
//                    0.824f to color.copy(alpha = 0.16f),
//                    0.879f to color.copy(alpha = 0.09f),
                    0.966f to color.copy(alpha = 0f)
                )
            ).then(modifier)
    )
}

@Composable
public fun BottomShadow(
    modifier: Modifier = Modifier
) {
    val color = Color(14, 14, 27)
    Box(
        modifier = Modifier
            .background(
                brush = Brush.verticalGradient(
                    0.03f to color.copy(alpha = 0f),
                    0.164f to color.copy(alpha = 0.4f),
                    0.203f to color.copy(alpha = 0.5f),
                    0.385f to color.copy(alpha = 0.73f),
                    1f to color.copy(alpha = 1f)
                )
            ).then(modifier)
    )
}