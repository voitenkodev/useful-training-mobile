package authentication.success

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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
import components.animation.Levitating
import components.cards.UserCard
import components.roots.ScreenRoot
import io.github.xxfast.decompose.router.LocalRouterContext
import molecule.PaddingWeight
import molecule.PaddingXL
import molecule.PaddingXS
import molecule.PaddingXXL
import molecule.TextBody2
import molecule.TextH2

@Composable
internal fun SuccessRegistrationContent(
    vm: SuccessRegistrationViewModel,
    toTrainings: () -> Unit
) {

    val state by vm.state.collectAsState()

    Content(
        name = state.name,
        height = state.height,
        weight = state.weight,
        toTrainings = toTrainings,
        error = state.error,
        clearError = vm::clearError
    )
}

@Composable
private fun Content(
    name: String,
    height: String,
    weight: String,
    toTrainings: () -> Unit,
    error: String?,
    clearError: () -> Unit
) {

    val backHandler = LocalRouterContext.current.backHandler
    backHandler.register(BackCallback(onBack = toTrainings))

    ScreenRoot(error = { Error(message = { error }, close = clearError) }) {

        Column(
            modifier = Modifier.fillMaxSize().systemBarsPadding(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            PaddingXXL()

            PaddingXXL()

            TextH2(
                provideText = { "Congratulations!" },
                color = Design.colors.toxic,
                textAlign = TextAlign.Center
            )

            PaddingXS()

            TextBody2(
                provideText = { "Take your personal card!" },
                textAlign = TextAlign.Center
            )

            PaddingWeight()

            Levitating { modifier ->
                UserCard(
                    modifier = modifier.padding(Design.dp.paddingL),
                    name = name,
                    image = "https://static.vecteezy.com/system/resources/previews/017/067/906/original/ufo-seamless-background-free-vector.jpg",
                    weight = weight,
                    height = height,
                    buttonPrimary = "Pick Up" to toTrainings
                )
            }

            PaddingWeight()

            PaddingXL()
        }
    }
}