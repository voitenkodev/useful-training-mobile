package registration.components

import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import components.inputs.InputName
import components.states.animateAlignmentAsState
import components.states.keyboardAsBoolean
import molecule.ButtonPrimary
import molecule.PaddingL
import molecule.PaddingM
import molecule.PaddingXL
import molecule.TextBody1
import molecule.TextH2
import platformBottomInset

@Composable
internal fun NamePage(
    name: String,
    updateName: (String) -> Unit,
    confirm: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize().platformBottomInset(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        PaddingL()

        TextH2(provideText = { "Nice to meet you" })

        TextBody1(provideText = { "How can we call you?" }, fontWeight = FontWeight.Medium)

        PaddingXL()

        InputName(
            provideValue = { name },
            onValueChange = updateName
        )

        PaddingM()

        val align = animateAlignmentAsState(
            targetAlignment = if (keyboardAsBoolean()) Alignment.TopCenter else Alignment.BottomCenter,
            animationSpec = tween(durationMillis = 400, easing = LinearOutSlowInEasing)
        )

        Box(
            modifier = Modifier.weight(1f),
            contentAlignment = align.value
        ) {

            ButtonPrimary(
                text = "Confirm",
                onClick = confirm,
                enabled = name.isNotBlank()
            )
        }

        PaddingXL()
    }
}
