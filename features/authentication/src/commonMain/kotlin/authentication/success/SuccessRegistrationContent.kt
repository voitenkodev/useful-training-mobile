package authentication.success

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import atom.Design
import com.arkivanov.essenty.backhandler.BackCallback
import components.Error
import components.cards.UserCard
import components.roots.ScreenRoot
import io.github.xxfast.decompose.router.LocalRouterContext
import molecule.ButtonPrimary
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
        email = state.email,
        experienceIcon = state.experienceIcon,
        toTrainings = toTrainings,
        error = state.error,
        clearError = vm::clearError
    )
}

@Composable
private fun Content(
    name: String,
    height: String,
    email: String,
    weight: String,
    experienceIcon: ImageVector?,
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
                textAlign = TextAlign.Center
            )

            PaddingXS()

            TextBody2(
                provideText = { "Take your personal card!" },
                textAlign = TextAlign.Center
            )

            PaddingXXL()

            PaddingXXL()

            UserCard(
                modifier = Modifier
                    .padding(Design.dp.paddingL)
                    .shadow(
                        elevation = 5.dp,
                        ambientColor = Design.colors.white10,
                        spotColor = Design.colors.white10,
                        shape = Design.shape.default,
                    ),
                name = name,
                weight = weight,
                email = email,
                experienceIcon = experienceIcon,
                height = height,
            )

            PaddingWeight()

            ButtonPrimary(
                modifier = Modifier.width(Design.dp.componentXXL),
                text = "Start",
                onClick = toTrainings,
            )

            PaddingXL()
        }
    }
}