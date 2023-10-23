package configurations

import androidx.compose.runtime.Composable
import configurations.screen.ConfigurationsViewModel
import configurations.screen.StatisticsContent
import io.github.xxfast.decompose.router.rememberOnRoute

@Composable
public fun WikiFeature() {

    val vm = rememberOnRoute(ConfigurationsViewModel::class) {
        ConfigurationsViewModel()
    }

    StatisticsContent(
        vm = vm
    )
}