package exerciseexamplebuilder

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize
import exerciseexamplebuilder.main.ExerciseExampleBuilderContent
import exerciseexamplebuilder.main.ExerciseExampleBuilderViewModel
import io.github.xxfast.decompose.router.Router
import io.github.xxfast.decompose.router.content.RoutedContent
import io.github.xxfast.decompose.router.rememberOnRoute
import io.github.xxfast.decompose.router.rememberRouter

@Parcelize
public sealed class ExerciseExampleBuilderFeature : Parcelable {
    public data object Main : ExerciseExampleBuilderFeature()
}

@Composable
public fun ExerciseExampleBuilderGraph(
    close: () -> Unit
) {

    val router: Router<ExerciseExampleBuilderFeature> = rememberRouter(ExerciseExampleBuilderFeature::class) {
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