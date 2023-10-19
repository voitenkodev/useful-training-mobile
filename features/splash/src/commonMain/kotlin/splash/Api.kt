package splash

import androidx.compose.runtime.Composable
import rememberViewModel
import splash.screen.SplashContent
import splash.screen.SplashViewModel

@Composable
public fun SplashFeature(
    toTrainings: () -> Unit,
    toAuthentication: () -> Unit,
) {
    val vm = rememberViewModel(SplashViewModel::class) { SplashViewModel() }

    SplashContent(
        vm = vm,
        toTrainings = toTrainings,
        toAuthentication = toAuthentication,
    )
}
