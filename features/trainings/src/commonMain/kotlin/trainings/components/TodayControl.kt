package trainings.components

import Design
import androidx.compose.animation.core.EaseOut
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import controls.ButtonIconBrand

@Composable
internal fun BoxScope.TodayControl(
    modifier: Modifier = Modifier,
    visibilityCondition: () -> Boolean = { true },
    click: () -> Unit,
) {

    val width = Design.dp.componentM + Design.dp.paddingL

    val animatedDp by animateDpAsState(
        targetValue = if (visibilityCondition()) 0.dp else width + Design.dp.paddingL,
        animationSpec = tween(
            durationMillis = Design.duration.animDurationS,
            delayMillis = 250,
            easing = EaseOut
        )
    )

    ButtonIconBrand(
        modifier = modifier
            .width(width)
            .align(Alignment.CenterEnd)
            .offset(x = animatedDp),
        imageVector = Icons.Default.KeyboardArrowRight,
        onClick = click,
        contentColor = Design.colors.primary
    )
}