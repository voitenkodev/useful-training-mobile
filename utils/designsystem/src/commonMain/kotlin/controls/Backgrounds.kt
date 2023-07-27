package controls

import Design
import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip

@Composable
fun Modifier.secondaryBackground() = this
    .background(
        color = Design.colors.secondary,
        shape = Design.shape.default
    ).clip(
        shape = Design.shape.default
    )

@Composable
fun Modifier.tertiaryBackground() = this
    .background(
        color = Design.colors.tertiary,
        shape = Design.shape.default
    ).clip(
        shape = Design.shape.default
    )