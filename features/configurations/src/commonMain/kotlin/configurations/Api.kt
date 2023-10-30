package configurations

import androidx.compose.runtime.Composable
import configurations.screen.ConfigurationsContent
import configurations.screen.ConfigurationsViewModel
import io.github.xxfast.decompose.router.rememberOnRoute

@Composable
public fun ConfigurationsFeature(
    toExerciseExampleBuilder: (id: String?) -> Unit
) {

    val vm = rememberOnRoute(ConfigurationsViewModel::class) {
        ConfigurationsViewModel()
    }

    ConfigurationsContent(
        vm = vm,
        toExerciseExampleBuilder = toExerciseExampleBuilder
    )
}