package trainings.main.components

import androidx.compose.animation.core.EaseOut
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import atom.Design
import molecule.ButtonIconPrimary
import molecule.ButtonIconSecondary
import molecule.ButtonIconTransparent
import resources.Icons

@Composable
internal fun BoxScope.TodayControl(
    modifier: Modifier = Modifier,
    visibilityCondition: () -> Boolean = { true },
    click: () -> Unit
) {

    val width = Design.dp.componentS
    val padding = Design.dp.paddingL

    val animatedDp by animateDpAsState(
        targetValue = if (visibilityCondition()) 0.dp else width + padding,
        animationSpec = tween(
            durationMillis = 300,
            delayMillis = 250,
            easing = EaseOut
        )
    )

    ButtonIconSecondary(
        modifier = modifier
            .padding(end = padding)
            .align(Alignment.CenterEnd)
            .offset(x = animatedDp),
        imageVector = Icons.arrowRight,
        onClick = click
    )
}