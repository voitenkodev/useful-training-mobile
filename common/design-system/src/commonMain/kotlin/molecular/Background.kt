package molecular

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
public fun Modifier.accentDefaultBackground(): Modifier = this
    .background(
        color = Design.colors.accentPrimary,
        shape = Design.shape.default
    ).clip(
        shape = Design.shape.default
    )

@Composable
public fun Modifier.secondaryDefaultBackground(): Modifier = this
    .border(
        color = Design.colors.white5,
        width = 1.dp,
        shape = Design.shape.default
    ).background(
        color = Design.colors.secondary,
        shape = Design.shape.default
    ).clip(
        shape = Design.shape.default
    )

@Composable
public fun Modifier.secondarySmallBackground(): Modifier = this
    .border(
        color = Design.colors.white5,
        width = 1.dp,
        shape = Design.shape.small
    ).background(
        color = Design.colors.secondary,
        shape = Design.shape.small
    ).clip(
        shape = Design.shape.small
    )

@Composable
public fun Modifier.secondaryCircleBackground(): Modifier = this
    .border(
        color = Design.colors.white5,
        width = 1.dp,
        shape = Design.shape.circleShape
    ).background(
        color = Design.colors.secondary,
        shape = Design.shape.circleShape
    ).clip(
        shape = Design.shape.circleShape
    )

@Composable
public fun Modifier.transparentCircleBackground(): Modifier = this
    .border(
        color = Design.colors.caption,
        width = 1.dp,
        shape = Design.shape.circleShape
    ).clip(
        shape = Design.shape.circleShape
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
