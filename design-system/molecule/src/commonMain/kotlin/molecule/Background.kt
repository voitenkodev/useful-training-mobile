package molecule

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import atom.Design

@Composable
public fun Modifier.primaryBackground(): Modifier = this
    .background(
        color = Design.colors.primary
    )

@Composable
public fun Modifier.accentPrimaryDefaultBackground(): Modifier = this
    .borderDefaultPrimary()
    .background(
        color = Design.colors.orange,
        shape = Design.shape.default
    ).clip(
        shape = Design.shape.default
    )

@Composable
public fun Modifier.secondaryRoundBackground(): Modifier = this
    .background(
        color = Design.colors.secondary
    )

@Composable
public fun Modifier.secondaryDefaultBackground(): Modifier = this
    .borderDefaultPrimary()
    .background(
        color = Design.colors.secondary,
        shape = Design.shape.default
    ).clip(
        shape = Design.shape.default
    )


@Composable
public fun Modifier.black10DefaultBackground(): Modifier = this
    .borderDefaultPrimary()
    .background(
        color = Design.colors.black10,
        shape = Design.shape.default
    ).clip(
        shape = Design.shape.default
    )

@Composable
public fun Modifier.secondaryCircleBackground(): Modifier = this
    .borderCirclePrimary()
    .background(
        color = Design.colors.secondary,
        shape = Design.shape.circleShape
    ).clip(
        shape = Design.shape.circleShape
    )

@Composable
public fun Modifier.secondarySmallBackground(): Modifier = this
    .borderSmallPrimary()
    .background(
        color = Design.colors.secondary,
        shape = Design.shape.small
    ).clip(
        shape = Design.shape.small
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
public fun Modifier.black30RoundBackground(): Modifier = this
    .background(
        color = Design.colors.black30
    )

@Composable
public fun Modifier.white5DefaultBackgroundNoBorder(): Modifier = this
    .background(
        color = Design.colors.white5,
        shape = Design.shape.default
    ).clip(
        shape = Design.shape.default
    )

@Composable
public fun Modifier.white5CircleBackground(): Modifier = this
    .borderCirclePrimary()
    .background(
        color = Design.colors.white5,
        shape = Design.shape.circleShape
    ).clip(
        shape = Design.shape.circleShape
    )

@Composable
public fun Modifier.white5CircleBackgroundNoBorder(): Modifier = this
    .background(
        color = Design.colors.white5,
        shape = Design.shape.circleShape
    ).clip(
        shape = Design.shape.circleShape
    )

@Composable
public fun Modifier.coloredCircleBackgroundNoBorder(color: Color): Modifier = this
    .background(
        color = color,
        shape = Design.shape.circleShape
    ).clip(
        shape = Design.shape.circleShape
    )

@Composable
public fun Modifier.coloredDefaultBackgroundNoBorder(color: Color): Modifier = this
    .background(
        color = color,
        shape = Design.shape.default
    ).clip(
        shape = Design.shape.default
    )

@Composable
public fun Modifier.coloredDefaultBackground(color: Color): Modifier = this
    .borderDefaultPrimary()
    .background(
        color = color,
        shape = Design.shape.default
    ).clip(
        shape = Design.shape.default
    )