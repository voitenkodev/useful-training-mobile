package controls

import Design
import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip

@Composable
fun Modifier.rootBackground() = this
    .background(
        color = Design.colors.primary
    )

@Composable
fun Modifier.primaryBackground() = this
    .background(
        color = Design.colors.primary,
        shape = Design.shape.default
    ).clip(
        shape = Design.shape.default
    )

@Composable
fun Modifier.reversedBackground() = this
    .background(
        color = Design.colors.content,
        shape = Design.shape.circleShape
    ).clip(
        shape = Design.shape.circleShape
    )

@Composable
fun Modifier.secondaryBackground() = this
    .background(
        color = Design.colors.secondary,
        shape = Design.shape.default
    ).clip(
        shape = Design.shape.default
    )