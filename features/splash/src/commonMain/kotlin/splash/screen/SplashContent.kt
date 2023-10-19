package splash.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import controls.rootBackground

@Composable
internal fun SplashContent(
    vm: SplashViewModel,
    toTrainings: () -> Unit,
    toAuthentication: () -> Unit
) {

    LaunchedEffect(Unit) {
        vm.checkToken(
            onAuth = toTrainings,
            onNonAuth = toAuthentication
        )
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .rootBackground()
    )
}
