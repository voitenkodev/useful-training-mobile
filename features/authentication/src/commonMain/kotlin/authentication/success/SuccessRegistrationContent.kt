package authentication.success

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import atom.Design
import com.arkivanov.essenty.backhandler.BackCallback
import components.Error
import components.cards.UserCardLarge
import components.roots.ScreenRoot
import io.github.xxfast.decompose.router.LocalRouterContext
import molecule.ButtonPrimary
import molecule.PaddingWeight
import molecule.PaddingXL
import molecule.PaddingXS
import molecule.PaddingXXL
import molecule.TextBody2
import molecule.TextH2
import user.User

@Composable
internal fun SuccessRegistrationContent(
    vm: SuccessRegistrationViewModel,
    toTrainings: () -> Unit
) {

    val state by vm.state.collectAsState()

    Content(
        user = state.user,
        toTrainings = toTrainings,
        error = state.error,
        clearError = vm::clearError
    )
}

@Composable
private fun Content(
    user: User?,
    toTrainings: () -> Unit,
    error: String?,
    clearError: () -> Unit
) {

    val backHandler = LocalRouterContext.current.backHandler
    backHandler.register(BackCallback(onBack = toTrainings))

    ScreenRoot(error = { Error(message = { error }, close = clearError) }) {

        Column(
            modifier = Modifier.fillMaxSize()
                .systemBarsPadding()
                .padding(horizontal = Design.dp.paddingL),
            horizontalAlignment = Alignment.Start
        ) {

            PaddingXXL()

            TextH2(
                provideText = { "Congratulations!" },
                textAlign = TextAlign.Center
            )

            PaddingXS()

            TextBody2(
                provideText = { "Take your personal card!" },
                textAlign = TextAlign.Center,
                color = Design.colors.label
            )

            PaddingWeight(value = 0.5f)

            if (user != null) {
                UserCardLarge(
                    name = user.name,
                    weight = user.weight,
                    email = user.email,
                    height = user.height,
                )
            }

            PaddingWeight(value = 1.5f)

            ButtonPrimary(
                modifier = Modifier.fillMaxWidth(),
                text = "Let's go!",
                onClick = toTrainings,
            )

            PaddingXL()
        }
    }
}