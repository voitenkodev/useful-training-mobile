package authentication.intro

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import atom.Design
import authentication.intro.models.ScreenState
import components.animation.Levitating
import components.cards.UserCard
import components.overlay.AlphaOverlay
import components.roots.ScreenRoot
import molecule.ButtonPrimary
import molecule.PaddingL
import molecule.PaddingM
import molecule.PaddingWeight
import molecule.PaddingXL
import molecule.TextBody1
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

            TextH2(provideText = { "Alien workout" }, textAlign = TextAlign.Center, color = Design.colors.toxic)

            TextBody1(provideText = { "Get your card and take power up" }, textAlign = TextAlign.Center)

            PaddingWeight()

            Levitating { modifier ->
                UserCard(
                    modifier = modifier.padding(horizontal = Design.dp.paddingL),
                    name = "Not identified",
                    image = null,
                    weight = null,
                    height = null,
                    buttonSecondary = "Sign In" to login
                )
            }

            PaddingWeight()

            PaddingXL()

            TextBody2(
                provideText = { "Don't have an account yet?" },
                color = Design.colors.caption
            )

            PaddingM()

            ButtonPrimary(
                modifier = Modifier.width(Design.dp.componentXL),
                text = "Join Us",
                onClick = registration
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