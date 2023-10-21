package controls

import Design
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

@Composable
public fun Modifier.rootBackground(): Modifier = this
    .background(
        color = Design.colors.primary
    )

@Composable
public fun Modifier.accentBackground(): Modifier = this
    .background(
        color = Design.colors.accent_primary,
        shape = Design.shape.default
    ).clip(
        shape = Design.shape.default
    )

@Composable
public fun Modifier.quaternaryBackground(): Modifier = this
    .background(
        color = Design.colors.black30,
        shape = Design.shape.default
    ).clip(
        shape = Design.shape.default
    )

@Composable
public fun Modifier.tertiaryBackground(): Modifier = this
    .border(
        color = Design.colors.white10,
        width = 0.5.dp,
        shape = Design.shape.default
    ).background(
        color = Design.colors.tertiary,
        shape = Design.shape.default
    ).clip(
        shape = Design.shape.default
    )

@Composable
public fun Modifier.reversedCircleBackground(): Modifier = this
    .background(
        color = Design.colors.content,
        shape = Design.shape.circleShape
    ).clip(
        shape = Design.shape.circleShape
    )

@Composable
public fun Modifier.reversedRoundBackground(): Modifier = this
    .background(
        color = Design.colors.content,
        shape = Design.shape.default
    ).clip(
        shape = Design.shape.default
    )

