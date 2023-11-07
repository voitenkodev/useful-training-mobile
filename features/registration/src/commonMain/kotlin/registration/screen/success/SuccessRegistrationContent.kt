package registration.screen.success

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import atom.Design
import com.arkivanov.essenty.backhandler.BackCallback
import io.github.xxfast.decompose.router.LocalRouterContext
import molecule.ButtonPrimary
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
        toTrainings = toTrainings
    )
}

@Composable
private fun Content(
    name: String,
    toTrainings: () -> Unit
) {

    val backHandler = LocalRouterContext.current.backHandler
    backHandler.register(BackCallback(onBack = toTrainings))

    Column(
        modifier = Modifier
            .fillMaxSize()
            .platformInsets(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        PaddingXL()

        PaddingXL()

        TextH2(
            provideText = { "Success Registration!" },
            color = Design.colors.accentSecondary,
            textAlign = TextAlign.Center
        )

        TextBody1(
            provideText = { "Hi, $name! Are you ready to workout!" },
            textAlign = TextAlign.Center
        )

        PaddingWeight()

        ButtonPrimary(
            text = "Go Workout",
            onClick = toTrainings
        )

        PaddingXL()
    }
}