package components

import DesignComponent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import controls.TextFieldBody1
import controls.TextFieldH2
import kotlinx.coroutines.delay

@Composable
fun Error(
    modifier: Modifier = Modifier,
    message: String?,
    close: () -> Unit
) {

    val value = remember { mutableStateOf(message) }
    LaunchedEffect(message) { if (message != null) value.value = message }

    LaunchedEffect(message) {
        delay(1800)
        if (message != null) close.invoke()
    }

    AnimatedVisibility(
        visible = message != null,
        modifier = modifier.fillMaxWidth(),
        enter = slideInVertically(
            initialOffsetY = { fullHeight -> -fullHeight },
            animationSpec = tween(
                durationMillis = 300,
                easing = LinearOutSlowInEasing
            )
        ),
        exit = slideOutVertically(
            targetOffsetY = { fullHeight -> -fullHeight },
            animationSpec = tween(
                durationMillis = 300,
                easing = LinearOutSlowInEasing
            )
        )
    ) {
        Column(
            modifier = Modifier.padding(DesignComponent.size.space)
                .background(
                    color = DesignComponent.colors.accent_tertiary,
                    shape = DesignComponent.shape.default
                ).padding(DesignComponent.size.space),
            verticalArrangement = Arrangement.spacedBy(DesignComponent.size.space),
            content = {
                TextFieldH2(text = "Error!", fontWeight = FontWeight.Bold)
                TextFieldBody1(text = value.value)
            }
        )
    }
}