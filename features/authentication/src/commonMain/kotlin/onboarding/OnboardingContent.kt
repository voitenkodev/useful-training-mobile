package onboarding

import Design
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import components.backgrounds.BackgroundIntroVideo
import components.overlay.AlphaOverlay
import controls.ButtonPrimary
import controls.ButtonSecondary
import platformInsets
import recomposeHighlighter

@Composable
fun OnboardingContent(
    login: () -> Unit,
    joinUs: () -> Unit,
    back: () -> Unit
) {

    Content(
        back = back,
        login = login,
        joinUs = joinUs
    )
}

@Composable
private fun Content(
    login: () -> Unit,
    joinUs: () -> Unit,
    back: () -> Unit
) {

    val loginProvider by rememberUpdatedState(login)
    val joinUsProvider by rememberUpdatedState(joinUs)
    val backProvider by rememberUpdatedState(back)

    BackgroundIntroVideo()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .platformInsets()
            .padding(Design.dp.padding),
        verticalArrangement = Arrangement.spacedBy(Design.dp.padding),
    ) {

        Spacer(modifier = Modifier.weight(1f))

        Row(horizontalArrangement = Arrangement.spacedBy(Design.dp.padding)) {

            ButtonPrimary(
                modifier = Modifier
                    .weight(1f)
                    .recomposeHighlighter(),
                text = "Join Us",
                onClick = loginProvider
            )

            ButtonSecondary(
                modifier = Modifier
                    .weight(1f)
                    .recomposeHighlighter(),
                text = "Log In",
                onClick = joinUsProvider
            )

            Spacer(
                modifier = Modifier.weight(0.3f)
            )
        }
    }

    AlphaOverlay(
        modifier = Modifier.fillMaxSize()
    )
}