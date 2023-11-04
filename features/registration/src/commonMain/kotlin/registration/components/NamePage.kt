package registration.components

import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import atom.Design
import brandartifacts.Planet1
import components.inputs.InputName
import components.states.animateAlignmentAsState
import components.states.keyboardAsBoolean
import molecule.ButtonPrimary
import molecule.PaddingL
import molecule.PaddingM
import molecule.TextBody1
import molecule.TextH1

@Composable
internal fun NamePage() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(Design.dp.paddingM),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        PaddingM()

        Planet1()

        PaddingM()

        TextH1(provideText = { "Nice to meet you." })

        TextBody1(provideText = { "How can we call you?" }, fontWeight = FontWeight.Medium)

        PaddingL()

        InputName(
            onValueChange = {},
            provideValue = { "" }
        )

        PaddingM()

        val align = animateAlignmentAsState(
            targetAlignment = if (keyboardAsBoolean()) Alignment.TopCenter else Alignment.BottomCenter,
            animationSpec = tween(
                durationMillis = 400,
                easing = LinearOutSlowInEasing
            )
        )

        Box(
            modifier = Modifier.weight(1f),
            contentAlignment = align.value
        ) {

            ButtonPrimary(
                text = "Submit",
                onClick = {},
                enabled = true,
            )
        }
    }
}