package components

import Design
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import controls.ButtonBrand
import controls.TextFieldBody1
import controls.TextFieldH4
import controls.quaternaryBackground
import platformInsets
import recomposeHighlighter

@Composable
fun Popup(
    modifier: Modifier = Modifier,
    visibility: Boolean = false,
    title: String?,
    message: String?,
    button: String?,
    click: () -> Unit,
    back: () -> Unit
) {

    if (visibility) {

        val interactionSource = remember { MutableInteractionSource() }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.5f))
                .clickable(
                    interactionSource = interactionSource,
                    indication = null,
                    onClick = back
                ).recomposeHighlighter()
        )
    }

    AnimatedVisibility(
        visible = visibility,
        modifier = modifier.fillMaxWidth().recomposeHighlighter(),
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
            modifier = Modifier
                .platformInsets()
                .padding(Design.dp.paddingM)
                .quaternaryBackground()
                .padding(Design.dp.paddingM)
                .recomposeHighlighter(),
            verticalArrangement = Arrangement.spacedBy(Design.dp.paddingM),
            content = {

                TextFieldH4(
                    modifier = Modifier.recomposeHighlighter(),
                    provideText = { title },
                    fontWeight = FontWeight.Bold
                )

                TextFieldBody1(
                    modifier = Modifier.recomposeHighlighter(),
                    provideText = { message }
                )

                button?.let {
                    ButtonBrand(
                        modifier = Modifier.fillMaxWidth().recomposeHighlighter(),
                        text = button,
                        onClick = click
                    )
                }
            }
        )
    }
}