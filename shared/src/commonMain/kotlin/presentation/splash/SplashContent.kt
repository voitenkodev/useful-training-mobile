package presentation.splash

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import controls.primaryBackground

@Composable
internal fun SplashContent(vm: SplashViewModel) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .primaryBackground()
    )
}
