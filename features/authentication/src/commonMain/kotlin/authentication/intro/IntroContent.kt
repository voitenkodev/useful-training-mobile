package authentication.intro

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import atom.Design
import authentication.intro.models.ScreenState
import components.animation.Levitating
import components.overlay.AlphaOverlay
import components.roots.ScreenRoot
import molecule.ButtonPrimary
import molecule.ButtonSecondary
import molecule.IconImage
import molecule.PaddingL
import molecule.PaddingM
import molecule.PaddingWeight
import molecule.PaddingXL
import molecule.PaddingXXL
import molecule.TextBody2
import molecule.TextH1
import resources.Icons

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

        Image(
            modifier = Modifier.fillMaxSize(),
            imageVector = Icons.logoBackground,
            contentDescription = null,
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier.fillMaxSize().systemBarsPadding(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            PaddingXXL()

            PaddingXXL()

            TextH1(
                provideText = { "ALIEN WORKOUT" },
            )

            PaddingWeight()

//            Levitating {
                IconImage(
                    modifier = Modifier.size(250.dp),
                    imageVector = Icons.logo
                )
//            }

            PaddingWeight()

            PaddingXL()

            TextBody2(
                provideText = { "Don't have an account yet?" },
                color = Design.colors.caption
            )

            PaddingM()

            ButtonPrimary(
                modifier = Modifier.fillMaxWidth().padding(horizontal = Design.dp.paddingL),
                text = "Get Started",
                onClick = registration
            )

            PaddingM()

            ButtonSecondary(
                modifier = Modifier.fillMaxWidth().padding(horizontal = Design.dp.paddingL),
                text = "Sign in",
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