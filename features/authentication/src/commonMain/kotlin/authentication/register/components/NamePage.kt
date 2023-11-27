package authentication.register.components

import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import components.inputs.InputName
import components.states.animateAlignmentAsState
import components.states.keyboardAsBoolean
import molecule.ButtonPrimary
import molecule.PaddingM
import molecule.PaddingXL
import molecule.TextBody2
import molecule.TextH2
import platformBottomInset

@Composable
internal fun NamePage(
    name: String,
    updateName: (String) -> Unit,
    confirm: () -> Unit
) {
    val focus = LocalFocusManager.current

    val confirmProvider by rememberUpdatedState {
        focus.clearFocus()
        confirm.invoke()
    }

    Column(
        modifier = Modifier.fillMaxSize().platformBottomInset(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        PaddingM()

        TextH2(provideText = { "Nice to meet you" })

        TextBody2(provideText = { "How can we call you?" })

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
                onClick = confirmProvider,
                enabled = name.isNotBlank()
            )
        }

        PaddingXL()
    }
}
