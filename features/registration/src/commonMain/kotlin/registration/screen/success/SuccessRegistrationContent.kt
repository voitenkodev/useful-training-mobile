package registration.screen.success

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.arkivanov.essenty.backhandler.BackCallback
import io.github.xxfast.decompose.router.LocalRouterContext
import molecule.ButtonPrimary
import molecule.PaddingWeight
import molecule.PaddingXL
import molecule.TextH2
import platformInsets

@Composable
internal fun SuccessRegistrationContent(
    toTrainings: () -> Unit
) {

    Content(
        toTrainings = toTrainings
    )
}

@Composable
private fun Content(
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

        TextH2(provideText = { "Success Registration!" })

        PaddingWeight()

        ButtonPrimary(
            text = "Go Workout",
            onClick = toTrainings
        )

        PaddingXL()
    }
}