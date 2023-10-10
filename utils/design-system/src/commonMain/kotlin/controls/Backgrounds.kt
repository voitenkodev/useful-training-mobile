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
fun Modifier.accentBackground() = this
    .background(
        color = Design.colors.accent_primary,
        shape = Design.shape.default
    ).clip(
        shape = Design.shape.default
    )

@Composable
fun Modifier.quaternaryBackground() = this
    .background(
        color = Design.colors.black30,
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

@Composable
fun Modifier.reversedCircleBackground() = this
    .background(
        color = Design.colors.content,
        shape = Design.shape.circleShape
    ).clip(
        shape = Design.shape.circleShape
    )

@Composable
fun Modifier.reversedRoundBackground() = this
    .background(
        color = Design.colors.content,
        shape = Design.shape.default
    ).clip(
        shape = Design.shape.default
    )

