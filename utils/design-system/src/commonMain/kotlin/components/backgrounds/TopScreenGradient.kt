package components.backgrounds

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun BoxScope.TopScreenGradient(height: Dp = 176.dp) {
    val color = Color(14, 14, 27)
    Box(
        modifier = Modifier
            .align(Alignment.TopCenter)
            .fillMaxWidth()
            .height(height)
            .background(
                brush = Brush.verticalGradient(
                    0.126f to color.copy(alpha = 1f),
                    0.307f to color.copy(alpha = 0.8f),
                    0.458f to color.copy(alpha = 0.7f),
                    0.573f to color.copy(alpha = 0.52f),
                    0.715f to color.copy(alpha = 0.2f),
                    0.767f to color.copy(alpha = 0.18f),
                    0.824f to color.copy(alpha = 0.16f),
                    0.879f to color.copy(alpha = 0.09f),
                    0.966f to color.copy(alpha = 0f),
                )
            )
    )
}