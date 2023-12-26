package authentication.intro

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import atom.Design
import authentication.intro.models.ScreenState
import components.overlay.AlphaOverlay
import components.roots.ScreenRoot
import molecule.ButtonPrimary
import molecule.ButtonSecondary
import molecule.PaddingL
import molecule.PaddingM
import molecule.PaddingWeight
import molecule.PaddingXL
import molecule.TextBody2
import molecule.TextH2

@Composable
internal fun IntroContent(
    vm: IntroViewModel,
    toLogin: () -> Unit,
    toRegistration: () -> Unit
) {

    val state by vm.state.collectAsState()

    Content(
        login = toLogin,
        registration = toRegistration,
        screenState = state.screenState,
        markScreenAsShowedOnce = vm::markScreenAsShowedOnce
    )
}

@Composable
private fun Content(
    screenState: ScreenState,
    markScreenAsShowedOnce: () -> Unit,
    login: () -> Unit,
    registration: () -> Unit
) {

    ScreenRoot(modifier = Modifier.imePadding()) {

        Column(
            modifier = Modifier.fillMaxSize().systemBarsPadding(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            PaddingXL()

            PaddingM()

            TextH2(provideText = { "Welcome" }, textAlign = TextAlign.Center)

            TextBody2(provideText = { "Sign in with your email" }, textAlign = TextAlign.Center)

            PaddingM()

            PaddingWeight()

            ButtonPrimary(
                modifier = Modifier.fillMaxWidth().padding(horizontal = Design.dp.paddingM),
                text = "Join Us",
                onClick = registration,
            )

            PaddingL()

            ButtonSecondary(
                modifier = Modifier.fillMaxWidth().padding(horizontal = Design.dp.paddingM),
                text = "Sign In",
                onClick = login
            )

            PaddingL()
        }

        AlphaOverlay(
            modifier = Modifier.fillMaxSize(),
            condition = screenState == ScreenState.Default,
            finishedListener = markScreenAsShowedOnce
        )
    }
}