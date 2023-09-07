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
fun BoxScope.BottomScreenGradient(height: Dp = 173.dp) {
    val color = Color.Black
    Box(
        modifier = Modifier
            .align(Alignment.BottomCenter)
            .fillMaxWidth()
            .height(height)
            .background(
                brush = Brush.verticalGradient(
                    0.03f to color.copy(alpha = 0f),
                    0.164f to color.copy(alpha = 0.4f),
                    0.203f to color.copy(alpha = 0.5f),
                    0.385f to color.copy(alpha = 0.73f),
                    1f to color.copy(alpha = 1f),
                )
            )
    )
}
