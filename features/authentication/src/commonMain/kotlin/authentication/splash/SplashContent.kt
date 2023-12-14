package authentication.splash

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import authentication.splash.models.TokenStatus
import molecule.primaryBackground

@Composable
internal fun SplashContent(
    vm: SplashViewModel,
    toTrainings: () -> Unit,
    toAuthentication: () -> Unit
) {

    val state by vm.state.collectAsState()

    LaunchedEffect(state.tokenStatus) {
        if (state.tokenStatus == TokenStatus.Available) toTrainings.invoke()
        else if (state.tokenStatus == TokenStatus.Unavailable) toAuthentication.invoke()
    }

    Content()
}

@Composable
private fun Content() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .primaryBackground()
    )
}
