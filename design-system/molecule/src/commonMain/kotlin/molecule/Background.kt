package molecule

import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
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
public fun Modifier.secondaryBackground(): Modifier = this
    .background(
        color = Design.colors.secondary
    )

@Composable
public fun Modifier.secondaryDefaultBackground(): Modifier = this
    .background(
        color = Design.colors.secondary,
        shape = Design.shape.default
    ).clip(
        shape = Design.shape.default
    )

@Composable
public fun Modifier.bottomSheetBackground(): Modifier = this
    .background(
        color = Design.colors.secondary,
        shape = RoundedCornerShape(topEnd = 26.dp, topStart = 26.dp)
    ).clip(
        shape = RoundedCornerShape(topEnd = 26.dp, topStart = 26.dp)
    )

@Composable
public fun Modifier.secondarySmallBackground(): Modifier = this
    .borderSmall()
    .background(
        color = Design.colors.secondary,
        shape = Design.shape.small
    ).clip(
        shape = Design.shape.small
    )

@Composable
public fun Modifier.coloredDefaultBackgroundNoBorder(color: Color): Modifier = this
    .background(
        color = color,
        shape = Design.shape.default
    ).clip(
        shape = Design.shape.default
    )