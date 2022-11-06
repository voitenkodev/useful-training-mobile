package components

import Design
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
            modifier = Modifier.padding(Design.dp.padding)
                .background(
                    color = Design.colors.accent_tertiary,
                    shape = Design.shape.default
                ).padding(Design.dp.padding),
            verticalArrangement = Arrangement.spacedBy(Design.dp.padding),
            content = {
                TextFieldH2(text = "Error!", fontWeight = FontWeight.Bold)
                TextFieldBody1(text = value.value)
            }
        )
    }
}