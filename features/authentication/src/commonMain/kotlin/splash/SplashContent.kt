package splash

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import controls.primaryBackground

@Composable
fun SplashContent(
    vm: SplashViewModel,
    toTrainings: () -> Unit,
    toAuthentication: () -> Unit
) {

    LaunchedEffect(Unit) {
        vm.subscribeToken(
            onAuth = toTrainings,
            onNonAuth = toAuthentication
        )
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .primaryBackground()
    )
}
