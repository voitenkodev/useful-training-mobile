package components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import atom.Design

@Composable
public fun GradientBackground(modifier: Modifier = Modifier) {

    BoxWithConstraints(modifier = modifier.fillMaxSize()) {

        val aspectRatio = maxWidth / maxHeight

        Box(
            Modifier
                .fillMaxSize()
                .scale(maxOf(aspectRatio, 1f), maxOf(1 / aspectRatio, 1f))
                .offset(
                    y = -(maxHeight / 4)
                )
                .background(
                    brush = Brush.radialGradient(
                        colors = listOf(
                            Design.colors.secondary,
                            Design.colors.primary
                        )
                    )
                )
        )
    }
}