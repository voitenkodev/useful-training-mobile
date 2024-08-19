package trainings.main.components

import androidx.compose.animation.core.EaseOut
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import atom.Design
import molecule.ButtonText
import resources.Icons

@Composable
internal fun TodayControl(
    modifier: Modifier = Modifier,
    visibilityCondition: () -> Boolean = { true },
    click: () -> Unit
) {

    val width = 64.dp
    val padding = Design.dp.paddingL

    val animatedDp by animateDpAsState(
        targetValue = if (visibilityCondition()) 0.dp else width + padding,
        animationSpec = tween(
            durationMillis = 300,
            delayMillis = 150,
            easing = EaseOut
        )
    )

    ButtonText(
        modifier = modifier
            .padding(end = padding)
            .offset(x = animatedDp),
        trailingIcon = Icons.arrowRight,
        color = Design.colors.orange,
        textDecoration = TextDecoration.None,
        onClick = click,
        text = "TODAY"
    )
}