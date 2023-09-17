package components.backgrounds

import Design
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import components.overlay.shadowBottomFrame

@Composable
fun BoxScope.BottomShadowBackground(
    modifier: Modifier = Modifier,
) {
    Spacer(
        modifier = modifier
            .align(Alignment.BottomCenter)
            .fillMaxWidth()
            .height(220.dp)
            .shadowBottomFrame(
                listOf(
                    Color.Transparent,
                    Color.Transparent,
                    Design.colors.primary.copy(alpha = 0.5f),
                    Design.colors.primary.copy(alpha = 0.8f),
                    Design.colors.primary,
                    Design.colors.primary
                )
            )
    )
}