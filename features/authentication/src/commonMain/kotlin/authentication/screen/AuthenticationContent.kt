package authentication.screen

import Design
import PlatformBackHandler
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import authentication.state.TokenStatus
import components.Error
import components.Loading
import components.backgrounds.BackgroundIntro
import components.backgrounds.BottomShadowBackground
import components.backgrounds.BrandGradientBottomEnd
import components.backgrounds.BrandGradientCenterStart
import components.buttons.ButtonQuestion
import components.inputs.InputEmail
import components.inputs.InputPassword
import components.overlay.AlphaOverlay
import components.roots.Root
import components.states.keyboardFloatAsState
import molecular.ButtonPrimary
import molecular.PaddingL
import molecular.PaddingM
import molecular.TextBody1
import molecular.TextH1
import platformInsets
import recomposeHighlighter

@Composable
internal fun AuthenticationContent(
    vm: AuthenticationViewModel,
    toTrainings: () -> Unit,
    back: () -> Unit
) {

    val state by vm.state.collectAsState()

    LaunchedEffect(state.tokenStatus) {
        if (state.tokenStatus == TokenStatus.Available) toTrainings.invoke()
    }

    Content(
        loading = { state.loading },
        error = { state.error },
        clearError = vm::clearError,
        back = back,
        login = vm::login,
        registration = vm::registration,
        email = { state.email },
        updateEmail = vm::updateEmail,
        password = { state.password },
        updatePassword = vm::updatePassword
    )
}

@Composable
private fun Content(
    loading: () -> Boolean,
    error: () -> String?,
    clearError: () -> Unit,
    back: () -> Unit,

    login: () -> Unit,
    registration: () -> Unit,

    email: () -> String,
    updateEmail: (String) -> Unit,
    password: () -> String,
    updatePassword: (String) -> Unit,
) {

    val focus = LocalFocusManager.current

    val loginProvider by rememberUpdatedState {
        focus.clearFocus()
        login.invoke()
    }
    val registrationProvider by rememberUpdatedState {
        focus.clearFocus()
        registration.invoke()
    }
    val backProvider by rememberUpdatedState(back)

    val keyboardFloatAsState = keyboardFloatAsState(
        initialValue = 1f,
        targetValue = 0.3f
    )

    Root(
        loading = { Loading(loading) },
        error = { Error(message = error, close = clearError) },
        back = { PlatformBackHandler(backProvider) },
    ) {

        Box(
            Modifier
                .fillMaxWidth()
                .aspectRatio(0.7f)
        ) {

            BackgroundIntro(modifier = Modifier.fillMaxSize())

            BottomShadowBackground()
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .platformInsets()
                .padding(Design.dp.paddingM),
        ) {

            Spacer(Modifier.weight(keyboardFloatAsState.value))

            TextH1(
                provideText = { "WELCOME BACK" }
            )

            TextBody1(
                provideText = { "Good to see you again, enter your details\nbelow to continue exercises" },
                color = Design.colors.caption
            )

            PaddingL()

            InputEmail(
                modifier = Modifier
                    .fillMaxWidth()
                    .recomposeHighlighter(),
                provideValue = email,
                onValueChange = updateEmail
            )

            PaddingM()

            InputPassword(
                modifier = Modifier
                    .fillMaxWidth()
                    .recomposeHighlighter(),
                provideValue = password,
                onValueChange = updatePassword
            )

            PaddingL()

            ButtonPrimary(
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .align(Alignment.CenterHorizontally)
                    .recomposeHighlighter(),
                text = "SIGN IN",
                onClick = loginProvider
            )

            Spacer(Modifier.weight(1f))

            ButtonQuestion(
                modifier = Modifier
                    .fillMaxWidth()
                    .recomposeHighlighter(),
                question = "Don't have an account yet?",
                answer = "Join Us!",
                onClick = registrationProvider
            )
        }

        BrandGradientCenterStart(
            color = Design.colors.accentSecondary
        )

        BrandGradientBottomEnd(
            color = Design.colors.accentSecondary
        )

        AlphaOverlay(
            modifier = Modifier.fillMaxSize()
        )
    }
}