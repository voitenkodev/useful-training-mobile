package registration.screen.success

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import atom.Design
import com.arkivanov.essenty.backhandler.BackCallback
import components.animation.Levitating
import components.brand.UserCard
import io.github.xxfast.decompose.router.LocalRouterContext
import molecule.PaddingWeight
import molecule.PaddingXL
import molecule.TextBody1
import molecule.TextH2
import platformInsets

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
        toTrainings = toTrainings
    )
}

@Composable
private fun Content(
    name: String,
    height: String,
    weight: String,
    toTrainings: () -> Unit
) {

    val backHandler = LocalRouterContext.current.backHandler
    backHandler.register(BackCallback(onBack = toTrainings))

    Column(
        modifier = Modifier.fillMaxSize().platformInsets(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        PaddingXL()

        PaddingXL()

        TextH2(
            provideText = { "Success Registration" },
            color = Design.colors.toxic,
            textAlign = TextAlign.Center
        )

        TextBody1(
            provideText = { "Take your personal card!" },
            textAlign = TextAlign.Center
        )

        PaddingWeight()

        Levitating { modifier ->
            UserCard(
                modifier = modifier.padding(Design.dp.paddingL),
                name = name,
                weight = weight,
                height = height,
                btn = "Pick Up" to toTrainings
            )
        }

        PaddingWeight()

        PaddingXL()
    }
}