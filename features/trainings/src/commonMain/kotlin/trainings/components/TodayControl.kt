package trainings.components

import androidx.compose.animation.core.EaseOut
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import atom.Design
import icons.ArrowRight
import molecule.ButtonIconPrimary

@Composable
internal fun BoxScope.TodayControl(
    modifier: Modifier = Modifier,
    visibilityCondition: () -> Boolean = { true },
    click: () -> Unit
) {

    val width = Design.dp.componentL + Design.dp.paddingXL

    val animatedDp by animateDpAsState(
        targetValue = if (visibilityCondition()) 0.dp else width + Design.dp.paddingXL,
        animationSpec = tween(
            durationMillis = 300,
            delayMillis = 250,
            easing = EaseOut
        )
    )

    ButtonIconPrimary(
        modifier = modifier
            .width(width)
            .align(Alignment.CenterEnd)
            .offset(x = animatedDp),
        imageVector = ArrowRight,
        onClick = click
    )
}