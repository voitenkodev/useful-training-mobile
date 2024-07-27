package exerciseexample

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.extensions.compose.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation
import exerciseexample.main.ExerciseExampleContent
import exerciseexample.main.ExerciseExampleViewModel
import io.github.xxfast.decompose.router.rememberOnRoute
import io.github.xxfast.decompose.router.stack.RoutedContent
import io.github.xxfast.decompose.router.stack.Router
import io.github.xxfast.decompose.router.stack.rememberRouter
import kotlinx.serialization.Serializable

@Serializable
public sealed class ExerciseExampleFeature {
    @Serializable
    public data object Main : ExerciseExampleFeature()
}

@Composable
public fun ExerciseExampleGraph(
    id: String,
    primaryAction: (Pair<String, (id: String) -> Unit>)?,
    close: () -> Unit
) {

    val router: Router<ExerciseExampleFeature> = rememberRouter(ExerciseExampleFeature::class) {
        listOf(ExerciseExampleFeature.Main)
    }

    RoutedContent(router = router, animation = stackAnimation(fade())) { child ->
        when (child) {
            is ExerciseExampleFeature.Main -> {
                val vm = rememberOnRoute(ExerciseExampleViewModel::class) {
                    ExerciseExampleViewModel(id)
                }
                ExerciseExampleContent(vm = vm, primaryAction = primaryAction, close = close)
            }
        }
    }
}