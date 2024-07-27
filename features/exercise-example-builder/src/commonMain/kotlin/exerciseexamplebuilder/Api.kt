package exerciseexamplebuilder

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import exerciseexamplebuilder.main.ExerciseExampleBuilderContent
import exerciseexamplebuilder.main.ExerciseExampleBuilderViewModel
import io.github.xxfast.decompose.router.rememberOnRoute
import io.github.xxfast.decompose.router.stack.RoutedContent
import io.github.xxfast.decompose.router.stack.Router
import io.github.xxfast.decompose.router.stack.rememberRouter
import kotlinx.serialization.Serializable

@Serializable
public sealed class ExerciseExampleBuilderFeature {
    @Serializable
    public data object Main : ExerciseExampleBuilderFeature()
}

@Composable
public fun ExerciseExampleBuilderGraph(
    close: () -> Unit
) {

    val router: Router<ExerciseExampleBuilderFeature> =
        rememberRouter(ExerciseExampleBuilderFeature::class) {
            listOf(ExerciseExampleBuilderFeature.Main)
        }

    RoutedContent(router = router, animation = stackAnimation(fade())) { child ->
        when (child) {
            is ExerciseExampleBuilderFeature.Main -> {
                val vm = rememberOnRoute(ExerciseExampleBuilderViewModel::class) {
                    ExerciseExampleBuilderViewModel()
                }
                ExerciseExampleBuilderContent(vm = vm, close = close)
            }
        }
    }
}