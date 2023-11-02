package components

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
import atom.Design
import kotlinx.coroutines.delay
import molecular.molecule.TextBody1
import molecular.molecule.TextH4
import platformInsets

@Composable
public fun Error(
    message: () -> String?,
    close: () -> Unit
) {

    val value = remember { mutableStateOf(message) }
    LaunchedEffect(message()) { if (message() != null) value.value = message }

    LaunchedEffect(message()) {
        delay(1800)
        if (message() != null) close.invoke()
    }

    InnerError(
        provideMessage = value.value,
        visibility = message() != null
    )
}

@Composable
private fun InnerError(
    provideMessage: () -> String?,
    visibility: Boolean,
) {
    AnimatedVisibility(
        visible = visibility,
        modifier = Modifier
            .fillMaxWidth(),
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
        ErrorContent(
            provideMessage = provideMessage
        )
    }
}

@Composable
private fun ErrorContent(
    provideMessage: () -> String?
) {
    Column(
        modifier = Modifier
            .platformInsets()
            .padding(Design.dp.paddingM)
            .background(
                color = Design.colors.accentPrimary,
                shape = Design.shape.default
            )
            .padding(Design.dp.paddingM),
        verticalArrangement = Arrangement.spacedBy(Design.dp.paddingM),
        content = {

            TextH4(provideText = { "Error!" }, fontWeight = FontWeight.Bold)

            TextBody1(provideText = provideMessage)
        }
    )
}