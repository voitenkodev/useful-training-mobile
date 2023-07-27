package presentation.splash

import androidx.compose.runtime.Composable
import components.Loading

@Composable
internal fun SplashContent(vm: SplashViewModel) {
    Loading { true }
}
