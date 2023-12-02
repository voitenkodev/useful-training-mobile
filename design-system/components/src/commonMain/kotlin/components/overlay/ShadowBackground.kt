package components.overlay

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Spacer
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import atom.Design

@Composable
public fun ShadowBackground(
    modifier: Modifier = Modifier,
    condition: Boolean = true,
    shadow: Color = Design.colors.black70,
    onClick: () -> Unit = {}
) {

    val interactionSource = remember { MutableInteractionSource() }

    val enabled = remember {
        mutableStateOf(condition)
    }
    if (condition.not()) return

    val animatedValue = remember {
        mutableStateOf(Color.Transparent)
    }

    val color by animateColorAsState(
        targetValue = animatedValue.value,
        finishedListener = { enabled.value = it == Color.Transparent }
    )

    LaunchedEffect(condition) {
        if (condition) animatedValue.value = shadow
        else animatedValue.value = Color.Transparent
    }

    Spacer(
        modifier = modifier
            .clickable(enabled = enabled.value, onClick = {})
    )

    Spacer(
        modifier = modifier
            .background(color = color)
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = onClick
            )
    )
}