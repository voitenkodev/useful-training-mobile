package splash

import androidx.compose.runtime.Composable
import io.github.xxfast.decompose.router.rememberOnRoute
import splash.screen.SplashContent
import splash.screen.SplashViewModel

@Composable
public fun SplashFeature(
    toTrainings: () -> Unit,
    toAuthentication: () -> Unit,
) {
    val vm = rememberOnRoute(SplashViewModel::class) { SplashViewModel() }

    SplashContent(
        vm = vm,
        toTrainings = toTrainings,
        toAuthentication = toAuthentication,
    )
}
